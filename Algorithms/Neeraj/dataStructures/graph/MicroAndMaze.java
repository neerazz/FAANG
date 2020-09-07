/**
 * Created on:  Sep 06, 2020
 * Questions: https://www.hackerearth.com/practice/algorithms/graphs/flood-fill-algorithm/tutorial/
 */
public class MicroAndMaze {
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int rows = fr.nextInt(), cols = fr.nextInt();
        int[][] grid = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = fr.nextInt();
            }
        }
        System.out.println(canReachToEnd(0, 0, rows, cols, grid) ? "Yes" : "No");
    }

    private static boolean canReachToEnd(int row, int col, int rows, int cols, int[][] grid) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1) return false;
        if (row == rows - 1 && col == cols - 1) return true;
        grid[row][col] = 0;
        for (int[] dir : dirs) {
            if (canReachToEnd(row + dir[0], col + dir[1], rows, cols, grid)) {
                return true;
            }
        }
        grid[row][col] = 1;
        return false;
    }
}
