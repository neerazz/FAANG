import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 29, 2021
 * Questions: https://leetcode.com/problems/number-of-corner-rectangles/
 */

public class NumberOfCornerRectangles {

    public static void main(String[] args) {

    }

    public static int countCornerRectangles(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        List<Integer>[] ones = new ArrayList[rows];
        int count = 0;
        for (int row = 0; row < rows; row++) {
            ones[row] = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    for (int c1 : ones[row]) {
//                         Loop through all the ones in that row and find
//                         if with (row, col) as right bottom corner, can you form a rectangle.
                        for (int r1 = 0; r1 < row; r1++) {
                            if (grid[r1][c1] == 1 && grid[r1][col] == 1) count++;
                        }
                    }
                    ones[row].add(col);
                }
            }
        }
        return count;
    }
}
