package problems.binarysearch;

/*
https://leetcode.com/explore/learn/card/binary-search/138/background/1038/
 */
public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Answer is:" + search(new int[]{-1, 0, 3, 5, 9, 12}, 9) + " should be [4].");
        System.out.println("Answer is:" + search(new int[]{-1, 0, 3, 5, 9, 12}, 2) + " should be [-1].");
    }

    public static int search(int[] nums, int target) {
        return binarySearchHelper(nums, target, 0, nums.length - 1);
    }

    private static int binarySearchHelper(int[] nums, int target, int start, int end) {
        if (start > end || start < 0 || end >= nums.length) return -1;
        int mid = start + ((end - start) / 2);
        if (nums[mid] > target) {
            return binarySearchHelper(nums, target, start, mid - 1);
        } else if (nums[mid] < target) {
            return binarySearchHelper(nums, target, mid + 1, end);
        } else {
            return mid;
        }
    }
}
