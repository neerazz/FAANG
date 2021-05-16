package biweekly.biweekly47;

import java.util.*;

/**
 * Created on:  Mar 06, 2021
 * Questions:
 */

public class CheckIfNumberIsASumOfPowersOfThree {

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12) + " = true");
        System.out.println(checkPowersOfThree(91) + " = true");
        System.out.println(checkPowersOfThree(21) + " = false");
        System.out.println(checkPowersOfThree(21442) + " = false");
    }

    //    https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/discuss/1096361/Solution-with-proof-and-graph-(video)
    public static boolean checkPowersOfThree(int n) {
        for (int i = 15; i >= 0; i--) {
            int val = (int) Math.pow(3, i);
            if (val <= n) n -= val;
            if (n == 0) return true;
        }
        return false;
    }

    public static boolean checkPowersOfThree_naive(int n) {
//        boolean[] dp = new boolean[n + 1];
        Map<String, Boolean> memo = new HashMap<>();
        boolean[] powers = new boolean[(n + 1) / 3];
//        dp[0] = dp[1] = dp[3] = true;
        return dp(n, memo, powers);
    }

    private static boolean dp(int n, Map<String, Boolean> dp, boolean[] powers) {
        if (n == 0) return true;
        String key = Arrays.toString(powers);
        if (dp.containsKey(key)) return dp.get(key);
        int val = 1, pow = 0;
        boolean curVal = false;
        while (val <= n) {
            if (!powers[pow]) {
                powers[pow] = true;
                if (dp(n - val, dp, powers)) {
                    curVal = true;
                    break;
                }
                powers[pow] = false;
            }
            val *= 3;
            pow++;
        }
        dp.put(key, curVal);
        return curVal;
    }
}
