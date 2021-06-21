package biweekly.biweekly54;

/**
 * Created on:  Jun 12, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-54/problems/largest-magic-square/
 */

public class LargestMagicSquare {

    public static void main(String[] args) {
        System.out.println(largestMagicSquare(new int[][]{{7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}}) + " = 3");
        System.out.println(largestMagicSquare(new int[][]{{5, 1, 3, 1}, {9, 3, 3, 1}, {1, 3, 3, 8}}) + " = 2");
    }

    public static int largestMagicSquare(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int maxLen = Math.min(rows, cols);
        for (int len = maxLen; len > 1; len--) {
            if (hasMagicSquare(grid, len, rows, cols)) return len;
        }
        return 1;
    }

    public static int largestMagicSquare_dp(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int maxLen = Math.min(rows, cols);
        SubMatrix[][][] dp = new SubMatrix[maxLen + 1][rows][cols];
//        dp[i][j][k] = Rows, cols, diagonal sum of sub-matrix of length i, starting from row =j, and col = k.
        return 1;
    }

    static class SubMatrix {
        long[] rowsSum, colSum;
        long d1, d2;
    }

    public static int largestMagicSquare_binarySearch(int[][] grid) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int start = 1, end = Math.min(rows, cols);
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (hasMagicSquare(grid, mid, rows, cols)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (hasMagicSquare(grid, end, rows, cols)) return end;
        if (hasMagicSquare(grid, start, rows, cols)) return start;
        return 1;
    }

    private static boolean hasMagicSquare(int[][] grid, int len, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (isMagicSquare(grid, row, col, len, rows, cols)) return true;
            }
        }
        return false;
    }

    private static boolean isMagicSquare(int[][] grid, int rowStart, int colStart, int len, int rows, int cols) {
        int colEnd = colStart + len;
        if (rowStart + len > rows || colEnd > cols) return false;
        long[] rowSum = new long[len], colSum = new long[len];
        long d1 = 0, d2 = 0;
        for (int l1 = 0; l1 < len; l1++) {
            for (int l2 = 0; l2 < len; l2++) {
                int row = rowStart + l1, col = colStart + l2;
                rowSum[l1] += grid[row][col];
                colSum[l2] += grid[row][col];
            }
        }
        for (int l = 0; l < len; l++) {
            d1 += grid[rowStart + l][colStart + l];
        }
        for (int l = 0; l < len; l++) {
            d2 += grid[rowStart + l][colEnd - l - 1];
        }
        if (d1 != d2) return false;
        for (int i = 0; i < len; i++) {
            if (rowSum[i] != colSum[i] || rowSum[i] != d1 || colSum[i] != d1) return false;
        }
        return true;
    }
}
