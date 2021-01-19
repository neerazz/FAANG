import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 17, 2021
 * Questions: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3607/
 */

public class CountSortedVowelStrings {

    public static void main(String[] args) {

    }

    public static int countVowelStrings(int n) {
        Integer[][] dp = new Integer[6][n + 1];
        return helper(0, 0, n, dp);
    }

    private static int helper(int pre, int soFar, int n, Integer[][] dp) {
        if (pre >= 5) return 0;
        if (n == soFar) return 1;
        // System.out.println("pre = " + pre + " soFar=" + soFar);
        if (dp[pre][soFar] != null) return dp[pre][soFar];
        int count = 0;
        for (int i = pre; i < 5; i++) {
            count += helper(i, soFar + 1, n, dp);
        }
        return dp[pre][soFar] = count;
    }
}
