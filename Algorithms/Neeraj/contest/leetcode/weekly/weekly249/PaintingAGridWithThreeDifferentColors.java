package weekly.weekly249;

/**
 * Created on:  Jul 17, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-249/problems/painting-a-grid-with-three-different-colors/
 */
public class PaintingAGridWithThreeDifferentColors {

    static long count;
    static int mod = 1_000_000_007;
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        System.out.println(colorTheGrid(1, 2) + " = 6");
        System.out.println(colorTheGrid(1, 1) + " = 3");
        System.out.println(colorTheGrid(5, 2) + " = 486");
        System.out.println(colorTheGrid(5, 5) + " = 580986");
        System.out.println(colorTheGrid(2, 37) + " = 580986");
    }

    public static int colorTheGrid(int m, int n) {
        count = 0;
        Integer[][] grid = new Integer[m][n];
        dfs(grid, 0, 0, m, n);
        return (int) (count % mod);
    }

    static void dfs(Integer[][] grid, int row, int col, int rows, int cols) {
        if (col == cols) {
            col = 0;
            row++;
        }
        if (row == rows) {
            count++;
            count %= mod;
//            System.out.println(Arrays.deepToString(grid));
        } else {
            for (int i = 0; i < 3; i++) {
                if (canPlace(grid, row, col, rows, cols, i)) {
                    grid[row][col] = i;
                    dfs(grid, row, col + 1, rows, cols);
                    grid[row][col] = null;
                }
            }
        }
    }
//    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    static boolean canPlace(Integer[][] grid, int row, int col, int rows, int cols, int val) {
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] != null && grid[newRow][newCol] == val)
                return false;
        }
        return true;
    }
}
