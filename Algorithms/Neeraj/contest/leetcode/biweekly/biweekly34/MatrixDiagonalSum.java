package biweekly.biweekly34;

/**
 * Created on:  Sep 05, 2020
 * Questions: https://leetcode.com/problems/matrix-diagonal-sum/
 */
public class MatrixDiagonalSum {
    public static void main(String[] args) {

    }

    public static int diagonalSum(int[][] mat) {
        int size = mat.length, sum = 0;
        for (int i = 0; i < size; i++) {
            int row = size - i - 1;
            sum += mat[i][i] + mat[row][i];
        }
        if (size % 2 == 1) {
            int mid = size / 2;
            sum -= mat[mid][mid];
        }
        return sum;
    }
}
