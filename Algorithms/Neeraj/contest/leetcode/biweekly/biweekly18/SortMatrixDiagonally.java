package biweekly.biweekly18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.
Example 1:
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 100
1 <= mat[i][j] <= 100
 */
public class SortMatrixDiagonally {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}})));
    }

    public static int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
//        System.out.println("Column wise");
        for (int j = 0; j < col; j++) {
//            System.out.println("---------------");
            List<Integer> arr = new ArrayList();
            int k = j;
            for (int i = 0; i < row && k < col; i++) {
                System.out.println("i = " + i + "\tk = " + k);
                arr.add(mat[i][k++]);
            }
            Collections.sort(arr);
            k = j;
            int l = 0;
            for (int i = 0; i < row && k < col; i++) {
                mat[i][k++] = arr.get(l);
                l++;
            }
        }
//        System.out.println("Row wise");
        for (int i = 1; i < row; i++) {
//            System.out.println("---------------");
            List<Integer> arr = new ArrayList();
            int k = i;
            for (int j = 0; j < col && k < row; j++) {
//                System.out.println("i = " + k + "\tj = " + j);
                arr.add(mat[k++][j]);
            }
            Collections.sort(arr);
            k = i;
            int l = 0;
            for (int j = 0; j < col && k < row; j++) {
                mat[k++][j] = arr.get(l);
                l++;
            }
        }
        return mat;
    }
}
