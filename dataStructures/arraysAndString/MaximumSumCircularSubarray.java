/**
 * Created on:  May 16, 2020
 * Questions:
 */
public class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}) + " should be [3]");
        System.out.println(maxSubarraySumCircular(new int[]{5, -3, 5}) + " should be [10]");
        System.out.println(maxSubarraySumCircular(new int[]{3, -1, 2, -1}) + " should be [4]");
        System.out.println(maxSubarraySumCircular(new int[]{3, -2, 2, -3}) + " should be [3]");
        System.out.println(maxSubarraySumCircular(new int[]{-2, -3, -1}) + " should be [-1]");
    }

    // https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3330/discuss/178422/One-Pass
    public static int maxSubarraySumCircular(int[] A) {
        int curMax = A[0], curMin = curMax, max = curMax, min = curMax, total = curMax;
        for (int i = 1; i < A.length; i++) {
            curMax = Math.max(A[i], curMax + A[i]);
            max = Math.max(max, curMax);
            curMin = Math.min(A[i], curMin + A[i]);
            min = Math.min(min, curMin);
            total += A[i];
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}
