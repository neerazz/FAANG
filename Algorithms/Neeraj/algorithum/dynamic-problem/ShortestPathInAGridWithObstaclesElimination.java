import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Jul 31, 2021
 * Ref : https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
 */
public class ShortestPathInAGridWithObstaclesElimination {
    public static void main(String[] args) {
        System.out.println(shortestPath(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1));
        System.out.println(shortestPath(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}},
                1));
    }

    public static int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int[][] obs = new int[rows][cols];
        for (int[] row : obs) Arrays.fill(row, -1);
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        //0 - x, 1- y, 2- total steps so far taken, 3- Remaining obs power.
        queue.offer(new int[]{0, 0, 0, k});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0], col = poll[1];
            if (row == rows - 1 && col == cols - 1) return poll[2];
            if (grid[row][col] == 1) {
                poll[3]--;
                if (poll[3] < 0) continue;
            }
            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
//                If this element (row, col) was discovered earlier and, the elimination capacity is greater now compared to previous, then consider this path.
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && obs[nr][nc] < poll[3]) {
                    queue.offer(new int[]{nr, nc, poll[2] + 1, poll[3]});
                    //If I dared to cross via this node, I would make sure to leave my footprint by writing how much capacity I had while passing this through
                    obs[nr][nc] = poll[3];
                }
            }
        }
        return -1;
    }
}
