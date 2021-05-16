package biweekly.biweekly34;

/**
 * Created on:  Sep 05, 2020
 * Questions: https://leetcode.com/problems/count-all-possible-routes
 */
public class CountAllPossibleRoutes {
    static int mod = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println("**************************** Solution 1 ******************************");
        System.out.println(countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5) + " = 4");
        System.out.println(countRoutes(new int[]{4, 3, 1}, 1, 0, 6) + " = 5");
        System.out.println(countRoutes(new int[]{2, 1, 5}, 0, 0, 6) + " = 2");
        System.out.println(countRoutes(new int[]{1, 2, 3}, 0, 2, 40) + " = 615088286");
    }

    public static int countRoutes(int[] locations, int start, int finish, int fuel) {
        int len = locations.length;
        Integer[][] dp = new Integer[len + 1][fuel + 1];
        return helper(locations, start, finish, fuel, dp);
    }

    private static int helper(int[] locs, int start, int end, int fuel, Integer[][] dp) {
        if (fuel < 0) return 0;
        if (dp[start][fuel] != null) return dp[start][fuel];
        long cur = start == end ? 1 : 0;
        for (int i = 0; i < locs.length; i++) {
            if (i != start) {
                cur = (cur + helper(locs, i, end, fuel - Math.abs(locs[start] - locs[i]), dp)) % mod;
            }
        }
        return dp[start][fuel] = (int) (cur % mod);
    }
}
