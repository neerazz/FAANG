package weekly.weekly196;

/**
 * Created on:  Jul 04, 2020
 * Questions: https://leetcode.com/problems/count-submatrices-with-all-ones
 */
public class CountSubmatricesWithAllOnes {
    public static void main(String[] args) {
        System.out.println(numSubmat(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}}
        ) + " should be [13].");
        System.out.println(numSubmat(new int[][]{{0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0}}
        ) + " should be [24].");
        System.out.println(numSubmat(new int[][]{{1, 1, 1, 1, 1, 1}}
        ) + " should be [21].");
        System.out.println(numSubmat(new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 1}}
        ) + " should be [5].");
    }

    public static int numSubmat(int[][] mat) {
        int rows = mat.length, cols = rows > 0 ? mat[0].length : 0;
        int[][] dp = new int[rows][cols];
//        The dp array will hold the maximum continues 1's horizontally.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 1) {
                    dp[row][col] = col - 1 >= 0 ? dp[row][col - 1] + mat[row][col] : mat[row][col];
                }
            }
        }
        int result = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result += dp[row][col];
                int maxLen = dp[row][col];
//                Travel downwards and find the biggest square that can be formed.
                for (int k = row + 1; k < rows; k++) {
//                        Get the maximum length of 1's at the given column in the next row.
                    maxLen = Math.min(maxLen, dp[k][col]);
                    result += maxLen;
//                        When a row with zero length is found then break.
                    if (maxLen == 0) break;
                }
            }
        }
        return result;
    }
}
