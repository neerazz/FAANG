package weekly.weekly192;

/**
 * Created on:  Jun 06, 2020
 * Questions: https://leetcode.com/problems/paint-house-iii
 */
public class PaintHouseIII {
    public static void main(String[] args) {
        System.out.println("****************************************** Solution 1 *******************************************");
        System.out.println(minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3) + " should be [9].");
        System.out.println(minCost(new int[]{0, 2, 1, 2, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3) + " should be [11].");
        System.out.println(minCost(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}}, 5, 2, 5) + " should be [5].");
        System.out.println(minCost(new int[]{3, 1, 2, 3}, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 4, 3, 3) + " should be [-1].");

        System.out.println("****************************************** Solution 2 *******************************************");
        System.out.println(minCost_rev1(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3) + " should be [9].");
        System.out.println(minCost_rev1(new int[]{0, 0, 0, 0, 0}, new int[][]{{1, 10}, {10, 1}, {1, 10}, {10, 1}, {1, 10}}, 5, 2, 5) + " should be [5].");
        System.out.println(minCost_rev1(new int[]{0, 2, 1, 2, 0}, new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}}, 5, 2, 3) + " should be [11].");
        System.out.println(minCost_rev1(new int[]{3, 1, 2, 3}, new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, 4, 3, 3) + " should be [-1].");
    }

    public static int minCost_rev1(int[] houses, int[][] cost, int m, int n, int target) {
        Integer[][][] dp = new Integer[m][n + 1][target + 1];
        int result = backtracking(houses, cost, 0, n, target, 0, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int backtracking(int[] house, int[][] cost, int idx, int cols, int group, int col, Integer[][][] dp) {
        if (idx == house.length) return group == 0 ? 0 : Integer.MAX_VALUE;
        if (group < 0 || idx > house.length) return Integer.MAX_VALUE;
        if (dp[idx][col][group] != null) return dp[idx][col][group];
        int total = Integer.MAX_VALUE;
        if (house[idx] != 0) {
            total = backtracking(house, cost, idx + 1, cols, house[idx] == col ? group : group - 1, house[idx], dp);
        } else {
            for (int i = 1; i <= cols; i++) {
                int next = backtracking(house, cost, idx + 1, cols, i == col ? group : group - 1, i, dp);
                if (next != Integer.MAX_VALUE) {
                    total = Math.min(total, (house[idx] == 0 ? cost[idx][i - 1] : 0) + next);
                }
            }
        }
        return dp[idx][col][group] = total;
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
