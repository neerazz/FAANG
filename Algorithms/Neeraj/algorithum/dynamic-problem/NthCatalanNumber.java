/*
  Crated on:  Apr 11, 2020
 */

/**
 * The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862
 * Solution: https://www.youtube.com/watch?v=CMaZ69P1bAc
 */
public class NthCatalanNumber {
    public static void main(String[] args) {
        System.out.println(nthCatalanNumber(3) + " should be [5].");
        System.out.println(nthCatalanNumber(5) + " should be [42].");
        System.out.println(nthCatalanNumber(9) + " should be [4862].");
    }

    private static int nthCatalanNumber(int n) {
        int[] dp = new int[n + 1];
        if (n >= 1) dp[0] = 1;
        if (n >= 2) dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
