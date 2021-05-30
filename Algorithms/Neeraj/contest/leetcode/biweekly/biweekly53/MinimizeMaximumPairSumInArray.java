package biweekly.biweekly53;

import java.util.Arrays;

/**
 * Created on:  May 29, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-53/problems/minimize-maximum-pair-sum-in-array/
 */

public class MinimizeMaximumPairSumInArray {

    public static void main(String[] args) {

    }

    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1, max = Integer.MIN_VALUE;
        while (start < end) {
            int sum = nums[start++] + nums[end--];
            max = Math.max(max, sum);
        }
        return max;
    }
}
