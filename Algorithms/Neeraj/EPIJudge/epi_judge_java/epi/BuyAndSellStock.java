package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class BuyAndSellStock {
    @EpiTest(testDataFile = "buy_and_sell_stock.tsv")
    public static double computeMaxProfit(List<Double> prices) {
        if (prices.size() == 0) return 0.0;
        double[] left = new double[prices.size()];
        left[0] = prices.get(0);
        for (int i = 1; i < prices.size(); i++) {
            left[i] = Math.min(left[i - 1], prices.get(i));
        }
        double max = 0.0;
        for (int i = 1; i < prices.size(); i++) {
            max = Math.max(max, prices.get(i) - left[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "BuyAndSellStock.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
