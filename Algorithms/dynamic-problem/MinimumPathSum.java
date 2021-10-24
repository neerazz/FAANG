public class MinimumPathSum {
    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        if (cols == 0) return 0;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                int curgrid = grid[row - 1][col - 1];
                int dpmin = 0;
                if (row == 1) dpmin = dp[row][col - 1];
                else if (col == 1) dpmin = dp[row - 1][col];
                else dpmin = Math.min(dp[row - 1][col], dp[row][col - 1]);
                dp[row][col] = curgrid + dpmin;
            }
        }
        return dp[rows][cols];
    }
}
