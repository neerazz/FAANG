package weekly.weekly193;

/**
 * Created on:  Jun 13, 2020
 * Questions: https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSumOf1dArray {
    public static void main(String[] args) {

    }

    public static int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
