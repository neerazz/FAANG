package weekly.weekly184;/*
    Created on:  Apr 11, 2020
 */

/**
 * Questions:
 */
public class HTMLEntityParser {
    public static void main(String[] args) {
        System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(entityParser("and I quote: &quot;...&quot;"));
    }

    public static String entityParser(String text) {
        StringBuilder marker = new StringBuilder();
        StringBuilder output = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == ';') {
//                End the marker
                String temp = replaceString(marker.append(c).toString());
                if (temp == null) {
                    output.append(marker.toString());
                } else {
                    output.append(temp);
                }
                marker = new StringBuilder();
            } else if (c == '&' || marker.length() > 0) {
                marker.append(c);
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }

    private static String replaceString(String tag) {
        if (tag.equals("&quot;")) return "\"";
        if (tag.equals("&apos;")) return "'";
        if (tag.equals("&amp;")) return "&";
        if (tag.equals("&gt;")) return ">";
        if (tag.equals("&lt;")) return "<";
        if (tag.equals("&frasl;")) return "/";
        return null;
    }
}
