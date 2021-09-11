import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-oa2-move-obstacle
 */

public class MoveObstacle {

    static int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(getDistance(3, 3, new int[][]{{1, 0, 0}, {1, 0, 0}, {1, 9, 1}}));
    }

    private static int getDistance(int rows, int cols, int[][] grid) {
        if ((rows == 0 && cols == 0) || grid[0][0] == 9) return 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 0;
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int nr = poll[0] + dir[0], nc = poll[1] + dir[1];
                    if (isValid(nr, nc, rows, cols, grid)) {
                        if (grid[nr][nc] == 9) return dist;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int row, int col, int rows, int cols, int[][] grid) {
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] != 0;
    }
}
