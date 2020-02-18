package ds.binarysearch;

/*
https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println("Answer is: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) + " should be [4].");
        System.out.println("Answer is: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) + " should be [-1].");
        System.out.println("Answer is: " + search(new int[]{5, 6, 1, 2, 3, 4}, 1) + " should be [2].");
        System.out.println("Answer is: " + search(new int[]{}, 1) + " should be [-1].");
        System.out.println("Answer is: " + search(new int[]{5, 1, 2, 3, 4}, 1) + " should be [1].");
        System.out.println("Answer is: " + search(new int[]{5, 1, 2, 3, 4}, 1) + " should be [1].");
    }

    public static int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    private static int searchHelper(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        int midValue = nums[mid];
        int startValue = nums[start];
        int endValue = nums[end];
        if (midValue == target) return mid;
        if (startValue == target) return start;
        if (endValue == target) return end;

        if (startValue < midValue) {
            if (startValue < target && target < midValue)
                return searchHelper(nums, target, start, mid - 1);
            return searchHelper(nums, target, mid + 1, end);
        } else {
            if (target < endValue && target > midValue)
                return searchHelper(nums, target, mid + 1, end);
            return searchHelper(nums, target, start, mid - 1);
        }
    }
}
