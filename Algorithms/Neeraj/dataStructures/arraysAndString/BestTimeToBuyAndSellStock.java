/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxProfit_1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit_1(new int[]{7, 6, 4, 3, 1}));
    }

    //    Time: O(N), Space: O(1)
    public static int maxProfit_2(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(prices[i] - min, max);
            }
        }
        return max;
    }

    //    Time: O(N), Space: O(N)
    public static int maxProfit_1(int[] prices) {
        int len = prices.length;
        int[] right = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(prices[i + 1], right[i + 1]);
        }
        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, right[i] - prices[i]);
        }
        return max;
    }
}
