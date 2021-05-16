package weekly.weekly207;

/**
 * Created on:  Sep 19, 2020
 * Questions: https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix
 */
public class MaximumNonNegativeProductInAMatrix {
    static int mod = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(maxProductPath(new int[][]{{-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}}) + " = -1");
        System.out.println(maxProductPath(new int[][]{{1, -2, 1}, {1, -2, 1}, {3, -4, 1}}) + " = 8");
        System.out.println(maxProductPath(new int[][]{{1, 3}, {0, -4}}) + " = 0");
        System.out.println(maxProductPath(new int[][]{{1, 4, 4, 0}, {-2, 0, 0, 1}, {1, -1, 1, 1}}) + " = 2");
        System.out.println(maxProductPath(new int[][]{{2, 1, 3, 0, -3, 3, -4, 4, 0, -4}, {-4, -3, 2, 2, 3, -3, 1, -1, 1, -2}, {-2, 0, -4, 2, 4, -3, -4, -1, 3, 4}, {-1, 0, 1, 0, -3, 3, -2, -3, 1, 0}, {0, -1, -2, 0, -3, -4, 0, 3, -2, -2}, {-4, -2, 0, -1, 0, -3, 0, 4, 0, -3}, {-3, -4, 2, 1, 0, -4, 2, -4, -1, -3}, {3, -2, 0, -4, 1, 0, 1, -3, -1, -1}, {3, -4, 0, 2, 0, -2, 2, -4, -2, 4}, {0, 4, 0, -3, -4, 3, 3, -1, -2, -2}}) +
                " = 19215865");
    }

    public static int maxProductPath(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        Long[][][] dp = new Long[rows + 1][cols + 1][2];
        Long[] result = helper(0, 0, rows, cols, grid, dp);
        return result[1] >= 0 ? (int) (result[1] % mod) : -1;
    }

    private static Long[] helper(int row, int col, int rows, int cols, int[][] grid, Long[][][] dp) {
        if (row >= rows || col >= cols) return new Long[0];
        if (row == rows - 1 && col == cols - 1) return new Long[]{(long) grid[row][col], (long) grid[row][col]};
        else if (dp[row][col][0] != null) return dp[row][col];
        else {
            Long[] cur = new Long[]{Long.MAX_VALUE, Long.MIN_VALUE};
            int val = grid[row][col];
            Long[] right = helper(row, col + 1, rows, cols, grid, dp);
            Long[] down = helper(row + 1, col, rows, cols, grid, dp);
            if (right.length == 2) {
                cur[0] = Math.min((right[0] * val), (right[1] * val));
                cur[1] = Math.max((right[0] * val), (right[1] * val));
            }
            if (down.length == 2) {
                cur[0] = Math.min(Math.min(down[0] * val, down[1] * val), cur[0]);
                cur[1] = Math.max(Math.max((down[0] * val), (down[1] * val)), cur[1]);
            }
            return dp[row][col] = cur;
        }
    }
}
