package matrix;

import util.Util;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/spiral-matrix/
F

Given an m x n matrix, return all elements of the matrix in spiral order.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

*/
public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Util.print(matrix);
        System.out.println(spiralOrder(matrix));
    }

    // Insight - You need to reduce each element after increasing in while loop, because they went out of bounds
    //You need to check the size of the sol to exit.
    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = 0, top = 0, down = 0;
        int r = 0, c = 0;
        List<Integer> sol = new ArrayList<>();
        while (sol.size() < row * col) {
            // Go right
            while (c < col - down) {
                sol.add(matrix[r][c]);
                c++;
            }
            c--; // Because J went out of bounds
            r++; // Go to next row
            right++;
            if (sol.size() == row * col)
                return sol;

            // Go down
            while (r < row - left) {
                sol.add(matrix[r][c]);
                r++;
            }
            r--; // Out of bounds
            c--; // Previous column
            down++;
            if (sol.size() == row * col)
                return sol;

            // Go left
            while (c >= top) {
                sol.add(matrix[r][c]);
                c--;
            }
            c++; // Bound
            r--; // Previous row
            left++;
            if (sol.size() == row * col)
                return sol;

            // Go up
            while (r >= right) {
                sol.add(matrix[r][c]);
                r--;
            }
            r++; // Bounds
            c++; // Next column
            top++;
        }
        return sol;
    }

}