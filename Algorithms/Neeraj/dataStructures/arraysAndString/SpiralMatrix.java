import java.util.ArrayList;
import java.util.List;

/*
Problem: https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1168/
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
Solution: https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(spiralTraverse(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(spiralOrder(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}}));
        System.out.println(spiralTraverse(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}}));
        System.out.println(spiralOrder(new int[][]{
                {4, 2, 3, 6, 7, 8, 1, 9, 5, 10},
                {12, 19, 15, 16, 20, 18, 13, 17, 11, 14}}));
        System.out.println(spiralTraverse(new int[][]{
                {4, 2, 3, 6, 7, 8, 1, 9, 5, 10},
                {12, 19, 15, 16, 20, 18, 13, 17, 11, 14}}));
    }


    public static List<Integer> spiralTraverse(int[][] array) {
        int startRow = 0, startCol = 0, endRow = array.length, endCol = array[0].length;
        List<Integer> op = new ArrayList<>();
        while (startRow < endRow && startCol < endCol) {
//            Traverse through the top row.
            for (int i = startCol; i < endCol; i++) {
                op.add(array[startRow][i]);
            }
            startRow++;

//            Traverse through the last column.
            for (int i = startRow; i < endRow; i++) {
                op.add(array[i][endCol-1]);
            }
            endCol--;

//            Traverse through the last row (from right to left), only when startRow != endRow.
            if (startRow < endRow) {
                for (int i = endCol - 1; i >= startCol; i--) {
                    op.add(array[endRow-1][i]);
                }
                endRow--;
            }

//            Travel through the first column (from bottom to top), oly when startCol != endCol
            if (startCol < endCol) {
                for (int i = endRow - 1; i >= startRow; i--) {
                    op.add(array[i][startCol]);
                }
                startCol++;
            }
        }
        return op;
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();

        int rows = matrix.length;
        int column = rows > 0 ? matrix[0].length : 0;
        if (column == 0) return output;
        int startingRow = 0, startingColumn = 0;

        while (startingRow < rows && startingColumn < column) {

//            Loop through the first Rows.
            for (int i = startingColumn; i < column; i++) {
                output.add(matrix[startingRow][i]);
            }
            startingRow++;
//            Loop through the last columns.
            for (int i = startingRow; i < rows; i++) {
                output.add(matrix[i][column - 1]);
            }
            column--;
//            Loop through the last row.
            if (startingRow < rows) {
                for (int i = column - 1; i >= startingColumn; i--) {
                    output.add(matrix[rows - 1][i]);
                }
                rows--;
            }
//            Loop through the first column.
            if (startingColumn < column) {
                for (int i = rows - 1; i >= startingRow; --i) {
                    output.add(matrix[i][startingColumn]);
                }
                startingColumn++;
            }
        }
        return output;
    }
}
