package weekly190;

import java.util.Arrays;

/**
 * Created on:  May 23, 2020
 * Questions: https://leetcode.com/problems/max-dot-product-of-two-subsequences
 */
public class MaxDotProductOfTwoSubsequences {
    public static void main(String[] args) {
        System.out.println(maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}) + " should be [18]");
        System.out.println(maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}) + " should be [21]");
        System.out.println(maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}) + " should be [-1]");
    }

    public static int maxDotProduct(int[] A, int[] B) {
        int rows = A.length, cols = B.length;
        int[][] dp = new int[rows + 1][cols + 1];
//        Fill the first row and first col with -Inf
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        for (int i = 1; i <= rows; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
//                Take the product of the two numbers
                int curProduct = (B[col - 1] * A[row - 1]);
//                Check if the current product increases by adding the left top number.
                if (dp[row - 1][col - 1] != Integer.MIN_VALUE) {
                    curProduct = Math.max(dp[row - 1][col - 1] + curProduct, curProduct);
                }
//                Take the maximum of top left and the currentProduct
                dp[row][col] = Math.max(curProduct, Math.max(dp[row - 1][col], dp[row][col - 1]));
                max = Math.max(max, dp[row][col]);
            }
        }
        return max;
    }
}
