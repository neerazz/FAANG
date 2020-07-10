import java.util.Arrays;

/**
 * Created on:  Jul 08, 2020
 * Questions: https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
 */
public class NumberOfWaysOfCuttingAPizza {
    public static void main(String[] args) {
        System.out.println(ways(new String[]{"A..", "AAA", "..."}, 3) + " should be [3].");
        System.out.println(ways(new String[]{"A..", "AA.", "..."}, 3) + " should be [1].");
        System.out.println(ways(new String[]{"A..", "A..", "..."}, 1) + " should be [1].");
        System.out.println(ways(new String[]{"AAAA.", "A..A.", "AA.AA"}, 5) + " should be [39].");
    }

    public static int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = rows > 0 ? pizza[0].length() : 0;
        int[][] vals = new int[rows + 1][cols + 1];
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                vals[row][col] = vals[row + 1][col] + vals[row][col + 1] - vals[row + 1][col + 1] + (pizza[row].charAt(col) == 'A' ? 1 : 0);
            }
        }
        int mod = (int) 1e9 + 7;

        int[][][] dp = new int[rows + 1][cols + 1][k + 1];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                for (int cut = 0; cut < k; cut++) {
                    if (cut == 0) {
                        dp[row][col][0] = vals[row][col] > 0 ? 1 : 0;
                    } else {
//        Try cutting horizontally in all possible ways
                        for (int h = row + 1; h < rows; h++) {
                            if (vals[row][col] - vals[h][col] > 0) {
                                dp[row][col][cut] = (dp[row][col][cut] + dp[h][col][cut - 1]) % mod;
                            }
                        }
//        Try cutting vertically in all possible ways
                        for (int v = col + 1; v < rows; v++) {
                            if (vals[row][col] - vals[row][v] > 0) {
                                dp[row][col][cut] = (dp[row][col][cut] + dp[row][v][cut - 1]) % mod;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][k - 1];
    }

    private static int backtracking(int[][] vals, Integer[][][] dp, int row, int col, int cuts, int rows, int cols) {
//        Always check if the lower part has an apple or not.
        if (cuts == 0) return hasApple(vals, row, col, rows, cols) ? 1 : 0;
        if (cuts < 0) return 0;
        if (dp[row][col][cuts] != null) return dp[row][col][cuts];
//        Assume that the upper part has an apple, and check only for the lower parts of the the pizza for apple.
        dp[row][col][cuts] = 0;
//        Try cutting horizontally in all possible ways
        for (int h = row + 1; h < rows; h++) {
            if (vals[row][col] < vals[h][col]) {
                dp[row][col][cuts] += backtracking(vals, dp, h, col, cuts - 1, rows, cols);
            } else break;
        }
//        Try cutting vertically in all possible ways
        for (int v = col + 1; v < rows; v++) {
            if (vals[row][col] < vals[row][v]) {
                dp[row][col][cuts] += backtracking(vals, dp, row, v, cuts - 1, rows, cols);
            } else break;
        }
        return dp[row][col][cuts];
    }

    private static boolean hasApple(int[][] vals, int row, int col, int rows, int cols) {
//        Check if the subarray start from row, col all the way to the end has an apple or not.
//        That can be found by finding the sum of sub-array
        return vals[rows - 1][cols - 1] - (col > 0 ? vals[rows - 1][col - 1] : 0) - (row > 0 ? vals[row - 1][cols - 1] : 0) + (row > 0 && col > 0 ? vals[row - 1][col - 1] : 0) > 0;
    }
}
