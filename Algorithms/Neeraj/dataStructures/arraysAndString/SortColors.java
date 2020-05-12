/*
    Created on:  May 11, 2020
 */

import java.util.Arrays;

/**
 * Questions: https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int num : nums) {
            if (num == 0) zero++;
            if (num == 1) one++;
            if (num == 2) two++;
        }
        int index = 0;
        while (index < zero) {
            nums[index++] = 0;
        }
        while (index < zero + one) {
            nums[index++] = 1;
        }
        while (index < nums.length) {
            nums[index++] = 2;
        }
    }
}
