import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 09, 2021
 * Questions: https://leetcode.com/problems/partition-array-for-maximum-sum/
 */

public class PartitionArrayForMaximumSum {

    public static void main(String[] args) {

    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length;
        Integer[] dp = new Integer[len];
        return helper(arr, 0, k, dp);
    }

    private int helper(int[] nums, int start, int k, Integer[] dp) {
        if (start == nums.length) return 0;
        if (dp[start] != null) return dp[start];
        int max = 0, best = 0, count = 0;
        for (int i = start; i < start + k && i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            count++;
            int cur = max * count + helper(nums, i + 1, k, dp);
            best = Math.max(best, cur);
        }
        // System.out.println("Start =" + start + " best = " + best);
        return dp[start] = best;
    }
}
