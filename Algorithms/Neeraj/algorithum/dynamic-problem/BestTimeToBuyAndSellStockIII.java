/**
 * Crated on:  Apr 05, 2020
 */
public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 5, 7, 1, 4, 3, 1, 3}) + " should be [8].");
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}) + " should be [6].");
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}) + " should be [4].");
    }

    public static int maxProfit(int[] prices) {
        return maxProfitWithNSells_2(prices, 2);
    }

    //    Time: O(M*N), Space: O(M*N), Explanation: https://www.youtube.com/watch?v=oDhu5uGq_ic&t=803s
    public static int maxProfitWithNSells_2(int[] prices, int n) {
        int len = prices.length;
        if (len == 0) return 0;
        int[][] dp = new int[n + 1][len + 1];
        for (int row = 1; row <= n; row++) {
//            Calculate the max difference, so that we can avoid the internal column loop. Initialize it to 0-first col value.
            int maxDiff = -prices[0];
            for (int col = 1; col <= len; col++) {
                dp[row][col] = Math.max(dp[row][col - 1], prices[col - 1] + maxDiff);
//                Instead of looping through 0 to i-1 column and getting the maximum value (like: price[i] - price[j] + dp[row][j]).
//                At each level assign the difference of profit made with one less transactions with the price value. (dp[row-1][col-1])
                maxDiff = Math.max(maxDiff, dp[row - 1][col] - prices[col - 1]);
            }
        }
        return dp[n][len];
    }

    //    Time: O(M*N*N), Space: O(M*N)
    public static int maxProfitWithNSells_1(int[] prices, int n) {
        int len = prices.length;
        int[][] dp = new int[n + 1][len + 1];
        for (int row = 1; row <= n; row++) {
            for (int i = 1; i <= len; i++) {
//                Initialize the profit considering that there would not be any transactions at current index.
                int maxProfit = dp[row][i - 1];
//                Loop though all the prices till now to find the maximum profit that can be made.
                for (int j = 1; j < i; j++) {
                    int profit = prices[i - 1] - prices[j - 1];
//                    The profit at j, would be the difference between prices at i & j + profit at j
                    maxProfit = Math.max(maxProfit, profit + dp[row - 1][j]);
                }
                dp[row][i] = maxProfit;
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[n][len];
    }
}
