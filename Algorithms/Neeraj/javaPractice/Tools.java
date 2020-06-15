package javaPractice;

import java.util.Arrays;
import java.util.List;

/**
 * Created on:  May 25, 2020
 */
public class Tools {
    public static void main(String[] args) {

        getContest("Find Two Non-overlapping Sub-arrays Each With Target Sum");
        System.out.println(getCamelCase("Running Sum of 1d Array"));
        System.out.println(getCamelCase("Least Number of Unique Integers after K Removals"));
        System.out.println(getCamelCase("Minimum Number of Days to Make m Bouquets"));
        System.out.println(getCamelCase("Kth Ancestor of a Tree Node"));

        System.out.println(getReplaced(
                "[[1,2],[1,3],[2,4]]",
                Arrays.asList("[", "{"),
                Arrays.asList("]", "}")
        ));
    }

    private static void getContest(String input) {
        String[] strings = input.split(",");
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
