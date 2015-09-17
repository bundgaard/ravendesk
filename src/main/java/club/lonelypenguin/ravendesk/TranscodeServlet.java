/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ravendesk;

import RSSFeedParser.Feed;
import RSSFeedParser.RSSFeedParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author dbundgaard
 */
public class TranscodeServlet extends HttpServlet {

    private final String URL_MAPPING = "/transcode/";

    public String getPath(HttpServletRequest req) {
        String context = req.getContextPath();
        String request = req.getRequestURI();
        String query = req.getQueryString();

        return request.substring(context.length() + URL_MAPPING.length());
    }

    public List<NameValuePair> getQueryString(String query) {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        String[] lines = query.split("\n");
        for (String line : lines) {
            String[] keyVal = line.split("=");
            if (keyVal.length == 2) {
                nvps.add(new BasicNameValuePair(keyVal[0], keyVal[1]));
            }
        }
        return nvps;
    }

    public NameValuePair findQuery(String term, List<NameValuePair> query) {
        NameValuePair nvp = null;
        for (NameValuePair pair : query) {
            if (pair.getName().equals(term)) {
                nvp = pair;
                break;
            } else {
                return null;
            }

        }
        return nvp;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream out = resp.getOutputStream();
        String context = req.getContextPath();
        String query = req.getQueryString();
        String requestUri = req.getRequestURI();
        int indexOfContext = context.length();
        String urlToFetch = getPath(req);
        List<NameValuePair> queries = getQueryString(query);
        NameValuePair pair = null;
        if (queries.isEmpty()) {
            out.write("you didnt write anything.".getBytes());
        } else if ((pair = findQuery("q", queries)) != null) {
            System.out.println(pair.getName() + " = \"" + pair.getValue() + "\"");
            try {
                RSSFeedParser parser = null;
                if (pair.getValue().contains("/%")) {
                    parser = new RSSFeedParser(pair.getValue());
                } else {
                    parser = new RSSFeedParser(URLDecoder.decode(pair.getValue(), "utf-8"));
                }

                Feed f = parser.feed();
                ObjectMapper mapper = new ObjectMapper();
                resp.setCharacterEncoding("utf-8");
                resp.setContentType("application/json");
                out.write(mapper.writeValueAsBytes(f));
            } catch (RuntimeException e) {
                resp.sendError(404);
            }
        }

    }

}
