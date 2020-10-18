import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  May 25, 2020
 */
public class Tools {
    public static void main(String[] args) {
        System.out.println("************************* Contest ***********************************");
        getContest(
                "Largest Substring Between Two Equal Characters3\n" +
                        "Lexicographically Smallest String After Applying Operations4\n" +
                        "Best Team With No Conflicts5\n" +
                        "Graph Connectivity With Threshold"
        );
        System.out.println("************************* Top FB Questions ***********************************");
        printCamelCase(
                "Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold"
//                "Product of Array Except Self",
        );
        getReplaced(
                Arrays.asList(
                        "[[3,46,2],[3,27,46],[7,25,50],[32,39,3],[4,42,37],[20,18,48],[13,16,23],[22,36,24],[40,7,26],[16,21,1],[46,33,34],[19,11,19],[31,22,41],[37,29,20],[18,29,28],[36,0,45],[39,22,37],[25,25,45],[0,31,15],[44,45,13],[18,47,23],[47,19,26],[48,18,32]]\n" +
                                "44",
                        "[[1,2],[3,4],[5,6],[7,8]]",
                        "[[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]",
                        "[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]"
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
