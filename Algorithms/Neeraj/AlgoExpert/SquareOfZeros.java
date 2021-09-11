import java.util.List;

/**
 * Created on:  Feb 07, 2021
 * Questions:
 */

public class SquareOfZeros {

    public static void main(String[] args) {

    }

    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        int n = matrix.size();
        int[][] rowCount = new int[n][n], colCount = new int[n][n];
        for (int r = 0; r < n; r++) {
            int count = 0;
            for (int c = n - 1; c >= 0; c--) {
                count = matrix.get(r).get(c) == 0 ? count + 1 : 0;
                rowCount[r][c] = count;
            }
        }
        for (int c = 0; c < n; c++) {
            int count = 0;
            for (int r = n - 1; r >= 0; r--) {
                count = matrix.get(r).get(c) == 0 ? count + 1 : 0;
                colCount[r][c] = count;
            }
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix.get(r).get(c) == 0 && squaresPossible(r, c, n, rowCount, colCount)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean squaresPossible(int row, int col, int n, int[][] rows, int[][] cols) {
        int hor = rows[row][col], ver = cols[row][col];
        for (int i = 1; i < Math.min(hor, ver); i++) {
            int nR = row + i, nC = col + i;
            int rowSum = rows[nR][col], colSum = cols[row][nC];
            if (Math.min(rowSum, colSum) >= i + 1) return true;
        }
        return false;
    }
}
