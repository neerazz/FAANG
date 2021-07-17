package weekly.weekly247;

import java.util.Arrays;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-247/problems/cyclically-rotating-a-grid/
 */

public class CyclicallyRotatingAGrid {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateGrid(new int[][]{{40, 10}, {30, 20}}, 1)));
        System.out.println(Arrays.deepToString(rotateGrid(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 2)));
        System.out.println(Arrays.deepToString(rotateGrid(new int[][]{{10, 1, 4, 8}, {6, 6, 3, 10}, {7, 4, 7, 10}, {1, 10, 6, 1}, {2, 1, 1, 10}, {3, 8, 9, 2}, {7, 1, 10, 10}, {7, 1, 4, 9}, {2, 2, 4, 2}, {10, 7, 5, 10}}, 1)));
    }

    public static int[][] rotateGrid(int[][] grid, int k) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int layers = Math.min(rows, cols) / 2;
        int startRow = 0, startCol = 0;
        int endRow = rows, endCol = cols;
        int[][] temp = new int[rows][cols];
        while (startRow < endRow || startCol < endCol) {
            for (int l = 0; l < layers; l++) {
                int currentSquare = (endRow - startRow) * (endCol - startCol);
                int innerSquare = (endRow - startRow - 2) * (endCol - startCol - 2);
                int curTotal = currentSquare - innerSquare;
                int rotations = k % curTotal;
                for (int r = 0; r < rotations; r++) {
                    rotate(grid, temp, startRow, startCol, endRow, endCol);
                    mannualCopy(temp, grid);
                }
                startRow++;
                startCol++;
                endRow--;
                endCol--;
            }
            if (startRow == endRow || startCol == endCol) break;
            if (startRow == rows) startRow = 0;
            if (startCol == cols) startCol = 0;
        }
        return grid;
    }

    private static void mannualCopy(int[][] from, int[][] to) {
        for (int i = 0; i < from.length; i++) {
            for (int j = 0; j < from[i].length; j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    private static void rotate(int[][] grid, int[][] temp, int startRow, int startCol, int endRow, int endCol) {
        mannualCopy(grid, temp);
//        Top Column
        for (int i = startCol + 1; i < endCol; i++) {
            temp[startRow][i - 1] = grid[startRow][i];
        }
//        Left Column
        for (int i = startRow; i < endRow - 1; i++) {
            temp[i + 1][startCol] = grid[i][startCol];
        }
//        Bottom Array
        for (int i = startCol; i < endCol - 1; i++) {
            temp[endRow - 1][i + 1] = grid[endRow - 1][i];
        }
//        Right Column
        for (int i = startRow + 1; i < endRow; i++) {
            temp[i - 1][endCol - 1] = grid[i][endCol - 1];
        }
    }
}
