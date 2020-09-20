/**
 * Created on:  Sep 20, 2020
 * Questions: https://leetcode.com/problems/unique-paths-iii/
 */
public class UniquePathsIII {
    static int occ;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}) + " = 2");
        System.out.println(uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}) + " = 4");
        System.out.println(uniquePathsIII(new int[][]{{0, 1}, {2, 0}}) + " = 0");
    }

    public static int uniquePathsIII(int[][] grid) {
        occ = 0;
        int[] start = new int[2], end = new int[2];
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0, noObstacle = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] >= 0) noObstacle++;
                if (grid[row][col] == 1) start = new int[]{row, col};
                if (grid[row][col] == 2) end = new int[]{row, col};
            }
        }
        dfs(start, end, grid, rows, cols, noObstacle);
        return occ;
    }

    private static void dfs(int[] cur, int[] end, int[][] grid, int rows, int cols, int noObstacle) {
        if (grid[cur[0]][cur[1]] == 2 && noObstacle == 1) {
            occ++;
            return;
        }
        int temp = grid[cur[0]][cur[1]];
        grid[cur[0]][cur[1]] = -1;
        for (int[] dir : dirs) {
            int nr = cur[0] + dir[0], nc = cur[1] + dir[1];
            if (nr < rows && nr >= 0 && nc >= 0 && nc < cols && grid[nr][nc] >= 0) {
                dfs(new int[]{nr, nc}, end, grid, rows, cols, noObstacle - 1);
            }
        }
        grid[cur[0]][cur[1]] = temp;
    }

}
