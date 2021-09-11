/**
 * Created on:  Aug 10, 2021
 * Ref : https://leetcode.com/problems/flip-string-to-monotone-increasing/
 */
public class FlipStringToMonotoneIncreasing {
    public static void main(String[] args) {

    }

    public static int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
//        Calculate Pre Sum
        for (int i = 0; i < len; i++) {
            dp[i + 1] = dp[i] + (s.charAt(i) - '0');
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= len; i++) {
//            Ones before the point.
            int onesBefore = dp[i];
//            Zeros after this point= total chars after this point - total number of ones after the point.
            int zerosAfter = (len - i) - (dp[len] - dp[i]);
            min = Math.min(min, onesBefore + zerosAfter);
        }
        return min;
    }
}
