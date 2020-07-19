package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Arrays;
import java.util.List;

public class MinimumWeightPathInATriangle {
    @EpiTest(testDataFile = "minimum_weight_path_in_a_triangle.tsv")

    public static int minimumPathTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        Integer[][] dp = new Integer[rows + 1][rows + 1];
        return helper(triangle, 0, 0, rows, dp);
    }

    private static int helper(List<List<Integer>> triangle, int row, int col, int rows, Integer[][] dp) {
//        When you reach to the end then return 0.
        if (row == rows || col > row) return 0;
        if (dp[row][col] != null) return dp[row][col];
        int first = helper(triangle, row + 1, col, rows, dp), second = helper(triangle, row + 1, col + 1, rows, dp);
        return dp[row][col] = triangle.get(row).get(col) + Math.min(first, second);
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "MinimumWeightPathInATriangle.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
