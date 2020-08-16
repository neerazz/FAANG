import java.util.Arrays;

/**
 * Created on:  Jul 22, 2020
 * Questions: https://leetcode.com/problems/sparse-matrix-multiplication/
 */
public class SparseMatrixMultiplication {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(multiply(new int[][]{{1, -5}}, new int[][]{{12}, {-1}})));
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int rows1 = A.length, cols1 = rows1 > 0 ? A[0].length : 0;
        int rows2 = B.length, cols2 = rows2 > 0 ? B[0].length : 0;
        int[][] op = new int[rows1][cols2];
        for (int row = 0; row < op.length; row++) {
            for (int col = 0; col < op[0].length; col++) {
                op[row][col] = multiply(A, B, row, col, cols1);
            }
        }
        return op;
    }

    private static int multiply(int[][] a, int[][] b, int row, int col, int cols) {
        int sum = 0;
        for (int i = 0; i < cols; i++) {
            sum += (a[row][i] * b[i][col]);
        }
        return sum;
    }
}
