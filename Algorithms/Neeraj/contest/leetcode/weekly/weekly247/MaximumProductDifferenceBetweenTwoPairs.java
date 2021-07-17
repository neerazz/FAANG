package weekly.weekly247;

import java.util.Arrays;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-247/problems/maximum-product-difference-between-two-pairs/
 */

public class MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args) {

    }

    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        long first = (long) nums[len - 1] * nums[len-2], last = (long) nums[0] * nums[1];
        return (int) (first - last);
    }
}
