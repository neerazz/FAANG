package ds.recursion2;

/*
https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2804/
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
Given an integer n, return the number of distinct solutions to the n-queens puzzle.
Example:
Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class NQueensII {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4) + " should be [2].");
    }

    public static int totalNQueens(int n) {
        if (n <= 0) return n == 0 ? 0 : 1;
        boolean[] rows = new boolean[n], diags = new boolean[2 * n], antiDiags = new boolean[2 * n];
        return solve(0, n, rows, antiDiags, diags);
    }

    private static int solve(int col, int n, boolean[] rows, boolean[] antiDiags, boolean[] diags) {
        if (col == n) return 1;
        int sum = 0;
        for (int row = 0; row < n; row++) {
            if (rows[row] || antiDiags[row - col + n] || diags[row + col])
                continue;
            rows[row] = antiDiags[row - col + n] = diags[row + col] = true;
            sum += solve(col + 1, n, rows, antiDiags, diags);
            rows[row] = antiDiags[row - col + n] = diags[row + col] = false;
        }
        return sum;
    }

    public static int totalNQueens_optimal(int n) {
        boolean[][] chessBoard = new boolean[n][n];
        int[] rows = new int[n];
        // "hill" diagonals
        int[] hills = new int[4 * n - 1];
        // "dale" diagonals
        int[] dales = new int[2 * n - 1];
        return backtrack(0, 0, n, rows, hills, dales);
    }

    public static boolean isNotUnderAttack(int row, int col, int n, int[] rows, int[] hills, int[] dales) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return res == 0;
    }

    public static int backtrack(int row, int count, int n, int[] rows, int[] hills, int[] dales) {
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col, n, rows, hills, dales)) {
                // place_queen
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;  // "hill" diagonals
                dales[row + col] = 1;   //"dale" diagonals
                // if n queens are already placed
                if (row + 1 == n) count++;
                    // if not proceed to place the rest
                else count = backtrack(row + 1, count, n,
                        rows, hills, dales);
                // remove queen
                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }
        return count;
    }
}
