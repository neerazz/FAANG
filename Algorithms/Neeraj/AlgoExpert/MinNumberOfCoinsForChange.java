/**
 * Created on:  Sep 10, 2020
 * Questions:
 */
public class MinNumberOfCoinsForChange {
    public static void main(String[] args) {

    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        if (n == 0) return 0;
// 		dp[x] = minum number of coins to make x amount
        Integer[] dp = new Integer[n + 1];
        helper(n, denoms, dp);
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

    private static int helper(int target, int[] coins, Integer[] dp) {
        if (target < 0) return Integer.MAX_VALUE;
        if (target == 0) return 0;
        if (dp[target] != null) return dp[target];
        int cur = Integer.MAX_VALUE;
        for (int coin : coins) {
            int next = helper(target - coin, coins, dp);
            if (next != Integer.MAX_VALUE) {
                cur = Math.min(cur, next + 1);
            }
        }
        return dp[target] = cur;
    }
}
