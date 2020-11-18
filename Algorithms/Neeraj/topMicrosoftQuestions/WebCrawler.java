import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 17, 2020
 * Questions: https://leetcode.com/problems/web-crawler/
 */

public class WebCrawler {

    public static void main(String[] args) {

    }

    public static List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String host = getHost(startUrl);
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        result.add(startUrl);
        visited.add(startUrl);
        int i = 0;
        while (i < result.size()) {
            String cur = result.get(i++);
            List<String> urls = htmlParser.getUrls(cur);
            // System.out.println(cur);
            // System.out.println("Linked : " + urls);
            for (String next : urls) {
                if (visited.contains(next)) continue;
                visited.add(next);
                String curHost = getHost(next);
                if (curHost.equals(host)) {
                    result.add(next);
                }
            }
        }
        return result;
    }

    private static String getHost(String url) {
        int backslash = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : url.toCharArray()) {
            if (c == '/') {
                backslash++;
            } else if (backslash == 2) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    interface HtmlParser {
        List<String> getUrls(String url);
    }
}
