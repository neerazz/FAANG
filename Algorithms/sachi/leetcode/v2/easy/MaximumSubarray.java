package leetcode.v2.easy;
public class MaximumSubarray {

    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cMax = 0;
            for (int j = i; j < nums.length; j++) {
                cMax += nums[j];
                max = Math.max(cMax, max);
            }
        }
        return max;
    }
}
