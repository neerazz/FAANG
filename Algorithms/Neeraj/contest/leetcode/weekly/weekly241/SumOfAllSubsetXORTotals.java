package weekly.weekly241;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  May 15, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-241/problems/sum-of-all-subset-xor-totals/
 */

public class SumOfAllSubsetXORTotals {

    static int sum;

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

    public static int subsetXORSum(int[] nums) {
        sum = 0;
        helper(nums, 0);
        return sum;
    }

    private static List<Integer> helper(int[] nums, int idx) {
        List<Integer> current = new ArrayList<>();
        if (idx == nums.length) return new ArrayList<>();
        List<Integer> next = helper(nums, idx + 1);
        current.add(nums[idx]);
        sum += nums[idx];
        current.addAll(next);
        for (int val : next) {
            int subArray = nums[idx] ^ val;
            sum += subArray;
            current.add(subArray);
        }
        return current;
    }
}
