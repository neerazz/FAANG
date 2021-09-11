import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-questions#m
 * You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in.
 * There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
 * Assume the map area is a two dimensional grid, represented by a matrix of characters.
 * You must start from the top-left corner of the map and can move one block up, down, left or right at a time.
 * The treasure island is marked as 'X' in a block of the matrix. 'X' will not be at the top-left corner.
 * Any block with dangerous rocks or reefs will be marked as 'D'. You must not enter dangerous blocks. You cannot leave the map area.
 * Other areas 'O' are safe to sail in. The top-left corner is always safe.
 * Output the minimum number of steps to get to the treasure.
 * e.g.
 * Input
 * [
 * ['O', 'O', 'O', 'O'],
 * ['D', 'O', 'D', 'O'],
 * ['O', 'O', 'O', 'O'],
 * ['X', 'D', 'D', 'O'],
 * ]
 * <p>
 * Output from aonecode.com
 * Route is (0, 0), (0, 1), (1, 1), (2, 1), (2, 0), (3, 0) The minimum route takes 5 steps.
 */

public class TreasureIslandI {

    public static void main(String[] args) {
        System.out.println(findDistance(new char[][]{{'O', 'O', 'O', 'O'}, {'D', 'O', 'D', 'O'}, {'O', 'O', 'O', 'O'}, {'X', 'D', 'D', 'O'},}));
    }

    private static int findDistance(char[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 'D';
        int dist = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] dir : dirs) {
                    int nr = poll[0] + dir[0], nc = poll[1] + dir[1];
                    if (isValid(nr, nc, rows, cols, grid)) {
                        if (grid[nr][nc] == 'X') return dist;
                        grid[nr][nc] = 'D';
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int row, int col, int rows, int cols, char[][] grid) {
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] != 'D';
    }
}
