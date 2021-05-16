package biweekly.biweekly30;

import java.util.*;

/**
 * Created on:  Jul 11, 2020
 * Questions: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{5, 3, 2, 4}));
    }

    public static int minDifference(int[] nums) {
        int min = Integer.MAX_VALUE, len = nums.length;
        if (len <= 3) return 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, nums[len - 4 + i] - nums[i]);
        }
        return min;
    }
}
