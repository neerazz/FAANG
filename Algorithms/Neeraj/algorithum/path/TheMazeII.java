import java.util.Arrays;

/**
 * Created on:  Oct 04, 2020
 * Questions:
 */

public class TheMazeII {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {

    }

    public static int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        helper(start, maze, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[0]];
    }

    private static void helper(int[] cur, int[][] maze, int[][] dists) {
        for (int[] dir : dirs) {
            int curStep = 0;
            int newr = cur[0] + dir[0], newc = cur[1] + dir[1];
            while (isValid(newr, newc, maze)) {
                curStep++;
                newr += dir[0];
                newc += dir[1];
            }
            if (curStep == 0) continue;
            newr -= dir[0];
            newc -= dir[1];
            if (dists[cur[0]][cur[1]] + curStep < dists[newr][newc]) {
                dists[newr][newc] = dists[cur[0]][cur[1]] + curStep;
                helper(new int[]{newr, newc}, maze, dists);
            }
        }
    }

    private static boolean isValid(int row, int col, int[][] maze) {
        if (row < 0 || col < 0 || row >= maze.length || col >= maze[0].length) return false;
        return maze[row][col] == 0;
    }
}
