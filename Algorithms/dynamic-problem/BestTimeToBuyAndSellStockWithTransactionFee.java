/**
 * Created on:  Mar 16, 2021
 * Questions: https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3674/
 */

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {

    }

    /**
     * 1 ,3 ,2 ,8 ,4 ,9  fee = 2
     * cash 0  0  0  5
     * hold -1-1 -1
     */
    public static int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int price : prices) {
//            Check if you can cash out, by selling the current transactions.
            cash = Math.max(cash, hold + price - fee);
//            Check if you can you can hold the current stock
            hold = Math.max(hold, cash - price);
        }
        return cash;
    }

    //    Time: O(n^2), space : O(n)
    public static int maxProfit_naive(int[] prices, int fee) {
        int len = prices.length, max = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[j] + fee < prices[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + prices[i] - prices[j] - fee);
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
