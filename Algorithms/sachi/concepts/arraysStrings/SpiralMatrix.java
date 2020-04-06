/*
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
 */

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        spiralOrder(matrix).forEach(e -> System.out.print(e + " "));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> sol = new ArrayList<>();
        int right = 0, down = 0, left = 0, top = 0;
        int i = 0, j = 0;
        while (sol.size() < rows * cols) {
            //Going right
            while (j < cols - down) {
                sol.add(matrix[i][j++]);
            }
            i++;
            j--;
            right++;
            if (sol.size() == rows * cols) return sol;
            //Going down
            while (i < rows - left) {
                sol.add(matrix[i++][j]);
            }
            j--;
            i--;
            down++;
            if (sol.size() == rows * cols) return sol;
            //Going left
            while (j >= top) {
                sol.add(matrix[i][j--]);
            }
            i--;
            j++;
            left++;
            if (sol.size() == rows * cols) return sol;
            //Going up
            while (i >= right) {
                sol.add(matrix[i--][j]);
            }
            j++;
            i++;
            top++;
        }
        return sol;
    }

    private static List<Integer> spiralOrderOld(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int a = 0, b = 0, c = 0, d = 0, dir = 0;
        int row = 0, col = 0;
        //0 - right, 1 - down, 2-left, 3-up
        List<Integer> sol = new ArrayList<>(m * n);
        for (int i = 0; i < m * n; i++) {
            sol.add(matrix[row][col]);
            if (dir == 0) {
                if (col + b == n - 1) {
                    a++;
                    row++;
                    dir = 1;
                } else {
                    col++;
                }
            } else if (dir == 1) {
                if (row + c == m - 1) {
                    b++;
                    col--;
                    dir = 2;
                } else {
                    row++;
                }
            } else if (dir == 2) {
                if (col - d == 0) {
                    c++;
                    row--;
                    dir = 3;
                } else {
                    col--;
                }
            } else if (dir == 3) {
                if (row - a == 0) {
                    d++;
                    col++;
                    dir = 0;
                } else {
                    row--;
                }
            }
        }
        return sol;
    }
}
