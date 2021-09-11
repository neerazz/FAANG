/**
 * Created on:  Mar 02, 2021
 * Questions: https://leetcode.com/problems/integer-break/
 */

public class IntegerBreak {

    public static void main(String[] args) {

    }

    public static int integerBreak(int n) {
        Integer[] dp = new Integer[n + 1];
        return helper(n, 0, dp);
    }

    private static int helper(int val, int div, Integer[] dp) {
        if (val <= 1) return 1;
        if (dp[val] != null) return dp[val];
        int max = (div == 0) ? 0 : val;
        for (int i = 1; i < val; i++) {
            int next = helper(val - i, div + 1, dp);
            if (i * next > max) {
                max = i * next;
            }
        }
        return dp[val] = max;
    }
}
