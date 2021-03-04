import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 02, 2021
 * Questions: https://leetcode.com/problems/maximum-length-of-pair-chain/
 */

public class MaximumLengthOfPairChain {

    public static void main(String[] args) {

    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[0] == p2[0] ? Integer.compare(p1[1], p2[1]) : Integer.compare(p1[0], p2[0]));
        int len = pairs.length;
        Integer[] dp = new Integer[len + 1];
        for (int i = 0; i < len; i++) {
            helper(pairs, i, dp);
        }
        int max = 0;
        for (Integer val : dp) {
            if (val == null) continue;
            max = Math.max(max, val);
        }
        return max;
    }

    private static int helper(int[][] pairs, int start, Integer[] dp) {
        if (start >= pairs.length) return 0;
        if (dp[start] != null) return dp[start];
        int cur = 1;
        for (int i = start + 1; i < pairs.length; i++) {
            if (pairs[start][1] < pairs[i][0]) {
                int next = helper(pairs, i, dp);
                if (next + 1 > cur) cur = next + 1;
            }
        }
        return dp[start] = cur;
    }
}
