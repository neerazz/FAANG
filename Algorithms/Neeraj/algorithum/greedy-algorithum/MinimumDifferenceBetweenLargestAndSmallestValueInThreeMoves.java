import java.util.Arrays;

/**
 * Created on:  Jul 23, 2021
 * Ref : https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {

    }

    public static int minDifference(int[] nums) {
        Arrays.sort(nums);
        int min = Math.abs(nums[0] - nums[nums.length - 1]), len = nums.length;
        for (int i = 1; i <= Math.min(len, 3); i++) {
            int cur = minAfterNSteps(nums, i);
            min = Math.min(min, cur);
        }
        return min;
    }

    private static int minAfterNSteps(int[] nums, int moves) {
        int min = Integer.MAX_VALUE, len = nums.length;
        for (int i = 0; i <= moves && moves - i < len; i++) {
            int right = nums[len - 1 - moves + i];
            min = Math.min(min, Math.abs(nums[i] - right));
        }
        return min;
    }
}
