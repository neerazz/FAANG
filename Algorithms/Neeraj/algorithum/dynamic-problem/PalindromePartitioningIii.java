/**
 * Created on:  Nov 17, 2020
 * Questions: https://leetcode.com/problems/palindrome-partitioning-iii/
 */

public class PalindromePartitioningIii {

    public static void main(String[] args) {
        System.out.println(palindromePartition("aabbc", 3));
    }

    public static int palindromePartition(String s, int k) {
        int len = s.length();
        if (len == k) return 0;
        Integer[][] dp = new Integer[len + 1][k + 1];
        return helper(s, 0, k, dp);
    }

    private static int helper(String s, int start, int k, Integer[][] dp) {
        if (start == s.length()) {
            if (k == 0) return dp[start][k] = 0;
            return Integer.MAX_VALUE;
        } else if (dp[start][k] != null) {
            return dp[start][k];
        } else if (k == 1) {
            return dp[start][k] = getCost(s, start, s.length() - 1);
        } else {
            int cur = Integer.MAX_VALUE;
            for (int i = start; i < s.length(); i++) {
                int next = helper(s, i + 1, k - 1, dp);
                if (next != Integer.MAX_VALUE) {
                    int curCost = getCost(s, start, i);
                    cur = Math.min(cur, next + curCost);
                }
            }
            return dp[start][k] = cur;
        }
    }

    private static int getCost(String str, int from, int to) {
        int cost = 0;
        while (from < to) {
            if (str.charAt(from++) != str.charAt(to--)) cost++;
        }
        return cost;
    }
}
