package problems.binarysearch;

import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/binary-search/135/template-iii/944/
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n). If the target is not found in the array, return [-1, -1].
Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
public class SearchForARange {

    public static void main(String[] args) {
        System.out.println("Answer is :" + Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)) + " should be [3,4].");
        System.out.println("Answer is :" + Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 8, 10}, 7)) + " should be [1,2].");
        System.out.println("Answer is :" + Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)) + " should be [-1,-1].");
        System.out.println("Answer is :" + Arrays.toString(searchRange(new int[]{1, 2, 3}, 2)) + " should be [1,1].");
        System.out.println("Answer is :" + Arrays.toString(searchRange(new int[]{1, 1, 2}, 1)) + " should be [0,1].");
        System.out.println("Answer is :" + Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3)) + " should be [2,5].");
        System.out.println("Answer is :" + Arrays.toString(searchRange(new int[]{1}, 1)) + " should be [0,0].");
        System.out.println("Answer is :" + Arrays.toString(searchRange(new int[]{2, 2}, 2)) + " should be [0,1].");
    }

    private static int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

        return targetRange;
    }

    public static int[] searchRange_wrong(int[] nums, int target) {
        int[] output = {-1, -1};
        int leftIndex = getIndexValue(nums, target, true);

        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return output;
        }
        int rightIndex = getIndexValue(nums, target, false);
        output[0] = leftIndex;
        output[1] = rightIndex == 0 || rightIndex < nums.length - 1 ? rightIndex : rightIndex - 1;
        return output;
    }

    private static int getIndexValue(int[] nums, int target, boolean leftIndex) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (leftIndex && target == nums[mid])) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static void searchRangeHelper(int[] nums, int target, int start, int end, List<Integer> output) {
        if (start > end) return;
        int mid = start + (end - start) / 2;
        if (nums[start] == target) {
            output.add(start);
//            start++;
        }
        if (nums[mid] == target) output.add(mid);
        if (nums[end] == target) {
            output.add(end);
//            end--;
        }
        if (mid >= target) searchRangeHelper(nums, target, start, mid, output);
        else searchRangeHelper(nums, target, mid, end, output);
    }
}
