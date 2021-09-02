import java.util.*;

/**
 * Created on:  Sep 01, 2021
 * Ref: https://leetcode.com/problems/magic-squares-in-grid/
 */
public class MagicSquaresInGrid {
    public static void main(String[] args) {

    }

    public static int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                count += isMagic(grid, row, col, rows, cols) ? 1 : 0;
            }
        }
        return count;
    }

    static boolean isMagic(int[][] grid, int row, int col, int rows, int cols) {
        if (row + 3 > rows || col + 3 > cols) return false;
        int[] rsum = new int[3], csum = new int[3];
        int d1 = 0, d2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int cur = grid[r + row][c + col];
                set.add(cur);
                rsum[r] += cur;
                csum[c] += cur;
                if (r == c) d1 += cur;
                if (r + c == 2) d2 += cur;
            }
        }
        // System.out.println("Row Sum = " + Arrays.toString(rsum));
        // System.out.println("Col Sum =" + Arrays.toString(csum));
        // System.out.println("D1 =" + d1 + " D2 = " + d2);
        if (d1 != d2) return false;
        if (rsum[0] != d1 || rsum[1] != d1 || rsum[2] != d1) return false;
        if (csum[0] != d1 || csum[1] != d1 || csum[2] != d1) return false;
        for (int i = 1; i <= 9; i++) {
            if (!set.contains(i)) return false;
        }
        return true;
    }
}
