/*
    Created on:  May 12, 2020
 */

/**
 * Questions: https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInASortedArray {
    public static void main(String[] args) {

    }

    //    Time: LogN, space: 1
    public static int singleNonDuplicate_optimal(int[] nums) {
        int start = 0, end = nums.length - 1;
//        Find which sid edo you have the invalid version.
        while (start < end) {
            int mid = start + (end - start) / 2;
//            Since it is a sorted array, and each element is twice in the array. Mid should always point to even number.
            if (mid % 2 == 1) mid--;
//            If the mid and mid+1 element value is same. Then the order so far is correct, move towards right.
            if (nums[mid] == nums[mid + 1]) start = mid + 2;
            else end = mid;
        }
        return start == end ? nums[start] : -1;
    }

    //    Time: N, Space: 1
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length < 2) return nums.length;
        int p1 = 0, p2 = 1, len = nums.length;
        while (p1 < len && p2 < len) {
            if (nums[p1] != nums[p2]) {
                return nums[p1];
            } else {
                p1 += 2;
                p2 += 2;
            }
        }
        if (p1 < len) return nums[p1];
        return -1;
    }
}
