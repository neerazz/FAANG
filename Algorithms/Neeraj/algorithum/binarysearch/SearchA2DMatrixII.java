/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:
Consider the following matrix:

{
  {1,   4,  7, 11, 15},
  {2,   5,  8, 12, 19},
  {3,   6,  9, 16, 22},
  {10, 13, 14, 17, 24},
  {18, 21, 23, 26, 30}
}
Given target = 5, return true.
Given target = 20, return false.
Solution: https://www.youtube.com/watch?v=Ohke9-qwAKU
 */
public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(matrix, 5));
        System.out.println(searchMatrix(matrix, 14));
        System.out.println(searchMatrix(matrix, 20));
        matrix = new int[][]{{}};
        System.out.println(searchMatrix(matrix, 20));
        matrix = new int[][]{{-5}};
        System.out.println(searchMatrix(matrix, -10));
        matrix = new int[][]{{1, 1}};
        System.out.println(searchMatrix(matrix, 0));
    }

    public static boolean searchMatrix_rev2(int[][] matrix, int target) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        if (rows == 1 && cols == 1) return matrix[0][0] == target;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            while (row < rows && col >= 0) {
                int cur = matrix[row][col];
                if (cur == target) return true;
                if (cur < target) row++;
                if (cur > target) col--;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        if (cols == 0) return false;
        if (rows == 1 && cols == 1) return matrix[0][0] == target;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
//            Loop through the first Row from last to first.
            while (col >= 0) {
                int cur = matrix[0][col];
                if (cur == target) return true;
                if (cur < target) {
//                    If target is greater, move down the rows.
                    while (row < rows) {
                        cur = matrix[row][col];
                        if (cur == target) return true;
                        if (cur > target) {
//                            When greater than target, move left the cols.
                            break;
                        }
                        row++;
                    }
                }
                col--;
            }
        }
        return false;
    }
}