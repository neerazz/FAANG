package binarysearch;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println("Answer is:" + findMin(new int[]{3, 4, 5, 1, 2}) + " should be [1].");
        System.out.println("Answer is:" + findMin(new int[]{4, 5, 6, 7, 0, 1, 2}) + " should be [0].");
        System.out.println("Answer is:" + findMin(new int[]{-2}) + " should be [-2].");
        System.out.println("Answer is:" + findMin(new int[]{5, 1, 2, 3, 4}) + " should be [1].");
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        return findMinHelper(nums, 0, nums.length - 1);
    }

    private static int findMinHelper(int[] nums, int start, int end) {
        if (start >= end) return -1;
        if (start + 1 == end) {
            return Math.min(nums[start], nums[end]);
        }
        int mid = start + (end - start) / 2;
        if (nums[start] < nums[mid]) {
            if (nums[mid] < nums[end])
                return findMinHelper(nums, start, mid);
            return findMinHelper(nums, mid, end);
        } else {
            if (nums[mid] > nums[end])
                return findMinHelper(nums, mid, end);
            return findMinHelper(nums, start, mid);
        }
    }
}
