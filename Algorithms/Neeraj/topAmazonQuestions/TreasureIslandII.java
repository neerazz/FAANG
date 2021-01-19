import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-questions#tt
 */

public class TreasureIslandII {

    public static void main(String[] args) {
        System.out.println(findDistance(new char[][]{
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}}));
    }

    private static int findDistance(char[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        Queue<int[]> queue = new LinkedList<>();
        addAllStarting(grid, rows, cols, queue);
        int dist = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int nr = poll[0] + dir[0], nc = poll[1] + dir[1];
                    if (isValid(nr, nc, rows, cols, grid)) {
                        if (grid[nr][nc] == 'X') return dist;
                        queue.add(new int[]{nr, nc});
                        grid[nr][nc] = 'D';
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int row, int col, int rows, int cols, char[][] grid) {
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] != 'D';
    }

    private static void addAllStarting(char[][] grid, int rows, int cols, Queue<int[]> queue) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 'S') {
                    queue.add(new int[]{row, col});
                    grid[row][col] = 'D';
                }
            }
        }
    }
}
