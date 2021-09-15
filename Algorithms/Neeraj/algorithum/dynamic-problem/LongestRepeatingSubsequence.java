/**
 * Created on:  Sep 11, 2021
 * Ref: https://www.codingninjas.com/codestudio/problems/longest-repeating-subsequence_1118110?topList=top-google-coding-interview-questions&leftPanelTab=1
 */
public class LongestRepeatingSubsequence {
    public static void main(String[] args) {

    }

    public static int longestRepeatingSubsequence(String st, int n) {
        if (n < 2) return 0;
        Integer[][] dp = new Integer[n][n];
        return helper(st, 0, 1, n, dp);
    }

    static int helper(String s, int p1, int p2, int len, Integer[][] dp) {
        if (p2 >= len || p1 == p2) return 0;
        if (dp[p1][p2] != null) return dp[p1][p2];
        int best = 0;
        if (s.charAt(p1) == s.charAt(p2)) {
            best = 1 + helper(s, p1 + 1, p2 + 1, len, dp);
        } else {
            best = Math.max(helper(s, p1 + 1, p2, len, dp), helper(s, p1, p2 + 1, len, dp));
        }
        return dp[p1][p2] = best;
    }
}
