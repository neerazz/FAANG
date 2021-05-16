package weekly.weekly224;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Jan 16, 2021
 * Questions:
 */

public class LargestSubmatrixWithRearrangements {

    public static void main(String[] args) {
        System.out.println(largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}}));
    }

    public static int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int max = 0;
        for (int col = 0; col < cols; col++) {
            int cnt = 0;
            for (int row = 0; row < rows; row++) {
                if (matrix[row][col] == 1) {
//                    Count number of 1's in each column.
                    matrix[row][col] = ++cnt;
                } else {
                    matrix[row][col] = cnt = 0;
                }
            }
        }
        for (int[] rowVales : matrix) {
//            Consider the i_th row. we reversely sort the i_th row, then it will be very easy to get the largest matrix for this row
            List<Integer> colVales = Arrays.stream(rowVales).boxed().
                    sorted((v1, v2) -> Integer.compare(v2, v1))
                    .collect(Collectors.toList());
//            Loop through all the columns and keep checking the column that can form the biggest sub-matrix.
            for (int col = 0; col < cols; col++) {
//                Multiply the  (continues 1's in the col) by *
//                              (the cal index, there will not be any zeros before this col, because we are sorting.)
                int curSize = (col + 1) * colVales.get(col);
                max = Math.max(max, curSize);
            }
        }
        return max;
    }
}
