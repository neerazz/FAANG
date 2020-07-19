package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.List;

public class PickingUpCoins {
    @EpiTest(testDataFile = "picking_up_coins.tsv")

    public static int pickUpCoins(List<Integer> coins) {
        int len = coins.size();
        Integer[][] dp = new Integer[len + 1][len + 1];
        return helper(coins, 0, len - 1, dp);
    }

    private static int helper(List<Integer> coins, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        } else if (dp[start][end] == null) {
            int first = Math.min(helper(coins, start + 1, end - 1, dp), helper(coins, start + 2, end, dp)) + coins.get(start);
            int last = Math.min(helper(coins, start + 1, end - 1, dp), helper(coins, start, end - 2, dp)) + coins.get(end);
            dp[start][end] = Math.max(first, last);
        }
        return dp[start][end];
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "PickingUpCoins.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
