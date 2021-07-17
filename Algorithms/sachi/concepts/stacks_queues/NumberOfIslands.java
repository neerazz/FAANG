package concepts.stacks_queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000

Output: 1

Example 2:
Input:
11000
11000
00100
00011
Output: 3

*/
//TODO: Solve this again.

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        List<int[]> dirList = Arrays.asList(new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1},
                new int[]{0, -1});
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            // Iterate and add children to queue
            for (int[] dir : dirList) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || c < 0 || r >= m || c >= n)
                    continue;
                if (!visited[r][c]) {
                    q.add(new int[]{r, c});
                    visited[r][c] = true;
                    if (grid[r][c] != '0') {
                        grid[r][c] = (char) (grid[row][col] + 1);
                    }
                }
            }
        }

        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1')
                    islands++;
            }
        }
        return islands;
    }
}