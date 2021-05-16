package weekly.weekly204;

/**
 * Created on:  Aug 29, 2020
 * Questions: https://leetcode.com/problems/minimum-number-of-days-to-disconnect-island/
 */
public class MinimumNumberOfDaysToDisconnectIsland {
    public static void main(String[] args) {
        System.out.println(minDays(new int[][]{{1, 1, 1}, {0, 1, 0}, {1, 1, 1}}));
        System.out.println(minDays(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public static int minDays(int[][] grid) {
        int islands = numOfIslands(grid);
        if (islands > 1) return 0;
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    grid[row][col] = 0;
                    islands = numOfIslands(grid);
//                    System.out.println("row = " + row + "\tcol = " + col + "\tislands = " + islands);
                    if (islands != 1) return 1;
                    grid[row][col] = 1;
                }
            }
        }
        return 2;
    }

    private static int numOfIslands(int[][] grid) {
        int islands = 0, rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    islands++;
                    dfs(grid, row, col, rows, cols, visited);
                }
            }
        }
        return islands;
    }

    private static void dfs(int[][] grid, int row, int col, int rows, int cols, boolean[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] == 0) return;
        visited[row][col] = true;
        for (int[] dir : new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
            dfs(grid, row + dir[0], col + dir[1], rows, cols, visited);
        }
    }
}
