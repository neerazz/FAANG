package weekly.weekly212;

import java.util.*;

/**
 * Created on:  Oct 24, 2020
 * Questions:
 */

public class PathWithMinimumEffort {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}));
        System.out.println(minimumEffortPath(new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}}));
    }

    public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        Integer[][] dp = new Integer[rows][cols];
        dp[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
//        0: row, 1 : col
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0], col = poll[1];
            for (int[] dir : dirs) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || heights[nr][nc] < 0) continue;
                int cur = Math.max(dp[row][col], Math.abs(heights[row][col] - heights[nr][nc]));
                if (dp[nr][nc] == null || dp[nr][nc] > cur) {
                    dp[nr][nc] = cur;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
//        System.out.println("dp = " + Arrays.deepToString(dp));
        return dp[rows - 1][cols - 1] == Integer.MAX_VALUE ? 0 : dp[rows - 1][cols - 1];
    }
}
