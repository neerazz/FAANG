package biweekly.biweekly29;

/**
 * Created on:  Jun 27, 2020
 * Questions: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
 */
public class LongestSubarrayOf1SAfterDeletingOneElement {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 1, 0, 1}));
    }

    public static int longestSubarray(int[] nums) {
        int op = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                op = Math.max(op, expandOnBothSides(nums, i));
            }
        }
        return op == Integer.MIN_VALUE ? nums.length - 1 : op;
    }

    private static int expandOnBothSides(int[] nums, int idx) {
        int left = idx - 1, right = idx + 1;
        while (left >= 0 && nums[left] == 1) left--;
        while (right < nums.length && nums[right] == 1) right++;
        return right - left - 1 - 1;
    }
}
