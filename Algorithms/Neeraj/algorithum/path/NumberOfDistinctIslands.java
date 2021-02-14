import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 08, 2021
 * Questions: https://leetcode.com/problems/number-of-distinct-islands/
 */

public class NumberOfDistinctIslands {

    public static void main(String[] args) {

    }

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static char[] chars = {'D', 'U', 'R', 'L'};

    public static int numDistinctIslands(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        Set<String> isLands = new HashSet<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
//                    StringBuilder path = new StringBuilder();
//                    path.append("S");
//                     dfs(r,c,rows,cols,grid,path, 'S');
//                    isLands.add(path.toString());
                    isLands.add(bfs(r, c, rows, cols, grid));
                }
            }
        }
        return isLands.size();
    }

    private static void dfs(int row, int col, int rows, int cols, int[][] grid, StringBuilder path, char dir) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0) return;
        path.append(dir);
        grid[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int nr = row + dirs[i][0], nc = col + dirs[i][1];
            dfs(nr, nc, rows, cols, grid, path, chars[i]);
        }
        path.append("0");
    }

    private static String bfs(int row, int col, int rows, int cols, int[][] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append("S");
        int level = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nRow = poll[0] + dirs[j][0], nCol = poll[1] + dirs[j][1];
                    if (nRow < 0 || nRow >= rows || nCol < 0 || nCol >= cols || grid[nRow][nCol] == 0) continue;
                    sb.append(i).append(chars[j]);
                    queue.add(new int[]{nRow, nCol});
                    grid[nRow][nCol] = 0;
                }
            }
            sb.append(level++);
        }
        return sb.toString();
    }
}
