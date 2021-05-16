package weekly.weekly221;

import java.util.*;

/**
 * Created on:  Dec 26, 2020
 * Questions:
 */

public class WhereWillTheBallFall {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findBall(new int[][]{{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}})));
    }

    public static int[] findBall(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int[] result = new int[cols];
        for (int i = 0; i < cols; i++) {
            result[i] = getVal(0, i, rows, cols, grid);
        }
        return result;
    }

    private static int getVal(int row, int col, int rows, int cols, int[][] grid) {
        if (row == rows) {
            return col;
        } else {
            int dir = grid[row][col];
            if (dir == 1 && (col + 1 >= cols || dir + grid[row][col + 1] == 0)) return -1;
            if (dir == -1 && (col - 1 < 0 || dir + grid[row][col - 1] == 0)) return -1;
            return getVal(row + 1, col + dir, rows, cols, grid);
        }
    }
}
