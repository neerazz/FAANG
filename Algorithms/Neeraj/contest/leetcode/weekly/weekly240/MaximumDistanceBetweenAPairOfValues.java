package weekly.weekly240;

/**
 * Created on:  May 08, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-240/problems/maximum-distance-between-a-pair-of-values/
 */

public class MaximumDistanceBetweenAPairOfValues {

    public static void main(String[] args) {

    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int start = 0, end = nums2.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isPossible(nums1, nums2, mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        if (isPossible(nums1, nums2, end)) return end;
        return isPossible(nums1, nums2, start) ? start : 0;
    }

    private static boolean isPossible(int[] nums1, int[] nums2, int dist) {
        int l1 = nums1.length, l2 = nums2.length;
        for (int i = 0; i < l1 && i + dist < l2; i++) {
            if (nums1[i] <= nums2[i + dist]) return true;
        }
        return false;
    }
}
