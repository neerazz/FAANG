package weekly.weekly237;

import java.util.*;

/**
 * Created on:  Apr 17, 2021
 * Questions:
 */

public class MaximumIceCreamBars {

    public static void main(String[] args) {

    }

    public static int maxIceCream_greedy(int[] costs, int coins) {
        Arrays.sort(costs);
        long sum = 0, count = 0;
        for (int num : costs) {
            sum += num;
            if (sum <= coins) count++;
            else break;
        }
        return (int) count;
    }

    public static int maxIceCream(int[] costs, int coins) {
        int len = costs.length;
        int[][] dp = new int[len][coins + 1];
        Arrays.sort(costs);
        return helper(costs, 0, coins, dp);
    }

    private static int helper(int[] costs, int idx, int coins, int[][] dp) {
        if (idx == costs.length) return 0;
        if (coins <= 0) return 0;
        if (dp[idx][coins] > 0) return dp[idx][coins];
        dp[idx][coins] = helper(costs, idx + 1, coins, dp);
        if (costs[idx] <= coins) {
            int withtaking = helper(costs, idx + 1, coins - costs[idx], dp);
            dp[idx][coins] = Math.max(dp[idx][coins], withtaking + 1);
        }
        return dp[idx][coins];
    }
}
