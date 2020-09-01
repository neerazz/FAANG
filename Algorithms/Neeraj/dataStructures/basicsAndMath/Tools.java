import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  May 25, 2020
 */
public class Tools {
    public static void main(String[] args) {
        System.out.println("************************* Contest ***********************************");
        getContest(
                "Detect Pattern of Length M Repeated K or More Times3\n" +
                        "Maximum Length of Subarray With Positive Product4\n" +
                        "Minimum Number of Days to Disconnect Island6\n" +
                        "Number of Ways to Reorder Array to Get Same BST"
        );
        System.out.println("************************* Top FB Questions ***********************************");
        printCamelCase(
//                "Merge k Sorted Lists",
//                "Product of Array Except Self",
        );
        getReplaced(
                Arrays.asList(
                        "[[46,89],[50,53],[52,68],[72,45],[77,81]]",
                        "[ [1,4], [2,3], [3,4] ]",
                        "[[1,2],[2,3],[0,1],[3,4]]",
                        "[ [1,2] ]",
                        "[ [3,4], [2,3], [1,2] ]"
                ),
                Arrays.asList("[", "{"),
                Arrays.asList("\"", "'"),
                Arrays.asList("]", "}")
        ).forEach(System.out::println);
    }

    private static void getContest(String input) {
        String[] strings = input.split("\n");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(getCamelCase(i != strings.length - 1 ? strings[i].substring(0, strings[i].length() - 1) : strings[i]));
        }
    }

    private static void printCamelCase(String... input) {
        Arrays.stream(input).map(Tools::getCamelCase).forEach(System.out::println);
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

    private static List<String> getReplaced(List<String> input, List<String>... replaces) {
        return input.parallelStream().map(val -> getReplaced(val, replaces)).collect(Collectors.toList());
    }

    private static String getReplaced(String input) {
        return input
                .replace("[", "{")
                .replace("]", "}")
                .replace("\"", "'");
    }

    private static String getReplaced(String input, List<String>... replaces) {
        for (List<String> replace : replaces) {
            input = input.replace(replace.get(0), replace.get(1));
        }
        return input;
    }
}
