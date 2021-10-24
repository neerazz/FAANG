import java.util.Arrays;

/**
 * Created on:  Jul 29, 2020
 * Questions: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[] buy = new int[len], sell = new int[len], rest = new int[len];
        buy[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            buy[i] = Math.max(rest[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1]);
            rest[i] = Math.max(rest[i - 1], Math.max(buy[i - 1], sell[i - 1]));
        }
        System.out.println("prices= " + Arrays.toString(prices));
        System.out.println("buy   = " + Arrays.toString(buy));
        System.out.println("sell  = " + Arrays.toString(sell));
        System.out.println("rest  = " + Arrays.toString(rest));
        return Math.max(rest[len - 1], sell[len - 1]);
    }
}
