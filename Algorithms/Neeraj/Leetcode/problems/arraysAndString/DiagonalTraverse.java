package problems.arraysAndString;

import java.util.Arrays;

/*
Problem: https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
Solution: https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/discuss/357154/Simple-Java-Solution-beats-100-1-ms-Runtime

 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        System.out.println(findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
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
            // for(int tmp = 0; tmp<index;tmp++) System.out.print(ans[tmp]+" ");
        }
        return ans;
    }

    public static int[] findDiagonalOrder2(int[][] matrix) {
        int rows = matrix.length;
        int columns = rows > 0 ? matrix[0].length : 0;
        if (columns == 0) {
            return new int[]{};
        }
        if (rows == 1 && columns == 1) return matrix[0];
        int[] output = new int[rows * columns];
        boolean goUp = true, goDown = false;
        int currentRow = 0, currentColumn = 0;

        for (int i = 0; i < rows * columns - 1; i++) {
            output[i] = matrix[currentRow][currentColumn];

            if (currentRow == 0 && currentColumn == 0) {
                goDown = false;
                goUp = true;
            } else if (currentRow == 0) {
                goDown = true;
                goUp = false;
            } else if (currentColumn == 0) {
                goDown = false;
                goUp = true;
            }

            if (goUp) {
                currentColumn = currentColumn + 1;
                currentRow = currentRow == 0 ? currentRow : currentRow - 1;
            }
            if (goDown) {
                currentColumn--;
                currentRow++;
            }

        }
        System.out.println(Arrays.toString(output));
        return output;
    }
}
