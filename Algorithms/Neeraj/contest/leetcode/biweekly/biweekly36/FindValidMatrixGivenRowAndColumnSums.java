package biweekly.biweekly36;

/**
 * Created on:  Oct 03, 2020
 * Questions: https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 */
public class FindValidMatrixGivenRowAndColumnSums {
    static int[][] result;
    static boolean found = false;

    public static void main(String[] args) {

    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rows = rowSum.length, cols = colSum.length;
        result = new int[rows][cols];
        found = false;
        helper(0, 0, rows, cols, rowSum, colSum);
        return result;
    }

    private static void helper(int row, int col, int rows, int cols, int[] rowSum, int[] colSum) {
        if (col == cols) {
            col = 0;
            row++;
        }
        if (row == rows) {
            found = true;
            return;
        }
        int minVal = Math.min(rowSum[row], colSum[col]);
        if (minVal < 0) return;
        rowSum[row] -= minVal;
        colSum[col] -= minVal;
        result[row][col] = minVal;
        helper(row, col + 1, rows, cols, rowSum, colSum);
        rowSum[row] += minVal;
        colSum[col] += minVal;
//        for (int i = 0; i <= minVal; i++) {
//            rowSum[row] -= i;
//            colSum[col] -= i;
//            result[row][col] = i;
//            helper(row, col+1, rows, cols, rowSum, colSum);
//            rowSum[row] += i;
//            colSum[col] += i;
//        }
    }
}
