/**
 * Created on:  Jun 01, 2020
 * Questions: https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {

    }
}

class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        dp = new int[rows + 1][cols + 1];
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                dp[row][col] = matrix[row - 1][col - 1] + dp[row - 1][col] + dp[row][col - 1] - dp[row - 1][col - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        row2++;
        col1++;
        col2++;
        return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
    }
}