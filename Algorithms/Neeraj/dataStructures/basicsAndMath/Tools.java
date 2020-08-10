import java.util.Arrays;
import java.util.List;

/**
 * Created on:  May 25, 2020
 */
public class Tools {
    public static void main(String[] args) {
        System.out.println("************************* Contest ***********************************");
        getContest(
                "Make The String Great3\n" +
                        "Find Kth Bit in Nth Binary String4\n" +
                        "Maximum Number of Non-Overlapping Subarrays With Sum Equals Target6\n" +
                        "Minimum Cost to Cut a Stick"
        );
        System.out.println("************************* Top FB Questions ***********************************");
        printCamelCase(
//                "Merge k Sorted Lists",
//                "Product of Array Except Self",
//                "Merge Intervals",
//                "Integer to English Words",
//                "Verifying an Alien Dictionary",
//                "Subarray Sum Equals K",
//                "Minimum Remove to Make Valid Parentheses",
//                "Alien Dictionary",
//                "K Closest Points to Origin",
//                "Next Permutation",
//                "Add Strings",
//                "Serialize and Deserialize Binary Tree",
//                "Merge Sorted Array",
//                "Kth Largest Element in an Array",
//                "Binary Tree Right Side View",
//                "Binary Tree Maximum Path Sum",
//                "Valid Palindrome II",
//                "Remove Invalid Parentheses",
//                "Interval List Intersections",
//                "Binary Search Tree Iterator",
//                "Vertical Order Traversal of a Binary Tree",
//                "Lowest Common Ancestor of a Binary Tree",
//                "Add Binary",
//                "Diameter of Binary Tree",
//                "Random Pick with Weight",
//                "Find All Anagrams in a String",
//                "Reorganize String",
//                "Add and Search Word - Data structure design",
//                "Read N Characters Given Read4 II - Call multiple times -> p",
//                "Valid Palindrome",
//                "Exclusive Time of Functions",
//                "Longest Substring with At Most K Distinct Characters -> p",
//                "Task Scheduler",
//                "Sparse Matrix Multiplication -> p",
//                "Continuous Subarray Sum",
//                "Valid Number",
//                "First Bad Version",
//                "Accounts Merge",
//                "Range Sum of BST",
//                "Is Graph Bipartite?",
//                "Expression Add Operators",
//                "Closest Binary Search Tree Value -> p",
//                "Missing Element in Sorted Array -> p",
//                "Maximum Swap",
//                "Group Shifted Strings -> p",
//                "Leftmost Column with at Least a One -> p",
//                "Random Pick Index",
//                "Maximum Sum of 3 Non-Overlapping Subarrays",
//                "Monotonic Array",
//                "Maximum Difference Between Node and Ancestor"
        );
        System.out.println(getReplaced(
                "[[1,1,1,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,0,0,1],[1,0,0,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,0,0,0],[0,0,0,1,1,1,1]]",
                Arrays.asList("[", "{"),
                Arrays.asList("]", "}")
        ));
        String[] str = "12.12".split("\\.");
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

    private static String getReplaced(String input, List<String>... replaces) {
        for (List<String> replace : replaces) {
            input = input.replace(replace.get(0), replace.get(1));
        }
        return input;
    }
}
