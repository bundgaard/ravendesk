/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.lonelypenguin.ravendesk.httputil;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author dbundgaard
 */
public class HttpUtil {
    
    public static String getPath(HttpServletRequest req, String url_mapping) {
        String context = req.getContextPath();
        String request = req.getRequestURI();
        String query = req.getQueryString();

        return request.substring(context.length() + url_mapping.length());
    }

    public static List<NameValuePair> getQueryString(String query) {
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

    public static NameValuePair findQuery(String term, List<NameValuePair> query) {
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
}
