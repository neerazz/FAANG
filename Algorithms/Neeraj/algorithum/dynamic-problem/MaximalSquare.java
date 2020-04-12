/**
 * Crated on:  Apr 08, 2020
 */
public class MaximalSquare {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}) + " should be [4]");
        System.out.println(sol.maximalSquare(new char[][]{{'0', '0', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}}) +
                " should be [9]");
    }

    static class Solution {
        int maxLen = 0;
        public int maximalSquare(char[][] matrix) {
            int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
            int[][] dp = new int[rows + 1][cols + 1];
            if (cols != 0) {
                for (int row = 1; row <= rows; row++) {
                    for (int col = 1; col <= cols; col++) {
                        char cur = matrix[row-1][col-1];
                        if (cur == '1') {
                            int minBorder = min(dp[row-1][col],dp[row-1][col-1],dp[row][col-1]);
//                            Set the max value at each dp element
                            dp[row][col] = minBorder + 1;
                            maxLen = Math.max(maxLen,dp[row][col]);
                        }
                    }
                }
            }
            return maxLen * maxLen;
        }

        private int min(int a, int b, int c){
            return Math.min(Math.min(a,b),c);
        }
    }
}
