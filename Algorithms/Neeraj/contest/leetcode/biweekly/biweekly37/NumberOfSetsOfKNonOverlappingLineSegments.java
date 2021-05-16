package biweekly.biweekly37;

/**
 * Created on:  Oct 17, 2020
 * Questions:
 */

public class NumberOfSetsOfKNonOverlappingLineSegments {

    static int mod = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(numberOfSets(4, 2));
        System.out.println(numberOfSets(3, 1));
        System.out.println(numberOfSets(30, 7));
        System.out.println(numberOfSets(5, 3));
        System.out.println(numberOfSets(3, 2));
        System.out.println(numberOfSets(921, 753));
    }

    public static int numberOfSets(int n, int k) {
        Integer[][] dp = new Integer[n][k + 1];
        return helper(0, 0, n, k, dp);
    }

    private static int helper(int point, int curK, int n, int k, Integer[][] dp) {
        if (curK > k || point == n) return 0;
        if (dp[point][curK] != null) return dp[point][curK];
        if (curK == k) return dp[point][curK] = 1;
        int cur = 0;
//        Consider the current value
        int without = helper(point + 1, curK, n, k, dp);
        cur = (cur % mod + without % mod) % mod;
        for (int i = point + 1; i < n; i++) {
            cur = (cur % mod + helper(i, curK + 1, n, k, dp) % mod) % mod;
        }
        return dp[point][curK] = cur;
    }
}
