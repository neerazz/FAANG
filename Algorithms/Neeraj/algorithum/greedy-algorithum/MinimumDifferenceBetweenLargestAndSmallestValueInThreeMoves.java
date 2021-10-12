import java.util.Arrays;

/**
 * Created on:  Jul 23, 2021
 * Ref : https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{5, 3, 2, 4}) + " = 0");
    }

    public static int minDifference(int[] nums) {
        Arrays.sort(nums);
        int min = Math.abs(nums[0] - nums[nums.length - 1]), len = nums.length;
        if (len <= 3) return 0;
        for (int i = 1; i <= 3; i++) {
            int cur = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                cur = Math.min(cur, nums[len - 1 - i + j] - nums[j]);
            }
            min = Math.min(min, cur);
        }
        return min;
    }
}
