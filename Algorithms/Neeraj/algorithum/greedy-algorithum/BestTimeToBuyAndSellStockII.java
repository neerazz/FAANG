public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}) + " should be [7]");
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}) + " should be [4]");
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}) + " should be [0]");
    }

    public static int maxProfit(int[] prices) {
        int maxValue = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                maxValue += prices[i + 1] - prices[i];
            }
        }
        return maxValue;
    }
}
