/**
 * Created on:  Jun 21, 2021
 * Ref: https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 */

public class PartitionArrayIntoDisjointIntervals {

    public static void main(String[] args) {

    }

    public static int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] maxLeft = new int[len], minRight = new int[len];
        int max = Integer.MIN_VALUE, min = nums[len - 1];
        for (int i = 0; i < len; i++) {
            maxLeft[i] = max = Math.max(max, nums[i]);
        }
        int leftSize = -1;
        for (int i = len - 2; i >= 0; i--) {
            int left = maxLeft[i];
//            left = max item on left.
//            min = min item on right.
            if (left <= min) leftSize = i + 1;
            min = Math.min(min, nums[i]);
        }
        return leftSize;
    }
}
