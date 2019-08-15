import java.util.Arrays;

public class MatrixDiagonalTraverse {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] matrix1 = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 } };
        Arrays.stream(findDiagonalOrder(matrix1)).forEach(e -> System.out.print(e + " "));

    }

    private static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[] {};
        int row = matrix.length;
        int col = matrix[0].length;
        int[] sol = new int[row * col];
        int rowP = 0, colP = 0, dir = 0;
        for (int i = 0; i < row * col; i++) {
            sol[i] = matrix[rowP][colP];
            // Up
            if (dir == 0) {
                rowP--;
                colP++;
                // End
                if (rowP < 0 || colP > col - 1) {
                    rowP++;
                    colP--;
                    if (colP < col - 1) {
                        colP++;
                    } else {
                        rowP++;
                    }
                    dir = 1;
                }
            } else {
                // Down
                rowP++;
                colP--;
                if (colP < 0 || rowP > row - 1) {
                    rowP--;
                    colP++;
                    if (rowP < row - 1) {
                        rowP++;
                    } else {
                        colP++;
                    }
                    dir = 0;
                }
            }
        }
        return sol;
    }

    public int[] findDiagonalOrderElegant(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // moving up
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else { // moving down
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return arr;
    }
}