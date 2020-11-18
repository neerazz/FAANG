import java.util.*;

/**
 * Created on:  Nov 16, 2020
 * Questions: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 */

public class MinimumCostToMakeAtLeastOneValidPathInAGrid {

    static int rows, cols, min;
    static int[][] dirs = {{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        System.out.println("******************************** Solution 1 ***************************");
        System.out.println(minCost(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}}));
        System.out.println(minCost(new int[][]{{1, 1, 3}, {3, 2, 2}, {1, 1, 4}}));
        System.out.println(minCost(new int[][]{{1, 2}, {4, 3}}));
        System.out.println(minCost(new int[][]{{2, 2, 2}, {2, 2, 2}}));
        System.out.println(minCost(new int[][]{{4}}));
        System.out.println(minCost(new int[][]{{3, 4, 3}, {2, 2, 2}, {2, 1, 1}, {4, 3, 2}, {2, 1, 4}, {2, 4, 1}, {3, 3, 3}, {1, 4, 2}, {2, 2, 1}, {2, 1, 1}, {3, 3, 1}, {4, 1, 4}, {2, 1, 4}, {3, 2, 2}, {3, 3, 1}, {4, 4, 1}, {1, 2, 2}, {1, 1, 1}, {1, 3, 4}, {1, 2, 1}, {2, 2, 4}, {2, 1, 3}, {1, 2, 1}, {4, 3, 2}, {3, 3, 4}, {2, 2, 1}, {3, 4, 3}, {4, 2, 3}, {4, 4, 4}}));

        System.out.println("******************************** Solution 2 ***************************");
        System.out.println(minCost_naive(new int[][]{{1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {2, 2, 2, 2}}));
        System.out.println(minCost_naive(new int[][]{{1, 1, 3}, {3, 2, 2}, {1, 1, 4}}));
        System.out.println(minCost_naive(new int[][]{{1, 2}, {4, 3}}));
        System.out.println(minCost_naive(new int[][]{{2, 2, 2}, {2, 2, 2}}));
        System.out.println(minCost_naive(new int[][]{{4}}));
        System.out.println(minCost_naive(new int[][]{{3, 4, 3}, {2, 2, 2}, {2, 1, 1}, {4, 3, 2}, {2, 1, 4}, {2, 4, 1}, {3, 3, 3}, {1, 4, 2}, {2, 2, 1}, {2, 1, 1}, {3, 3, 1}, {4, 1, 4}, {2, 1, 4}, {3, 2, 2}, {3, 3, 1}, {4, 4, 1}, {1, 2, 2}, {1, 1, 1}, {1, 3, 4}, {1, 2, 1}, {2, 2, 4}, {2, 1, 3}, {1, 2, 1}, {4, 3, 2}, {3, 3, 4}, {2, 2, 1}, {3, 4, 3}, {4, 2, 3}, {4, 4, 4}}));
    }

    public static int minCost(int[][] grid) {
        rows = grid.length;
        cols = rows > 0 ? grid[0].length : 0;
        int[][] dp = new int[rows][cols];
        int cost = 0;
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        Queue<int[]> queue = new LinkedList<>();
//        Add all the points in matrix that can be reached with zero cost.
        dfs(grid, dp, cost, 0, 0, queue);
        while (!queue.isEmpty()) {
            cost++;
//            Change of all the points.
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 1; j <= 4; j++) {
//                    Explore the neighbours by changing one.
                    dfs(grid, dp, cost, poll[0] + dirs[j][0], poll[1] + dirs[j][1], queue);
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

    private static void dfs(int[][] grid, int[][] dp, int cost, int row, int col, Queue<int[]> queue) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || dp[row][col] != Integer.MAX_VALUE) return;
        queue.add(new int[]{row, col});
        int cur = grid[row][col];
        dp[row][col] = cost;
        dfs(grid, dp, cost, row + dirs[cur][0], col + dirs[cur][1], queue);
    }

    public static int minCost_naive(int[][] grid) {
        rows = grid.length;
        cols = rows > 0 ? grid[0].length : 0;
        min = Integer.MAX_VALUE;
        helper(grid, 0, 0, 0);
        return min;
    }


    private static void helper(int[][] grid, int row, int col, int cost) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) return;
        if (row == rows - 1 && col == cols - 1) {
            min = Math.min(min, cost);
            return;
        }
        if (cost > min) return;
        int cur = grid[row][col];
        grid[row][col] = 0;
        helper(grid, row + dirs[cur][0], col + dirs[cur][1], cost);
        for (int i = 1; i <= 4; i++) {
            if (i == cur) continue;
            helper(grid, row + dirs[i][0], col + dirs[i][1], cost + 1);
        }
        grid[row][col] = cur;
    }
}
