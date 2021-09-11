import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created on:  Dec 14, 2020
 * Questions: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3565/
 */

public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(partition("efe"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, result, new LinkedList<>());
        return result;
    }

    private static void helper(String s, int i, List<List<String>> result, LinkedList<String> soFar) {
        if (i == s.length()) {
            result.add(new ArrayList<>(soFar));
        } else {
            String cur = "";
            for (int j = i; j < s.length(); j++) {
                cur += s.charAt(j);
                System.out.println("Starting = " + i + " End = " + j + " str = " + cur);
                if (isPalindrome(cur)) {
                    soFar.add(cur);
                    helper(s, j + 1, result, soFar);
                    soFar.removeLast();
                }
            }
        }
    }

    private static boolean isPalindrome(String input) {
        if (input.length() == 1) return true;
        int start = 0, end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start++) != input.charAt(end--)) return false;
        }
        return true;
    }
}
