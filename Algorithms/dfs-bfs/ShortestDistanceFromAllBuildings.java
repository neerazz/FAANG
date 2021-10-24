import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on:  Sep 22, 2021
 * Ref: https://leetcode.com/explore/featured/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3983/
 */
public class ShortestDistanceFromAllBuildings {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(shortestDistance(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}) + " = 7");
    }

    public static int shortestDistance(int[][] grid) {
        int buildings = 0;
        List<int[]> empty = new ArrayList<>();
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) buildings++;
                if (grid[r][c] == 0) empty.add(new int[]{r, c});
            }
        }
        int min = Integer.MAX_VALUE;
        for (int[] idx : empty) {
            int dist = getDist(idx[0], rows, idx[1], cols, grid, buildings);
            min = Math.min(min, dist);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    static int getDist(int row, int rows, int col, int cols, int[][] grid, int buildings) {
        int count = 0, level = 0, dist = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        boolean[][] visited = new boolean[rows][cols];
        visited[row][col] = true;
        while (!queue.isEmpty() && count != buildings) {
            int size = queue.size();
            while (size-- > 0) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int nr = poll[0] + dir[0], nc = poll[1] + dir[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (grid[nr][nc] == 2 || visited[nr][nc]) continue;
                    visited[nr][nc] = true;
                    if (grid[nr][nc] == 1) {
                        count++;
                        dist += level;
                    } else queue.add(new int[]{nr, nc});
                }
            }
            level++;
        }
        return count == buildings ? dist : Integer.MAX_VALUE;
    }
}
