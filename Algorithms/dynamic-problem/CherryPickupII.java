/**
 * Created on: Jun 21, 2020
 * Questions: https://leetcode.com/problems/cherry-pickup/
 */
public class CherryPickupII {

    public static void main(String[] args) {
        System.out.println(cherryPickup(new int[][]{{3,1,1}, {2,5,1}, {1,5,5},{2,1,1}}) + "= 24");

        System.out.println(cherryPickup(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}) + "= 4");
        System.out.println(cherryPickup(new int[][]{{1}}) + "= 1");
        System.out.println(cherryPickup(new int[][]{{1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}}) +
                "= 7");
    }

    public static int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = rows > 0 ? grid[0].length : 0;
        Integer[][][] dp = new Integer[rows][cols][cols];
        return helper(grid, 0, 0, cols - 1, dp, rows, cols);
    }

    private static int helper(int[][] grid, int row, int c1, int c2, Integer[][][] dp, int rows, int cols) {
        if (row == rows) return 0;
        if (c1 < 0 || c1 >= cols || c2 < 0 || c2 >= cols) return Integer.MIN_VALUE;
        if (dp[row][c1][c2] != null) {
            return dp[row][c1][c2];
        }
        int[] dirs = {-1, 0, 1};
        int max = 0;
        for (int d1 : dirs) {
            for (int d2 : dirs) {
                int next = helper(grid, row + 1, c1 + d1, c2 + d2, dp, rows, cols);
                max = Math.max(max, next);
            }
        }
        max += c1 == c2 ? grid[row][c1] : grid[row][c1] + grid[row][c2];
        dp[row][c1][c2] = max;
        return max;
    }
}
