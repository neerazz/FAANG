import java.util.*;

class UniquePaths {
    public static void main(String[] args) {

    }

    public static int uniquePaths_rev1(int m, int n) {
//        At each level go to next possible level and add the possibilities through with you can reach current level.
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row + 1 < m) {
                    dp[row + 1][col] += dp[row][col];
                }
                if (col + 1 < n) {
                    dp[row][col + 1] += dp[row][col];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // Solution: https://www.youtube.com/watch?v=GO5QHC_BmvM
    public static int uniquePaths(int cols, int rows) {
        int[][] dp = new int[rows][cols];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < rows; i++) {
            dp[i][0] = 1;
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[rows - 1][cols - 1];
    }
}
