import java.util.Collections;
import java.util.LinkedList;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://leetcode.com/problems/sort-the-matrix-diagonally/
 */

public class SortTheMatrixDiagonally {

    public static void main(String[] args) {

    }

    public static int[][] diagonalSort(int[][] mat) {
        int rows = mat.length, cols = rows > 0 ? mat[0].length : 0;
//         Loop though all the daignal in the lower part of the matrix.
        for (int r = 0; r < rows; r++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int c = 0; c < cols && r + c < rows; c++) {
                list.add(mat[r + c][c]);
            }
            Collections.sort(list);
            for (int c = 0; c < cols && r + c < rows; c++) {
                mat[r + c][c] = list.removeFirst();
            }
        }
//         Loop through all the daiognal in the upper part of the matrix.
        for (int c = 1; c < cols; c++) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int r = 0; r < rows && c + r < cols; r++) {
                list.add(mat[r][c + r]);
            }
            Collections.sort(list);
            for (int r = 0; r < rows && c + r < cols; r++) {
                mat[r][r + c] = list.removeFirst();
            }
        }
        return mat;
    }
}
