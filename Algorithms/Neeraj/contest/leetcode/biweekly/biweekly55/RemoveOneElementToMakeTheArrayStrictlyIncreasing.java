package biweekly.biweekly55;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-55/problems/remove-one-element-to-make-the-array-strictly-increasing/
 */

public class RemoveOneElementToMakeTheArrayStrictlyIncreasing {

    public static void main(String[] args) {

    }

    public static boolean canBeIncreasing(int[] nums) {
        int count = 0, len = nums.length;
        if (isIncreasing(nums)) return true;
        for (int i = 0; i < len; i++) {
            int[] temp = new int[len - 1];
            int idx = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                temp[idx++] = nums[j];
            }
            if (isIncreasing(temp)) return true;
        }
        return false;
    }

    private static boolean isIncreasing(int[] nums) {
        int pre = -1;
        for (int cur : nums) {
            if (pre != -1 && pre >= cur) {
                return false;
            }
            pre = cur;
        }
        return true;
    }
}
