package RealAndMockInterview.pramp;

import java.util.Arrays;

public class NumberOfPaths {

    // dp[i,j] = dp[i-1, j] + dp[i, j-1]
    static int numOfPathsToDest(int n) {
        // your code goes here
        int[][] dp = new int[n][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(numOfPathsToDest(4));
    }

}
