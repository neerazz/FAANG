import java.util.PriorityQueue;

/**
 * Created on:  Mar 11, 2021
 * Questions: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 */

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public static void main(String[] args) {

        System.out.println(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
    }

    public static int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> increasing = new PriorityQueue<>(), decreasing = new PriorityQueue<>((v1, v2) -> Integer.compare(v2, v1));
        int result = 1, p1 = 0;
        for (int cur : nums) {
            if (increasing.isEmpty()) {
                increasing.add(cur);
                decreasing.add(cur);
            } else {
                increasing.add(cur);
                decreasing.add(cur);
                int min = increasing.peek(), max = decreasing.peek();
                while (Math.abs(min - max) > limit) {
                    int pre = nums[p1++];
                    increasing.remove(pre);
                    decreasing.remove(pre);
                    min = increasing.peek();
                    max = decreasing.peek();
                }
                result = Math.max(result, increasing.size());
            }
        }
        return result;
    }
}
