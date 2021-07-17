package leetcode.v2.easy;

/**
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy
 * before you sell.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfitBrute(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //Elegant Solution
    public static int maxProfit(int[] prices) {
        //You need to find peaks and valleys
        int minVal = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minVal) {
                minVal = price;
            } else if (price - minVal > maxProfit) {
                maxProfit = price - minVal;
            }
        }
        return maxProfit;
    }

    //Brute Force
    public static int maxProfitBrute(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int curProfit = prices[j] - prices[i];
                if (curProfit > maxProfit) maxProfit = curProfit;
            }
        }
        return maxProfit;
    }

}
