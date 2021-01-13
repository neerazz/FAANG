import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 */

public class MinimumDifficultyOfAJobSchedule {

    public static void main(String[] args) {

    }

    public static int minDifficulty_rev1(int[] jobDifficulty, int d) {
        Integer[][] dp = new Integer[jobDifficulty.length + 1][d + 1];
        int result = helper(jobDifficulty, 0, d, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int[] jobs, int start, int days, Integer[][] dp) {
        if (jobs.length - start < days) return Integer.MAX_VALUE;
        if (days == 0) {
            if (start == jobs.length) return 0;
            return Integer.MAX_VALUE;
        }
        if (dp[start][days] != null) return dp[start][days];
        int cur = Integer.MAX_VALUE, max = 0;
        for (int i = start; i < jobs.length; i++) {
            max = Math.max(jobs[i], max);
            int next = helper(jobs, i + 1, days - 1, dp);
            if (next != Integer.MAX_VALUE) {
                cur = Math.min(cur, max + next);
            }
        }
        return dp[start][days] = cur;
    }

    public static int minDifficulty(int[] jobDifficulty, int d) {
        Map<String, Integer> memo = new HashMap<>();
        int result = helper(jobDifficulty, 0, d, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int[] jobs, int start, int days, Map<String, Integer> memo) {
        if (days == 0) {
            if (start == jobs.length) return 0;
            return Integer.MAX_VALUE;
        }
        String key = String.format("%d - %d", start, days);
        if (memo.containsKey(key)) return memo.get(key);
        int cur = Integer.MAX_VALUE, max = 0;
        for (int i = start; i < jobs.length; i++) {
            max = Math.max(jobs[i], max);
            int next = helper(jobs, i + 1, days - 1, memo);
            if (next != Integer.MAX_VALUE) {
                cur = Math.min(cur, max + next);
            }
        }
        memo.put(key, cur);
        return cur;
    }
}
