import java.util.*;

/**
 * Created on:  Sep 09, 2021
 * Ref: https://leetcode.com/problems/largest-plus-sign/
 */
public class LargestPlusSign {
    public static void main(String[] args) {

    }

    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], 1);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                int cur = dfs(grid, r, c, n);
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int dfs(int[][] grid, int row, int col, int n) {
        if (grid[row][col] == 0) return 0;
        int[][] idx = new int[4][2];
        fill(idx, row, col);
        int len = 1;
        while (isValid(idx[0], dirs[0], grid) && isValid(idx[1], dirs[1], grid) &&
                isValid(idx[2], dirs[2], grid) && isValid(idx[3], dirs[3], grid)) {
            len++;
            for (int i = 0; i < 4; i++) {
                idx[i][0] += dirs[i][0];
                idx[i][1] += dirs[i][1];
            }
        }
        return len;
    }

    static boolean isValid(int[] idx, int[] dir, int[][] grid) {
        int nr = idx[0] + dir[0], nc = idx[1] + dir[1];
        return nr >= 0 && nr < grid.length && nc >= 0 && nc < grid.length && grid[nr][nc] == 1;
    }

    static void fill(int[][] idx, int row, int col) {
        for (int i = 0; i < 4; i++) {
            idx[i][0] = row;
            idx[i][1] = col;
        }
    }
}
