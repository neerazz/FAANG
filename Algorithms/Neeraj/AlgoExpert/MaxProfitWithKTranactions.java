import java.util.Arrays;

/**
 * Created on:  Aug 29, 2020
 * Questions:
 */
public class MaxProfitWithKTranactions {
    public static void main(String[] args) {
        System.out.println(maxProfitWithKTransactions(new int[]{5, 11, 3, 50, 60, 90}, 2));
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        int max = 0, rows = k, cols = prices.length;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col < cols; col++) {
// 				Picking the best of previous days.
                dp[row][col] = Math.max(dp[row][col], dp[row - 1][col]);
// 				Loop through all the days before cur to get the best.
                for (int i = 0; i < col; i++) {
                    if (prices[i] < prices[col]) {
                        int profit = prices[col] - prices[i] + dp[row - 1][i];
                        dp[row][col] = Math.max(dp[row][col], profit);
                    }
                }
// 				Without selling any stock today
                dp[row][col] = Math.max(dp[row][col], dp[row][col - 1]);
                max = Math.max(max, dp[row][col]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return max;
    }
}
