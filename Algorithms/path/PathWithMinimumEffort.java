import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created on:  Jan 26, 2021
 * Questions: https://leetcode.com/problems/path-with-minimum-effort/
 */

public class PathWithMinimumEffort {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println("************************************ Solution 1 **************************************");
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}) + " = 2");
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}) + " = 0");

        System.out.println("************************************ Solution 2 **************************************");
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}) + " = 2");
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}) + " = 0");
    }

    //    TC: O(n*m*log(n*m))
    public static int minimumEffortPath_sorted(int[][] heights) {
        int rows = heights.length, cols = rows > 0 ? heights[0].length : 0;
        Integer[][] dp = new Integer[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v1[0], v2[0]));
//        0: effort, 1:row, 2: col
        pq.add(new int[]{0, 0, 0});
        dp[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int effort = poll[0], row = poll[1], col = poll[2];
//            If you already have visited current position with lower effort then skip.
            if (dp[row][col] != null && dp[row][col] < effort) continue;
            if (row == rows - 1 && col == cols - 1) return effort;
            for (int[] dir : dirs) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[nr][nc]));
                if (dp[nr][nc] == null || dp[nr][nc] > newEffort) {
                    dp[nr][nc] = newEffort;
                    pq.add(new int[]{newEffort, nr, nc});
                }
            }
        }
        return 0;
    }

    public static int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = rows > 0 ? heights[0].length : 0;
        Integer[][] dp = new Integer[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        dp[0][0] = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int nr = poll[0] + dir[0], nc = poll[1] + dir[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                int cur = Math.max(dp[poll[0]][poll[1]], Math.abs(heights[poll[0]][poll[1]] - heights[nr][nc]));
                if (dp[nr][nc] == null || dp[nr][nc] > cur) {
                    dp[nr][nc] = cur;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return dp[rows - 1][cols - 1] == Integer.MAX_VALUE ? 0 : dp[rows - 1][cols - 1];
    }
}
