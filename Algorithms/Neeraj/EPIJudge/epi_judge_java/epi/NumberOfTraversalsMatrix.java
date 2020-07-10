package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class NumberOfTraversalsMatrix {

    @EpiTest(testDataFile = "number_of_traversals_matrix.tsv")
    public static int numberOfWays(int n, int m) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (col + 1 < m) dp[row][col + 1] += dp[row][col];
                if (row + 1 < n) dp[row + 1][col] += dp[row][col];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "NumberOfTraversalsMatrix.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
