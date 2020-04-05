public class UniquePathsII {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = rows > 0 ? obstacleGrid[0].length : 0;
        if (cols == 0) return 0;
        int[][] dp = new int[rows][cols];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 0) {
                    int cur = dp[row][col];
                    boolean canGoRight = col + 1 < cols && obstacleGrid[row][col + 1] == 0;
                    boolean canGoDown = row + 1 < rows && obstacleGrid[row + 1][col] == 0;
                    if (canGoRight) {
                        dp[row][col + 1] = dp[row][col + 1] + cur;
                    }
                    if (canGoDown) {
                        dp[row + 1][col] = dp[row + 1][col] + cur;
                    }
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
