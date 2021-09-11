/**
 * Created on:  May 25, 2020
 * Questions: https://leetcode.com/problems/uncrossed-lines/
 */
public class UncrossedLines {
    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}) + " should be [2]");
        System.out.println(maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}) + " should be [3]");
        System.out.println(maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}) + " should be [2]");
        System.out.println(maxUncrossedLines(new int[]{4, 1, 2, 5, 1, 5, 3, 4, 1, 5}, new int[]{3, 1, 1, 3, 2, 5, 2, 4, 1, 3, 2, 2, 5, 5, 3, 5, 5, 1, 2, 1}) + " should be [7]");
        System.out.println(maxUncrossedLines(new int[]{3, 1, 4, 1, 1, 3, 5, 1, 2, 2}, new int[]{4, 1, 5, 2, 1, 1, 1, 5, 3, 1, 1, 1, 2, 3, 1, 4, 3, 5, 5, 3, 1, 2, 3, 2, 4, 1, 1, 1, 5, 3}) + " should be [9]");
    }

    public static int maxUncrossedLines(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;
        int rows = A.length, cols = B.length;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
                int preMax = Math.max(dp[row - 1][col], dp[row][col - 1]);
                if (A[row - 1] == B[col - 1]) {
                    dp[row][col] = Math.max(preMax, dp[row - 1][col - 1] + 1);
                } else {
                    dp[row][col] = preMax;
                }
            }
        }
        return dp[rows][cols];
    }
}
