package concepts.stacks_queues;

import util.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:
Given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
  
 */

//TODO: Go through this sol again
public class WallsAndGates {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };
        Util.print(matrix);
        wallsAndGates(matrix);
        Util.print(matrix);
    }

    private static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0)
            return;
        int EMPTY = Integer.MAX_VALUE;
        int m = rooms.length;
        int n = rooms[0].length;
        List<int[]> dirList = Arrays.asList(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1},
                new int[]{0, -1});
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            for (int[] dir : dirList) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] != EMPTY)
                    continue;
                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[]{r, c});
            }
        }

    }
}
