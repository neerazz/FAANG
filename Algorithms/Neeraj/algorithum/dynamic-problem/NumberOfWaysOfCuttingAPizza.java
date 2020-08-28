/**
 * Created on:  Jul 08, 2020
 * Questions: https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/
 */
public class NumberOfWaysOfCuttingAPizza {
    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        System.out.println("********************************* Solution 1 ********************************* ");
        System.out.println(ways(new String[]{"A..", "AAA", "..."}, 3) + " should be [3].");
        System.out.println(ways(new String[]{"A..", "AA.", "..."}, 3) + " should be [1].");
        System.out.println(ways(new String[]{"A..", "A..", "..."}, 1) + " should be [1].");
        System.out.println(ways(new String[]{"AAAA.", "A..A.", "AA.AA"}, 5) + " should be [39].");

        System.out.println("********************************* Solution 2 ********************************* ");
        System.out.println(ways_rev1(new String[]{"A..", "AAA", "..."}, 3) + " should be [3].");
        System.out.println(ways_rev1(new String[]{"A..", "AA.", "..."}, 3) + " should be [1].");
        System.out.println(ways_rev1(new String[]{"A..", "A..", "..."}, 1) + " should be [1].");
        System.out.println(ways_rev1(new String[]{"AAAA.", "A..A.", "AA.AA"}, 5) + " should be [39].");
    }

    public static int ways_rev1(String[] pizza, int k) {
        int rows = pizza.length, cols = rows > 0 ? pizza[0].length() : 0;
        int[][] vals = new int[rows + 1][cols + 1];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                vals[row][col] = vals[row + 1][col] + vals[row][col + 1] - vals[row + 1][col + 1] + (pizza[row].charAt(col) == 'A' ? 1 : 0);
            }
        }
        Integer[][][] dp = new Integer[rows][cols][k + 1];
        return backtracking(vals, dp, 0, 0, rows, cols, 1, k);
    }

    private static int backtracking(int[][] vals, Integer[][][] dp, int row, int col, int rows, int cols, int cut, int cuts) {
        if (dp[row][col][cut] != null) return dp[row][col][cut];
//        When you reach total number of cuts. Since we are starting the cuts from 1, so check with cuts.
        if (cut == cuts) return dp[row][col][cut] = vals[row][col] > 0 ? 1 : 0;
//        Assume that the upper part has an apple, and check only for the lower parts of the the pizza for apple.
        int cur = 0;
//        Try cutting horizontally in all possible ways
        for (int h = row; h < rows - 1; h++) {
            if (vals[row][col] > vals[h + 1][col]) {
                cur = (cur + backtracking(vals, dp, h + 1, col, rows, cols, cut + 1, cuts)) % mod;
            }
        }
//        Try cutting vertically in all possible ways
        for (int v = col; v < cols - 1; v++) {
            if (vals[row][col] > vals[row][v + 1]) {
                cur = (cur + backtracking(vals, dp, row, v + 1, rows, cols, cut + 1, cuts)) % mod;
            }
        }
        return dp[row][col][cut] = cur;
    }

    public static int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = rows > 0 ? pizza[0].length() : 0;
        int[][] vals = new int[rows + 1][cols + 1];
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                vals[row][col] = vals[row + 1][col] + vals[row][col + 1] - vals[row + 1][col + 1] + (pizza[row].charAt(col) == 'A' ? 1 : 0);
            }
        }

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
}