package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class BinomialCoefficients {

    @EpiTest(testDataFile = "binomial_coefficients.tsv")
    public static int computeBinomialCoefficient(int n, int k) {
        Integer[][] dp = new Integer[n + 1][k + 1];
        return helper(n, k, dp);
    }

    private static int helper(int n, int k, Integer[][] dp) {
        if (k == 0 || n == k) return 1;
        if (dp[n][k] == null) {
            dp[n][k] = helper(n - 1, k, dp) + helper(n - 1, k - 1, dp);
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "BinomialCoefficients.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
