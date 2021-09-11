import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Mar 25, 2021
 * Questions: https://leetcode.com/problems/pacific-atlantic-water-flow/
 */

public class PacificAtlanticWaterFlow {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println("*********************************** Solution 1 *********************************");
        System.out.println(
                pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}}));

        System.out.println(pacificAtlantic(new int[][]{
                {11, 3, 2, 4, 14, 6, 13, 18, 1, 4, 12, 2, 4, 1, 16},
                {5, 11, 18, 0, 15, 14, 6, 17, 2, 17, 19, 15, 12, 3, 14},
                {10, 2, 5, 13, 11, 11, 13, 19, 11, 17, 14, 18, 14, 3, 11},
                {14, 2, 10, 7, 5, 11, 6, 11, 15, 11, 6, 11, 12, 3, 11},
                {13, 1, 16, 15, 8, 2, 16, 10, 9, 9, 10, 14, 7, 15, 13},
                {17, 12, 4, 17, 16, 5, 0, 4, 10, 15, 15, 15, 14, 5, 18},
                {9, 13, 18, 4, 14, 6, 7, 8, 5, 5, 6, 16, 13, 7, 2},
                {19, 9, 16, 19, 16, 6, 1, 11, 7, 2, 12, 10, 9, 18, 19},
                {19, 5, 19, 10, 7, 18, 6, 10, 7, 12, 14, 8, 4, 11, 16},
                {13, 3, 18, 9, 16, 12, 1, 0, 1, 14, 2, 6, 1, 16, 6},
                {14, 1, 12, 16, 7, 15, 9, 19, 14, 4, 16, 6, 11, 15, 7},
                {6, 15, 19, 13, 3, 2, 13, 7, 19, 11, 13, 16, 0, 16, 16},
                {1, 5, 9, 7, 12, 9, 2, 18, 6, 12, 1, 8, 1, 10, 19},
                {10, 11, 10, 11, 3, 5, 12, 0, 0, 8, 15, 7, 5, 13, 19},
                {8, 1, 17, 18, 3, 6, 8, 15, 0, 9, 8, 8, 12, 5, 18},
                {8, 3, 6, 12, 18, 15, 10, 10, 12, 19, 16, 7, 17, 17, 1},
                {12, 13, 6, 4, 12, 18, 18, 9, 4, 9, 13, 11, 5, 3, 14},
                {8, 4, 12, 11, 2, 2, 10, 3, 11, 17, 14, 2, 17, 4, 7},
                {8, 0, 14, 0, 13, 17, 11, 0, 16, 13, 15, 17, 4, 8, 3},
                {18, 15, 8, 11, 18, 3, 10, 18, 3, 3, 15, 9, 11, 15, 15}}));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        boolean[][] pacific = new boolean[rows][cols], atlantic = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            dfs(matrix, row, 0, rows, cols, pacific);
            dfs(matrix, row, cols - 1, rows, cols, atlantic);
        }
        for (int col = 0; col < cols; col++) {
            dfs(matrix, 0, col, rows, cols, pacific);
            dfs(matrix, rows - 1, col, rows, cols, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }
        return result;
    }

    static void dfs(int[][] matrix, int row, int col, int rows, int cols, boolean[][] dp) {
        dp[row][col] = true;
        for (int[] dir : dirs) {
            int nr = row + dir[0], nc = col + dir[1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
            if (matrix[nr][nc] == -1 || matrix[nr][nc] < matrix[row][col]) continue;
            if (dp[nr][nc]) continue;
            dfs(matrix, nr, nc, rows, cols, dp);
        }
    }
}
