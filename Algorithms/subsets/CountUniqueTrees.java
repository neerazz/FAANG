/**
 * Created on:  Oct 07, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/gx6BMKoWqR9
 */

public class CountUniqueTrees {

    private static int helper(int s, int e, Integer[][] dp) {
        if (s > e) return 1;
        if (dp[s][e] != null) return dp[s][e];
        dp[s][e] = 0;
        if (s == e) {
            dp[s][e] = 1;
        } else {
            for (int i = s; i <= e; i++) {
                dp[s][e] += helper(s, i - 1, dp) * helper(i + 1, e, dp);
            }
        }
        return dp[s][e];
    }

    public static void main(String[] args) {
        countTrees(3);
        countTrees(56);
        countTrees(99);
        countTrees(134);
        countTrees(170);
    }

    public static int countTrees(int n) {
        int[] dp = new int[n + 1];
        if (n >= 1) dp[0] = 1;
        if (n >= 2) dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        Integer[][] dp2 = new Integer[n + 1][n + 1];
        helper(1, n, dp2);
        System.out.println("Dp        version : " + dp[n]);
        System.out.println("Recursive version : " + dp2[1][n]);
        return dp[n];
    }
}
