/**
 * Created on:  Jul 23, 2021
 * Ref : https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {

    }

    public static int maxScore(int[] nums, int k) {
        int sum = 0, max = 0, len = nums.length;
        for (int i = 0; i < len && i < k; i++) {
            sum += nums[i];
        }
        if (len == k) return sum;
        max = sum;
        for (int i = 0; i < len && i < k; i++) {
            sum -= nums[k - i - 1];
            sum += nums[len - i - 1];
            max = Math.max(max, sum);
        }
        return max;
    }
}
