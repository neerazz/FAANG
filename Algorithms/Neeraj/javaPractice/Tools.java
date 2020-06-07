package javaPractice;

import java.util.Arrays;
import java.util.List;

/**
 * Created on:  May 25, 2020
 */
public class Tools {
    public static void main(String[] args) {

        System.out.println(getCamelCase("Shuffle the Array"));
        System.out.println(getCamelCase("The k Strongest Values in an Array"));
        System.out.println(getCamelCase("Design Browser History"));
        System.out.println(getCamelCase("Paint House III"));

        System.out.println(getReplaced(
                "[[1,2],[1,3],[2,4]]",
                Arrays.asList("[", "{"),
                Arrays.asList("]", "}")
        ));
    }

    private static String getCamelCase(String input) {
        StringBuilder sb = new StringBuilder();
        boolean capitalize = true;
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                if (sb.length() == 0 && Character.isDigit(c)) {
                    continue;
                } else if (capitalize) {
                    sb.append(Character.toUpperCase(c));
                    capitalize = false;
                } else {
                    sb.append(c);
                }
            } else {
                capitalize = true;
            }
        }
        return sb.toString();
    }

    private static String getReplaced(String input, List<String>... replaces) {
        for (List<String> replace : replaces) {
            input = input.replace(replace.get(0), replace.get(1));
        }
        return input;
    }
}
