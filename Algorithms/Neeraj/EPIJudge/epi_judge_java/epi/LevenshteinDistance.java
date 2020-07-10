package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

public class LevenshteinDistance {
    @EpiTest(testDataFile = "levenshtein_distance.tsv")

    public static int levenshteinDistance(String A, String B) {
        int rows = B.length(), cols = A.length();
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= cols; i++) {
            dp[0][i] = i;
        }
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                if (A.charAt(col - 1) == B.charAt(row - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;
                }
            }
        }
        return dp[rows][cols];
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "LevenshteinDistance.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
