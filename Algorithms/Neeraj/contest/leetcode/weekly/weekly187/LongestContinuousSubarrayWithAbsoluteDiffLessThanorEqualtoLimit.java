package weekly.weekly187;
/*
    Created on:  May 02, 2020
 */

import java.util.TreeMap;

/**
 * Questions: https://leetcode.com/contest/weekly-contest-187/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
        System.out.println(longestSubarray(new int[]{8}, 10));
        System.out.println(longestSubarray(new int[]{4, 8, 5, 1, 7, 9}, 6));
    }

    public static int longestSubarray(int[] nums, int limit) {
        int max = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            count++;
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if (Math.abs(map.firstKey() - map.lastKey()) <= limit) {
                max = Math.max(max, count);
            } else {
//                Keep removing from the start.
                while (Math.abs(map.firstKey() - map.lastKey()) > limit) {
                    int startVal = nums[start++];
                    if (map.get(startVal) > 1) map.put(startVal, map.get(startVal) - 1);
                    else map.remove(startVal);
                    count--;
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
}