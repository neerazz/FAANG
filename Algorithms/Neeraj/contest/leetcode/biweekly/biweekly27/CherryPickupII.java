package biweekly.biweekly27;

import java.util.*;

/**
 * Created on:  May 30, 2020
 * Questions: https://leetcode.com/problems/cherry-pickup-ii/
 */
public class CherryPickupII {
    static int rows = 0, cols = 0;
    static int[] dirs = {-1, 0, 1};

    public static void main(String[] args) {
        System.out.println("*************************** Method 1 ********************************");
        System.out.println(cherryPickup(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}) + "\t should be [24]");
        System.out.println(cherryPickup(new int[][]{{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}) + "\t should be [28]");
        System.out.println(cherryPickup(new int[][]{{1, 0, 0, 3}, {0, 0, 0, 3}, {0, 0, 3, 3}, {9, 0, 3, 3}}) + "\t should be [22]");
        System.out.println(cherryPickup(new int[][]{{1, 1}, {1, 1}}) + "\t should be [4]");

        System.out.println("*************************** Method 2 ********************************");
        System.out.println(cherryPickup_rev1(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}) + "\t should be [24]");
        System.out.println(cherryPickup_rev1(new int[][]{{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}}) + "\t should be [28]");
        System.out.println(cherryPickup_rev1(new int[][]{{1, 0, 0, 3}, {0, 0, 0, 3}, {0, 0, 3, 3}, {9, 0, 3, 3}}) + "\t should be [22]");
        System.out.println(cherryPickup_rev1(new int[][]{{1, 1}, {1, 1}}) + "\t should be [4]");
    }

    public static int cherryPickup_rev1(int[][] grid) {
        rows = grid.length;
        cols = rows > 0 ? grid[0].length : 0;
        if (cols == 0) return 0;
        Integer[][][] dp = new Integer[rows][cols][cols];
        return dfs_rev1(0, 0, cols - 1, grid, dp);
    }

    private static int dfs_rev1(int row, int r1c, int r2c, int[][] grid, Integer[][][] dp) {
        if (!inRange(row, r1c) || !inRange(row, r2c)) return 0;
        if (dp[row][r1c][r2c] != null) return dp[row][r1c][r2c];
        int cur = r1c == r2c ? grid[row][r1c] : grid[row][r1c] + grid[row][r2c], max = 0;
        for (int dir : dirs) {
            for (int dir2 : dirs) {
                max = Math.max(max, dfs_rev1(row + 1, r1c + dir, r2c + dir2, grid, dp));
            }
        }
        return dp[row][r1c][r2c] = cur + max;
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    private static int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int op = 0;
        if (cols == 0) return op;
        Map<String, Integer> map = new HashMap<>();
        return dfs(map, 0, 0, 0, cols - 1, rows, cols, grid);
    }


    private static int dfs(Map<String, Integer> map, int r1r, int r1c, int r2r, int r2c, int rows, int cols, int[][] grid) {
//        When out of boundary then return 0;
        if (!inRange(r1r, r1c, rows, cols) || !inRange(r2r, r2c, rows, cols)) return 0;
        String val1 = r1r + "-" + r1c + "-" + r2r + "-" + r2c;
        String val2 = r2r + "-" + r2c + "-" + r1r + "-" + r1c;

        if (map.containsKey(val1)) return map.get(val1);
        if (map.containsKey(val2)) return map.get(val2);

        int sum = grid[r1r][r1c] + grid[r2r][r2c];
        if (r1r == r2r && r1c == r2c) sum -= grid[r2r][r2c];
        int max = 0;
        for (int dir1 : dirs) {
            for (int dir2 : dirs) {
                int next = dfs(map, r1r + 1, r1c + dir1, r2r + 1, r2c + dir2, rows, cols, grid);
                max = Math.max(max, next);
            }
        }

//        Add both the strings into map
        map.put(val1, sum + max);
        map.put(val2, sum + max);
        return sum + max;
    }

    private static boolean inRange(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
