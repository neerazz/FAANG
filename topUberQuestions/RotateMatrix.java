import java.util.Arrays;

/**
 * Created on:  Nov 07, 2020
 * Questions: https://leetcode.com/discuss/interview-question/908341/Uber-OA-or-Oct-2020
 */

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 0}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        System.out.println("Input = " + Arrays.deepToString(arr));
        rotateMatrix(arr);
        System.out.println("Output = " + Arrays.deepToString(arr));
    }

    private static void rotateMatrix(int[][] matrix) {
        int len = matrix.length;
//        Inverse the matrix.
        inverseMatrix(matrix, len);
//        Transverse the matrix
        transverse(matrix, len);
//        Rotate the matrix diagonals.
        rotateDiagonals(matrix, len);
    }

    private static void rotateDiagonals(int[][] matrix, int len) {
        for (int i = 0; i < len / 2; i++) {
            int r = len - i - 1;
            int v1 = matrix[i][i], v2 = matrix[i][r], v3 = matrix[r][i], v4 = matrix[r][r];
            matrix[i][i] = v2;
            matrix[i][r] = v4;
            matrix[r][r] = v3;
            matrix[r][i] = v1;
        }
    }

    private static void transverse(int[][] matrix, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void inverseMatrix(int[][] matrix, int len) {
        for (int i = 0; i < len / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[len - i - 1];
            matrix[len - i - 1] = temp;
        }
    }
}
