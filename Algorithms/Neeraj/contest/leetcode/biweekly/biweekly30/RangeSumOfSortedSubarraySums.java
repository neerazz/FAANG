package biweekly.biweekly30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on:  Jul 11, 2020
 * Questions: https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
 */
public class RangeSumOfSortedSubarraySums {
    public static void main(String[] args) {
        System.out.println(rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }

    public static int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            list.add(sum);
            for (int j = i + 1; j < nums.length; j++) {
                list.add(sum += nums[j]);
            }
        }
        return findSum(list, left, right);
    }

    private static int findSum(List<Integer> list, int left, int right) {
        Collections.sort(list);
        int op = 0, mod = 1_000_000_007;
        for (int i = left - 1; i < right; i++) {
            op = (op + list.get(i)) % mod;
        }
        return op;
    }
}
