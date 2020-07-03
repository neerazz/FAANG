import java.util.Arrays;

/**
 * Created on:  Jun 21, 2020
 * Questions: https://leetcode.com/problems/cherry-pickup/
 */
public class CherryPickup {

    static int rows, cols;
    static int[][] dirs = {{1, 0}, {0, 1}};

    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}) + " should be [5].");
        System.out.println(cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}) + " should be [0].");
        System.out.println(cherryPickup(new int[][]{{1}}) + " should be [1].");
        System.out.println(cherryPickup(new int[][]{{1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}}) +
                " should be [15].");
    }

    public static int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = rows > 0 ? grid[0].length : 0;
        Integer[][][] dp = new Integer[rows][cols][cols];
        helper(grid, dp, 0, 0, 0, 0);
//        System.out.println(Arrays.deepToString(dp));
        return Math.max(0, dp[0][0][0] == null ? 0 : dp[0][0][0]);
    }

    private static int helper(int[][] grid, Integer[][][] dp, int r1r, int r1c, int r2r, int r2c) {
        if (r1r >= rows || r1c >= cols || grid[r1r][r1c] == -1) return Integer.MIN_VALUE;
        if (r2r >= rows || r2c >= cols || grid[r2r][r2c] == -1) return Integer.MIN_VALUE;
        if (r1r == rows - 1 && r1c == cols - 1) return dp[r1r][r1c][r2c] = grid[r1r][r1c];
        if (dp[r1r][r1c][r2c] != null) return dp[r1r][r1c][r2c];
        int next = Integer.MIN_VALUE, cur = (r1r == r2r && r1c == r2c) ? grid[r1r][r1c] : grid[r1r][r1c] + grid[r2r][r2c];
        for (int[] dir1 : dirs) {
            int nr1r = r1r + dir1[0], nr1c = r1c + dir1[1];
            for (int[] dir2 : dirs) {
                int nr2r = r2r + dir2[0], nr2c = r2c + dir2[1];
                next = Math.max(next, helper(grid, dp, nr1r, nr1c, nr2r, nr2c));
            }
        }
        return dp[r1r][r1c][r2c] = next == Integer.MIN_VALUE ? Integer.MIN_VALUE : cur + next;
    }
}
