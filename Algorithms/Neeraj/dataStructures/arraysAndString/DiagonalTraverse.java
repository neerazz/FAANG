import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Problem: https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
Solution: https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/discuss/357154/Simple-Java-Solution-beats-100-1-ms-Runtime

 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public static int[] findDiagonalOrder_elegent(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return (new int[0]); //if empty matrix
        int col = matrix[0].length;
        int[] ans = new int[row * col];
        int index = 0;
        int i = 0, j = 0;

        while (i < row && j < col) {
            while (i >= 0 && j < col) { //moving up
                ans[index] = matrix[i][j];
                index++;
                j++;
                i--;
            }
            i++;
            if (j == col) { //reach beyond column
                i++;
                j--;
            }
            while (j >= 0 && i < row) { //moving down
                ans[index] = matrix[i][j];
                index++;
                i++;
                j--;
            }
            j++;
            if (i == row) { //reach beyond row
                i--;
                j++;
            }
        }
        return ans;
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0){
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows*cols];
        int resultIndex = 0;
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < rows + cols - 1; i++) {
//            Find the starting row.
            int row = i < cols ? 0 : i - cols + 1;
            int col = i < cols ? i : cols - 1;

            while (row >= 0 && row < rows && col >= 0 && col < cols) {
                digits.add(matrix[row][col]);
                row++;
                col--;
            }

            if (i % 2 == 0) {
//                All even diagonal should travel up.
                Collections.reverse(digits);
            }
            for (int num : digits){
                result[resultIndex++] = num;
            }
            digits.clear();
        }
        return result;
    }
}
