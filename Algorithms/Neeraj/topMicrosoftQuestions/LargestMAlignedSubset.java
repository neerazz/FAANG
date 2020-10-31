import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 30, 2020
 * Questions: https://leetcode.com/discuss/interview-question/525894/Microsoft-or-OA-2020-or-m-aligned-subset
 */

public class LargestMAlignedSubset {

    public static void main(String[] args) {
        System.out.println(getLargestMAlignedSubset(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3));
        System.out.println(getLargestMAlignedSubset(new int[]{7, 2, 4, 8, 6}, 2));

        System.out.println(getLargestMAlignedSubset_dp(new int[]{-3, -2, 1, 0, 8, 7, 1}, 3));
        System.out.println(getLargestMAlignedSubset_dp(new int[]{7, 2, 4, 8, 6}, 2));
    }

    private static int getLargestMAlignedSubset(int[] nums, int m) {
        int max = 0, len = nums.length;
        int[] counts = new int[len];
        for (int num : nums) {
//            Get the remainder of each number.
            int rem = num < 0 ? (num % m + m) : num % m;
            counts[rem]++;
            max = Math.max(max, counts[rem]);
        }
//        As we are looking for pairs if the count is less than 2, then there is not valid pair.
        return max < 2 ? 0 : max;
    }

    private static int getLargestMAlignedSubset_dp(int[] nums, int m) {
        int len = nums.length, max = 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (isDivisable(nums, j, i, m)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static boolean isDivisable(int[] nums, int j, int i, int m) {
        return nums[i] - nums[j] != 0 && (nums[i] - nums[j]) % m == 0;
    }
}
