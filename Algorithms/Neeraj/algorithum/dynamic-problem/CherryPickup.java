/**
 * Created on:  Jun 21, 2020
 * Questions: https://leetcode.com/problems/cherry-pickup/
 */
public class CherryPickup {
    static int rows, cols;

    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}) + " should be [5].");
        System.out.println(cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}) + " should be [0].");
        System.out.println(cherryPickup(new int[][]{{1}}) + " should be [1].");
    }

    public static int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = rows > 0 ? grid[0].length : 0;
        Integer[][] dp = new Integer[rows][cols];
        int result = helper(grid, dp, 0, 0);
        if (result != Integer.MIN_VALUE) {
            dp = new Integer[rows][cols];
            int result2 = helper(grid, dp, 0, 0);
            result += result2 == Integer.MIN_VALUE ? 0 : result2;
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }

    private static int helper(int[][] grid, Integer[][] dp, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == -1) return Integer.MIN_VALUE;
        if (row == rows - 1 && col == cols - 1) {
            int cur = grid[row][col];
            if (cur == 1) {
                grid[row][col] = 0;
            }
            return cur;
        }
        if (dp[row][col] != null) return dp[row][col];
        int right = helper(grid, dp, row, col + 1);
        int down = helper(grid, dp, row + 1, col);
        int next = Math.max(right, down);
        int cur = 0;
        if (grid[row][col] == 1) {
            cur = 1;
            grid[row][col] = 0;
        }
        return dp[row][col] = next == Integer.MIN_VALUE ? Integer.MIN_VALUE : cur + next;
    }
}
