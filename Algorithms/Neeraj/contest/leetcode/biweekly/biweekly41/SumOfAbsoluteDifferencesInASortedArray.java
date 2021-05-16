package biweekly.biweekly41;

/**
 * Created on:  Dec 12, 2020
 * Questions:
 */

public class SumOfAbsoluteDifferencesInASortedArray {

    public static void main(String[] args) {

    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int left = 0, right = 0;
        for (int num : nums) right += num;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            right -= cur;
            int fromLeft = nums[i] * i - left;
            int fromRight = right - (nums.length - i - 1) * nums[i];
            result[i] = fromLeft + fromRight;
            left += cur;
        }
        return result;
    }

    public static int[] getSumAbsoluteDifferences_naive(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                result[i] += Math.abs(nums[i] - nums[j]);
            }
        }
        return result;
    }
}
