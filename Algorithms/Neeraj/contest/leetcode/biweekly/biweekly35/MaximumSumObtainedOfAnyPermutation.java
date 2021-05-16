package biweekly.biweekly35;

import java.util.Arrays;

/**
 * Created on:  Sep 19, 2020
 * Questions: https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation
 */
public class MaximumSumObtainedOfAnyPermutation {
    public static void main(String[] args) {
        System.out.println(maxSumRangeQuery(new int[]{1, 2, 3, 4, 5}, new int[][]{{1, 3}, {0, 1}}) + " = 19");
        System.out.println(maxSumRangeQuery(new int[]{1, 2, 3, 4, 5, 6}, new int[][]{{0, 1}}) + " = 11");
        System.out.println(maxSumRangeQuery(new int[]{1, 2, 3, 4, 5, 10}, new int[][]{{0, 2}, {1, 3}, {1, 1}}) + " = 47");
    }

    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] occ = new int[nums.length];
        Arrays.sort(nums);
        for (int[] req : requests) {
            occ[req[0]]++;
            if (req[1] + 1 >= nums.length) continue;
            occ[req[1] + 1]--;
        }
        for (int i = 1; i < nums.length; i++) {
            occ[i] += occ[i - 1];
        }
        Arrays.sort(occ);
        int op = 0, mod = 1_000_000_007;
        for (int i = 0; i < nums.length; i++) {
            op = (op + occ[i] * nums[i]) % mod;
        }
        return op;
    }
}
