package weekly.weekly227;

import java.util.*;

/**
 * Created on:  Feb 06, 2021
 * Questions:
 */

public class LargestMergeOfTwoStrings {

    public static void main(String[] args) {
        System.out.println(largestMerge("cabaa", "bcaaa"));
        System.out.println(largestMerge(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeqeeeeeeeeeeeeqeeeeeeeeeeeeeeeqeeeeeeeqeqeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeqeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeee",
                "eeeqeeeeeeqeeeeeeeeeeeeqqeeqeeqqeeeqeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeeeeqeqeeeqeeeqeeeeeeeeeeeqeeeeqeqeeqeqeeeeeqeeeqeeqeqeeeeeeeqeeqeqeeeeeeeeqeqeqeeeqeeeeqeeeeqeeeqeeeqeeeeeeqeeeeeeeeeeeeqeeeeeeeeeeeeeeeeeqeeeeeeqeqqeqeeeeeeeeeqqeeeqeqeeqeeeeeeeeeqeeeeqeeeqeeeeeqeeqeeeqqeeeeeeeeqeeeeeeeeeeeeeeqqeeqqqeeeqeeeeeeeeqeeqeeeeeqeqqeqeeqqeeeeeeeeeeqeqeqeeeeeqeeeeeeeeeqeqeeeeeeqqeeeqeeeeqeeeeeeqeeqeeeeqeeeeeeeqeeqeeeeqeeqeeeeeeeeeeeqqeeeeeeeqeeeeeqeeqeeeeeeqeqeeeqeeeeeeeeqeeeeeqeeeeeeeeeeqeqeeeeqqqeeeeeeqqqeeeeeqeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeqeeqqeeqeeeeeeeeeeeeeeqeeqqeeeqeeeeeeeeeeeqeeeeqeeeeeeeeeeeeqeeeeeqeeeeeeeeeeeqeqqeqqeeeeeeeeeeqqeeeeeeeeeqeeeeeeeeeeeeeeeeeeeqeeqqeeqeeeeeeqeeqeeeqeeeeeeqeeeeqeeqeqqqeeeqeeeeeeeeqqeeqeeeeqeeeeqeeeeeeeeeqqeeqqeeeeeeqeeeeeeeeqqeeeeeeeqeeeeeeeeeeeeqeeqeeeeeeeeeqeqeeqeeeeeeeeeeqeeqeeeeeeqeeeqeeeeeeeeeqqeeqqeeeeeqeeeqeeeeeeeeeeeeeeeeqeqeeeeeeqeeqeeeqeeeqeeqeeqeeeeeeqqeeeeeeeeeqqqeqqeeeqeeeeqqeeqqqeeeqeeeeqeeeeeeeeqeeeeqqqeeeeqeeeeqeqqeeqeeeeeeeeeeqeeeeeqqqeeqeeeeeeeeeeeqeeeeqeeeeeeeeeeqeeeqeeqeeeeeeqqeqeqqeeeeeeeeeeeeeeeeeeeeqeeeeeeeeeqqeeeeeeeeeeeeeqqeqeqeeeeeeqeeeeqqqeeeqqeqqeeeeeeeeeeeeeeeeeeeeeeeeeeeqeeeeeeqeqeeeeeeeeeeeeeeeeeqqqeeqeeeeqeeeeeqqeeeeeeeqeeeeeqqeeqqqqeeeeeeeeeeeqeeeeeeeeeeqeeqeeqeeeeeeeeeeeeqeqeeqeeeeeqqeeeeqqeeeqqeeeeeeeeeeqeeeqqeeeqeeeeeeqeeqqeeeqeqqeeeqeqeqqeeeqeeeeeeeqeeeqeeeeeeqqeeqeeqeeeeeqeeeeqeeqeeqeqeeeeeeqeeeeqeeqeeeeeqeeqeqeeeeeeqeeeeeeeeeeeeeeqeeqeeqeeeeeeeqeeqeeeeeeeqeeeeeeeeeeeeeqqeeeeeeqeeeeqeeqeqeeeeeeeeqeqeqeeeeeeeqeqeeeeeeeeqeeeqeeeeeeeeeeeeeeqeeqeeeeeeeqeeeeeeeeeeeqqeeeqeqqeeeeeeeqeeeeeqeeqeeeeqeeqeeeqeeeeeqqeeqeeeqeeeeeqeeeeeqeqeeqqeeeeqeeeeeeeeeeeeeeeeeqeqeeeeqeeqeqeqeeeeeeeeqeeeeeqqeeeqeeeeqqeeeeeeqeeeeeeqeeeqeeeeeeeeeeqqeeeeeeeeqeeeqeeqeeeeeeqeeqeeeeeeeeqeqeeeeeeeeeeqeeeeeeeeqeqeqqeeeqeeeeqeeeeeeqeeeeqeeeqeeeeeeeeqeqqqqeqeeeeeqeeeqeeeeeeeqeqeeqeeeqeeeqeeeqeeeeeeqqqeqeeqeeeeeeqeqeqeeeeeeeeeqeqeeqeeqeeeeeeeeeqeeeeeeeeeeeeeeeeeeeeeeqqqeeeeeeqeqeqeeqqeeeqqeeeqeeeeeqeeqeqeeqeeeeeeeeqeeeqeeeeeeeqeeeeeqeqeqeqeqeeeeeeeeqeeeeqqqqeeeeqeeeeeeeeeeqeeqeeeqeeeqeeeeqeeeeeeqqqqeeqeeqeeeeeeqqeeeeeeeeeqeqqeeeeeeqeeeeeqeqeeqqeeqqeeeeeeeqqqeeeeeeeeeqeeeeeqeqeeeeeeeqqqqqeeqeeqeeeeqeeeeeqeeeeeeeeqeqeeeeeeeeeeqeeqeeeeeeeeeeeeqqeeeqqeeeeeeeeeeqeqeeeqeeeeeeeqeeeeeeeeeeeeeeeqeeeeeeqqeeqeqeeeeeeeqeqeqqeeeqeeeqeeeqeeeeeqqeeeeeeqeeqqeeeeeeeeqeeeeeqeeeeeeeeeeeeeeeqeeeeqqeeeeeqeeqeeeeqqeeeeeeeqeeeeqqeeeqeqeqeeeeeqeeeeeeqeqeeeeqeeeeqeeeeqeeqeeeeqqeeeeeeeqeeeeeeeeeqeqeeeeeeeeeqeqeeeeeqeqeqqeqeqeeeqeeeqeqeqqqqqeeqeeeeqeeeqeeeqeeqeeeqeeeeeeqqeeeqeeeeeeeeeeeeeeqeqeeqeeeeqeeqeeeqqeeeeeeeeeeeeeqeeqeeeeeeeeeqeeeqqeeeeeeeeeeqeeeeeqeeeeeeeqeeeeeeeeeeeeeeeeqeeeeee")
        );
        System.out.println(largestMerge(
                "jbjjjjjjjjbjbbjjbjbbbjbbjbjjbjjjjbbbjjjjjjbjjbjbbjjbbbbbjjjbbbjjbjjbbbbjbjjjjbjbjbjjbbjjbbjjjbbbbjbjjbbjjjjjjbjjbbbjbbjjjjjjjjbbbbjjbjjbjbbjbjjjjbjbjjbjbjbbjbjjbjjbbjjjjjjjjbjbbbbjjjbjbbbbbbjbjjbbjbbbjjjbbbjbbbjjbjjbbjjjjjbjbbjbbbbbbjjjbjbbjjjjbbjbjbbjbjjjjjbjbbbbjbjbjjjjjjjjbbjjjjbjjbbjbjbbjjbjjbbbbjbbjbbjjjjjbbjbbbjjbbjjbbjjbjbjjbjjbjjbbbjbbjjjjjjjbbbbbbjbbjjbjbbbbjjbbbjjbjjjbjbbbjjbjbjjbjjjjbbbjbjjbbbjjjjbjbjbjjjbjbjjbbjbbjjbjjbjjjbjbbjbbjjjjbjbbjbjbbjjbbjjjbjbjbjjjjjbbjjbbbjbbbbbbbjbjjjbbjjjbbjbbbbjjjjjjjbbbjjbjjjjbbbbjjjjbjjbjbbjjjbbbbjbbjjjjjjbjjjjjjbjjbjbbbbbbbbjbjbbbbjjjjjjbjbjjjbjbjjjjjbbbjbbjbbjjbbjbjjjjjjjjbbjbjbjbjjjjjjbbjjjbbjbbjjbbjjbjjbjbbjjbjbbjjjjbjjbbjbjbjjbjjbjbbjbbbjbjjbjbbbbjjjbjjjbjjbjjbbjbbjjbbbbjjjjjbjbbjbbbjjbjjjbjbbjjjbbbjjbjbbbjbbbjbjbjjbbjjjbbjjbbbbbjjjjbbbjbbjjjbbbjjbbbbbbjbbjbbjjbjjjjjbbjbjbjbjjbjjbjjjjbbjjjjbjbjjjjjbbjjjbbjbjjjbjjjjjjjjbjbbjbjbjjjbjbjjbjjjjbbbbbjbbbbjbbbjjbjbbjjbbbjjbbbbjbjjjbbjbjjjbjjjjjbjjbbbbbjjjbjbjbbbjbjjjbjjjjjjbjjbbbbjjbbbbjjjjbbbbbbbjbbjbjbbjjbbjbjjjbjjjjbbbjbjjbjbjjbjbbjjjjjbbbjbjjbbbbjjjbbjjjjjbjjbjjbbjbjjjbjjjjbbbjjjbjbbjbjbbjjbbbjbjjjbbbjjjbjjbbjbbbjjbjbjjbjbjbbbbbbbjjbjjbbjjbjbjjbbjbjbjbjjjjjjjbjjjjbjbjjjbjjjbjbjjbbjjbjjbbjjjjjbbjjjjbjbbbbbjjbbbbjbbbbbbjjjjjbjjbjbjjjbbbbjjjbjjbjbjjbbbjjjbjbjbjbjjbbbjbbjbbbbbjjjbjbbjjbjbbjbbjbjjbbbbjbbbjbjjbjjbjbjjbjjjjjbjbbbbjbjbbjjjjbjjbjbjjbjjbjbbbbjbjbbjbbbbbjjjbbjbbjjjjjbbbjjjbjbjjbjbjbbbjjbbbjjbjbbbbjbjbjbbbjbbbjbbjbbjjjbbjbbjbbbbjjjbbjjbbbbjjbbjjbbbbbbjbjbjjjbbbjbbjjbjbbbjbbjjjjjjjjjjjbbjbbjbjbjjjbjbbjjjjbbjjbjjbbjjjbbbjjjbbjbjbjjbjjjjjbbjbbbbjjjbbjjjjjbbbbbjbbjjjjbbjjjjbbbbjjjbjjbjbbbjjbbbjjbjjjbjbbbjjjjbbbbbbjjbbbbbbjjbbjjbjjbbjbjbjjbbjbbjbbbbjjjjjbjjjjbjjbbjjjjbjjbjjbbjjjjjbjjjjbjbbbjjbbbjjjbjbjbbjjjjbjjjbjbjbjbbjjjbjbjbjbjjbjbbbbjbbjbbjjbbbjbjjbjbbbbjjjjjjbjbbjbbbbbjbbbbbbbjbjbbbbbbjjjbjjjbbbjbjbbjbbjjbbbbbjjjjjbjbjbjbjjjbbjbjjbbbbjbbbbbjbjjjjjjjbbbbjjjbjbbbbjbjjjbjjbjjbbjbjjbjbbjbbjbbbbbbbbjbjjbbjbbjbjjjjjbjjjjjbbjjbjjbbjbjjjjjjjbbbbbbjbbbbjbjbbjjbjbbjbbbbjbjbbjjbjbjjjbjjbbbbbbbbjjbjjjjjbjbbjjjjjbbjjbbbbjjjjbbbbbjjbjbbbjjjjjjbbbbbjjbjbjbjjbbbjbbjbjjbbbbjjbjbbjjjjbbjbbbjjbbbjjbbjjjjjbjjbjjbjbbjbbjbbjbjjbbbjjbjjbbbjbbbjjjbbjjbjbjbbjjjbbbjjbjbbjjbbbjbbjbbbbjjbjjbjjjjjjjjbbbjjjbjjbbbbjbjjbjbbjbjjjbjbjbjjbbjjbjjjbbbjbbjbjjbjbjbbbbjjbbbbjjbjbbbbjjjbbbbbbbbbbbbbjbjbbjbbjbbbbjjbjjbjbbbjbjbjbjbbbjjbbjbbjbbjbjbbjbjjjbbbbbbjbbbjbjjbjbjjjjjbjjjbjjbbbbbjjjbjjbbbbjjbbbjjjjjbbbjjjbjjbbbjbjbbjbbbbbjbjjjbjbbjjbjbbjjbbjbjbbjjjjbjbbjjjbjbjjbbjjbjbbjjbjjjjbjjjbbbbbbbjjbbbjbjbjbbjjjjjbbbbbbbjjjjjjjbbjbjjjbjbbjbjbbjjjjbbjjjbbjjbjbbjjjjbbbbbjbjbjbbjjbjjbbbjjbbbjbjjjjbbbbjbjbbjbjbbbbjbjjjjbjjjbjjjjjjjbjjbbjbbbjjjjbbbjjjbjjjbbjjjjjbbbjjjbjbjjbjbbjbjjbbjjbjbbjbbjbbbbbbbbjbjbbbbbjbbbjjbbbbjjjbjjjbbbjjjjjbbjjbbjjbbbjjjjjbbjbjbjjjbjjjjjjbjjbjbbbjbbjjbjbbjjjjjbbbbjbbbjjjjjjjjjbbbjbjbjjbbjjjjbjbjjjjjbjjjbjbjbjbbbbjjjjjbbbjbjjjjbjbjjjjbjjbbjbjbjbjbbjbjbjbjjbbjbjjbbjjbbbbbjjjjjbbjjbjbbbbjbbbjbbbbjbbjbjbbbbjbbbjbjjjbbbjbbjjjjbbjbjbjjjjbjbbjbbbjjbjjjbjjbbbjbjbbbbjjbbbjbbjjbbjj",
                "jbjjjjjjjjbjbbjjbjbbbjbbjbjjbjjjjbbbjjjjjjbjjbjbbjjbbbbbjjjbbbjjbjjbbbbjbjjjjbjbjbjjbbjjbbjjjbbbbjbjjbbjjjjjjbjjbbbjbbjjjjjjjjbbbbjjbjjbjbbjbjjjjbjbjjbjbjbbjbjjbjjbbjjjjjjjjbjbbbbjjjbjbbbbbbjbjjbbjbbbjjjbbbjbbbjjbjjbbjjjjjbjbbjbbbbbbjjjbjbbjjjjbbjbjbbjbjjjjjbjbbbbjbjbjjjjjjjjbbjjjjbjjbbjbjbbjjbjjbbbbjbbjbbjjjjjbbjbbbjjbbjjbbjjbjbjjbjjbjjbbbjbbjjjjjjjbbbbbbjbbjjbjbbbbjjbbbjjbjjjbjbbbjjbjbjjbjjjjbbbjbjjbbbjjjjbjbjbjjjbjbjjbbjbbjjbjjbjjjbjbbjbbjjjjbjbbjbjbbjjbbjjjbjbjbjjjjjbbjjbbbjbbbbbbbjbjjjbbjjjbbjbbbbjjjjjjjbbbjjbjjjjbbbbjjjjbjjbjbbjjjbbbbjbbjjjjjjbjjjjjjbjjbjbbbbbbbbjbjbbbbjjjjjjbjbjjjbjbjjjjjbbbjbbjbbjjbbjbjjjjjjjjbbjbjbjbjjjjjjbbjjjbbjbbjjbbjjbjjbjbbjjbjbbjjjjbjjbbjbjbjjbjjbjbbjbbbjbjjbjbbbbjjjbjjjbjjbjjbbjbbjjbbbbjjjjjbjbbjbbbjjbjjjbjbbjjjbbbjjbjbbbjbbbjbjbjjbbjjjbbjjbbbbbjjjjbbbjbbjjjbbbjjbbbbbbjbbjbbjjbjjjjjbbjbjbjbjjbjjbjjjjbbjjjjbjbjjjjjbbjjjbbjbjjjbjjjjjjjjbjbbjbjbjjjbjbjjbjjjjbbbbbjbbbbjbbbjjbjbbjjbbbjjbbbbjbjjjbbjbjjjbjjjjjbjjbbbbbjjjbjbjbbbjbjjjbjjjjjjbjjbbbbjjbbbbjjjjbbbbbbbjbbjbjbbjjbbjbjjjbjjjjbbbjbjjbjbjjbjbbjjjjjbbbjbjjbbbbjjjbbjjjjjbjjbjjbbjbjjjbjjjjbbbjjjbjbbjbjbbjjbbbjbjjjbbbjjjbjjbbjbbbjjbjbjjbjbjbbbbbbbjjbjjbbjjbjbjjbbjbjbjbjjjjjjjbjjjjbjbjjjbjjjbjbjjbbjjbjjbbjjjjjbbjjjjbjbbbbbjjbbbbjbbbbbbjjjjjbjjbjbjjjbbbbjjjbjjbjbjjbbbjjjbjbjbjbjjbbbjbbjbbbbbjjjbjbbjjbjbbjbbjbjjbbbbjbbbjbjjbjjbjbjjbjjjjjbjbbbbjbjbbjjjjbjjbjbjjbjjbjbbbbjbjbbjbbbbbjjjbbjbbjjjjjbbbjjjbjbjjbjbjbbbjjbbbjjbjbbbbjbjbjbbbjbbbjbbjbbjjjbbjbbjbbbbjjjbbjjbbbbjjbbjjbbbbbbjbjbjjjbbbjbbjjbjbbbjbbjjjjjjjjjjjbbjbbjbjbjjjbjbbjjjjbbjjbjjbbjjjbbbjjjbbjbjbjjbjjjjjbbjbbbbjjjbbjjjjjbbbbbjbbjjjjbbjjjjbbbbjjjbjjbjbbbjjbbbjjbjjjbjbbbjjjjbbbbbbjjbbbbbbjjbbjjbjjbbjbjbjjbbjbbjbbbbjjjjjbjjjjbjjbbjjjjbjjbjjbbjjjjjbjjjjbjbbbjjbbbjjjbjbjbbjjjjbjjjbjbjbjbbjjjbjbjbjbjjbjbbbbjbbjbbjjbbbjbjjbjbbbbjjjjjjbjbbjbbbbbjbbbbbbbjbjbbbbbbjjjbjjjbbbjbjbbjbbjjbbbbbjjjjjbjbjbjbjjjbbjbjjbbbbjbbbbbjbjjjjjjjbbbbjjjbjbbbbjbjjjbjjbjjbbjbjjbjbbjbbjbbbbbbbbjbjjbbjbbjbjjjjjbjjjjjbbjjbjjbbjbjjjjjjjbbbbbbjbbbbjbjbbjjbjbbjbbbbjbjbbjjbjbjjjbjjbbbbbbbbjjbjjjjjbjbbjjjjjbbjjbbbbjjjjbbbbbjjbjbbbjjjjjjbbbbbjjbjbjbjjbbbjbbjbjjbbbbjjbjbbjjjjbbjbbbjjbbbjjbbjjjjjbjjbjjbjbbjbbjbbjbjjbbbjjbjjbbbjbbbjjjbbjjbjbjbbjjjbbbjjbjbbjjbbbjbbjbbbbjjbjjbjjjjjjjjbbbjjjbjjbbbbjbjjbjbbjbjjjbjbjbjjbbjjbjjjbbbjbbjbjjbjbjbbbbjjbbbbjjbjbbbbjjjbbbbbbbbbbbbbjbjbbjbbjbbbbjjbjjbjbbbjbjbjbjbbbjjbbjbbjbbjbjbbjbjjjbbbbbbjbbbjbjjbjbjjjjjbjjjbjjbbbbbjjjbjjbbbbjjbbbjjjjjbbbjjjbjjbbbjbjbbjbbbbbjbjjjbjbbjjbjbbjjbbjbjbbjjjjbjbbjjjbjbjjbbjjbjbbjjbjjjjbjjjbbbbbbbjjbbbjbjbjbbjjjjjbbbbbbbjjjjjjjbbjbjjjbjbbjbjbbjjjjbbjjjbbjjbjbbjjjjbbbbbjbjbjbbjjbjjbbbjjbbbjbjjjjbbbbjbjbbjbjbbbbjbjjjjbjjjbjjjjjjjbjjbbjbbbjjjjbbbjjjbjjjbbjjjjjbbbjjjbjbjjbjbbjbjjbbjjbjbbjbbjbbbbbbbbjbjbbbbbjbbbjjbbbbjjjbjjjbbbjjjjjbbjjbbjjbbbjjjjjbbjbjbjjjbjjjjjjbjjbjbbbjbbjjbjbbjjjjjbbbbjbbbjjjjjjjjjbbbjbjbjjbbjjjjbjbjjjjjbjjjbjbjbjbbbbjjjjjbbbjbjjjjbjbjjjjbjjbbjbjbjbjbbjbjbjbjjbbjbjjbbjjbbbbbjjjjjbbjjbjbbbbjbbbjbbbbjbbjbjbbbbjbbbjbjjjbbbjbbjjjjbbjbjbjjjjbjbbjbbbjjbjjjbjjbbbjbjbbbbjjbbbjbbjjbbjj")
        );
    }

    public static String largestMerge(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) return s1 + s2;
        int compare = s1.compareTo(s2);
        if (compare > 0) return s1.charAt(0) + largestMerge(s1.substring(1), s2);
        return s2.charAt(0) + largestMerge(s1, s2.substring(1));
    }

    public static String largestMerge_recursion(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        String[][] dp = new String[l1 + 1][l2 + 1];
        char[] c1 = word1.toCharArray(), c2 = word2.toCharArray();
        return helper(c1, c2, dp);
    }

    private static String helper(char[] c1, char[] c2, String[][] dp) {
        int l1 = c1.length, l2 = c2.length;
        if (l1 == 0 && l2 == 0) return "";
        if (l1 == 0) return dp[l1][l2] = String.valueOf(c2);
        if (l2 == 0) return dp[l1][l2] = String.valueOf(c1);
        if (dp[l1][l2] != null) return dp[l1][l2];
        if (Arrays.equals(c1, c2)) return dp[l1][l2] = String.valueOf(c1) + String.valueOf(c2);
        String merge = "";
        if (c1[0] > c2[0]) {
            merge = c1[0] + helper(Arrays.copyOfRange(c1, 1, l1), c2, dp);
        } else if (c1[0] < c2[0]) {
            merge = c2[0] + helper(c1, Arrays.copyOfRange(c2, 1, l2), dp);
        } else {
            String m1 = helper(Arrays.copyOfRange(c1, 1, l1), c2, dp);
            String m2 = helper(c1, Arrays.copyOfRange(c2, 1, l2), dp);
            if (m1.compareTo(m2) >= 0) {
                merge = c1[0] + m1;
            } else {
                merge = c2[0] + m2;
            }
        }
        return dp[l1][l2] = merge;
    }

    public static String largestMerge_dp(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        String[][] dp = new String[l1 + 1][l2 + 1];
        Arrays.fill(dp[l1], word2);
        for (int i = 0; i <= l2; i++) dp[i][l2] = word1;
        char[] c1 = word1.toCharArray(), c2 = word2.toCharArray();
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                if (c1[i] > c2[j]) {
                    dp[i][j] = c1[i] + dp[i + 1][j];
                } else if (c1[i] < c2[j]) {
                    dp[i][j] = c2[i] + dp[i + 1][j];
                } else {
                    if (dp[i + 1][j].compareTo(dp[i][j + 1]) >= 0) {
                        dp[i][j] = c1[i] + dp[i + 1][j];
                    } else {
                        dp[i][j] = c2[i] + dp[i + 1][j];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
