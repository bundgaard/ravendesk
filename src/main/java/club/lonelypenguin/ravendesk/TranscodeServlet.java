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
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        return "";
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletOutputStream out = resp.getOutputStream();
        String context = req.getContextPath();
        String query = req.getQueryString();
        String requestUri = req.getRequestURI();
        int indexOfContext = context.length();
        String urlToFetch = requestUri.substring(indexOfContext + URL_MAPPING.length());
        System.out.println(urlToFetch);
        if (!urlToFetch.equals("")) {
            RSSFeedParser parser = new RSSFeedParser(urlToFetch);
            Feed f = parser.feed();
            ObjectMapper mapper = new ObjectMapper();
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("application/json");
            out.write(mapper.writeValueAsBytes(f));
        } else {
            out.write("you didnt write anything.".getBytes());
        }

    }

}
