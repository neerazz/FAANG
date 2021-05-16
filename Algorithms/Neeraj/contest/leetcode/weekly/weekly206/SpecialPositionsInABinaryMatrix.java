package weekly.weekly206;

/**
 * Created on:  Sep 12, 2020
 * Questions: https://leetcode.com/problems/special-positions-in-a-binary-matrix
 */
public class SpecialPositionsInABinaryMatrix {
    public static void main(String[] args) {

    }

    public static int numSpecial(int[][] mat) {
        int rows = mat.length, cols = rows > 0 ? mat[0].length : 0;
        int[] sumr = new int[rows], sumc = new int[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sumr[row] += mat[row][col];
                sumc[col] += mat[row][col];
            }
        }
        int result = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 1 && sumr[row] == 1 && sumc[col] == 1) result++;
            }
        }
        return result;
    }
}
