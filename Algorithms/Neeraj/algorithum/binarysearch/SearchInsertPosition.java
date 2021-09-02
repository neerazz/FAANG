import java.util.Arrays;

/**
 * Created on:  Jun 10, 2020
 * Questions: https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println("************************** Method 1 ****************************");
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5) + " should be [2].");
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2) + " should be [1].");
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7) + " should be [4].");
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0) + " should be [0].");

        System.out.println("************************** Method 2 ****************************");
        System.out.println(searchInsert_optimal(new int[]{1, 3, 5, 6}, 5) + " should be [2].");
        System.out.println(searchInsert_optimal(new int[]{1, 3, 5, 6}, 2) + " should be [1].");
        System.out.println(searchInsert_optimal(new int[]{1, 3, 5, 6}, 7) + " should be [4].");
        System.out.println(searchInsert_optimal(new int[]{1, 3, 5, 6}, 0) + " should be [0].");

        System.out.println("************************** Method 3 ****************************");
        System.out.println(searchInsert_rev1(new int[]{1, 3, 5, 6}, 5) + " should be [2].");
        System.out.println(searchInsert_rev1(new int[]{1, 3, 5, 6}, 2) + " should be [1].");
        System.out.println(searchInsert_rev1(new int[]{1, 3, 5, 6}, 7) + " should be [4].");
        System.out.println(searchInsert_rev1(new int[]{1, 3, 5, 6}, 0) + " should be [0].");
    }

    public static int searchInsert_rev1(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static int searchInsert_optimal(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid + 1;
            else end = mid;
        }
        return start == end ? start : -1;
    }

    public static int searchInsert(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if (idx < 0) {
            return Math.abs(idx) - 1;
        }
        return idx;
    }
}
