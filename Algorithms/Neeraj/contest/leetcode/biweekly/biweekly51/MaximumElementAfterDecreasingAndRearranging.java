package biweekly.biweekly51;

import java.util.*;

/**
 * Created on:  May 01, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-51/problems/maximum-element-after-decreasing-and-rearranging/
 */

public class MaximumElementAfterDecreasingAndRearranging {

    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}) + " = 3");
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{2, 2, 1, 2, 1}) + " = 2");
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1, 2, 3, 4, 5}) + " = 5");
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[]{1000, 2000, 30000, 40000, 53289}) + " = 5");
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int pre = 0, max = 0;
        for (int cur : arr) {
            if (cur > pre + 1) {
                cur = pre + 1;
            }
            pre = cur;
            max = Math.max(max, cur);
        }
        return pre;
    }
}
