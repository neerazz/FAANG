import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 27, 2020
 * Questions: https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3545/
 */

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {

    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return helper(nums, 0, target, dp);
    }

    /*
        1,5,11,5
        i
        t=11
    */
    private static boolean helper(int[] nums, int idx, int target, Boolean[][] dp) {
        if (target == 0) return true;
        if (idx >= nums.length || target < 0) return false;
        if (dp[idx][target] != null) return dp[idx][target];
        return dp[idx][target] = (helper(nums, idx + 1, target - nums[idx], dp) || helper(nums, idx + 1, target, dp));
    }
}
