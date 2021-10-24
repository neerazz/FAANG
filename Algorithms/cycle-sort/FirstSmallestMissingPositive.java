/**
 * Created on:  Jul 13, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/3jEXWgB5ZmM
 */

public class FirstSmallestMissingPositive {

    public static void main(String[] args) {

    }

    public static int findNumber(int[] nums) {
        int min = Integer.MAX_VALUE, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) nums[i] = len + 1;
            if (nums[i] > len) nums[i] = len + 1;
            min = Math.min(min, nums[i]);
        }
        if (min > 1) return 1;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1 && nums[i] != len + 1) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
}
