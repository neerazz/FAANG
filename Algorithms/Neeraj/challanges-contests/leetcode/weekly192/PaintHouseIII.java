package weekly192;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jun 06, 2020
 * Questions: https://leetcode.com/problems/paint-house-iii
 */
public class PaintHouseIII {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3) + " should be [9].");
        System.out.println(minCost(new int[]{0, 2, 1, 2, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3) + " should be [11].");
        System.out.println(minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}}, 5, 2, 5) + " should be [5].");
        System.out.println(minCost(new int[]{3, 1, 2, 3}, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 4, 3, 3) + " should be [-1].");
    }

    public static int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Integer[][][] dp = new Integer[m][n + 1][m + 1];
        int val = helper(houses, 0, cost, 0, m, n, target, 0, dp);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    private static int helper(int[] houses, int house, int[][] cost, Integer preCol, int m, int n, int target, int neighbours, Integer[][][] dp) {
        if (neighbours > target) return Integer.MAX_VALUE;
        if (house == m) {
            return neighbours == target ? 0 : Integer.MAX_VALUE;
        }
        if (dp[house][preCol][neighbours] != null) return dp[house][preCol][neighbours];
        int cur = Integer.MAX_VALUE;
        if (houses[house] != 0) {
//            Then It is already painted, then the cost will not increase.
//                If colour is same, then just move to the next house, without increasing neighbours count.
//                If the colour is different then, increase the neighbours count and pass the current colour to the next call.
            cur = Math.min(cur, helper(houses, house + 1, cost, houses[house], m, n, target, (preCol == houses[house] ? neighbours : neighbours + 1), dp));
        } else {
//            Then we have to pick a colour, by looping through all the colours
            for (int i = 1; i <= n; i++) {
//                If the colour is same as previous then only increase the cost.
                int next = helper(houses, house + 1, cost, i, m, n, target, (preCol == i ? neighbours : neighbours + 1), dp);
                if (next != Integer.MAX_VALUE) {
                    cur = Math.min(cur, next + cost[house][i - 1]);
                }
            }
        }
        return dp[house][preCol][neighbours] = cur;
    }
}
