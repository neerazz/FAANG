/**
 * Created on:  Sep 19, 2021
 * Ref: https://leetcode.com/problems/distinct-subsequences
 */
public class DistinctSubsequences {
    public static void main(String[] args) {

    }

    public int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        Integer[][] dp = new Integer[l1][l2];
        return helper(s, 0, l1, t, 0, l2, dp);
    }

    int helper(String s, int i1, int l1, String t, int i2, int l2, Integer[][] dp) {
        if (i2 == l2) return i1 <= l1 ? 1 : 0;
        if (i1 == l1) return 0;
        if (dp[i1][i2] != null) return dp[i1][i2];
        int cur = 0;
        if (s.charAt(i1) == t.charAt(i2)) cur += helper(s, i1 + 1, l1, t, i2 + 1, l2, dp);
        cur += helper(s, i1 + 1, l1, t, i2, l2, dp);
        return dp[i1][i2] = cur;
    }
}
