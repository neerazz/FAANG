/*
https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println("*****************************************************");
        System.out.println("Answer is: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) + " should be [4].");
        System.out.println("Answer is: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) + " should be [-1].");
        System.out.println("Answer is: " + search(new int[]{5, 6, 1, 2, 3, 4}, 1) + " should be [2].");
        System.out.println("Answer is: " + search(new int[]{}, 1) + " should be [-1].");
        System.out.println("Answer is: " + search(new int[]{5, 1, 2, 3, 4}, 1) + " should be [1].");
        System.out.println("Answer is: " + search(new int[]{5, 1, 2, 3, 4}, 1) + " should be [1].");
        System.out.println("Answer is: " + search(new int[]{1, 3}, 2) + " should be [-1].");
        System.out.println("*****************************************************");
        System.out.println("Answer is: " + search_rev1(new int[]{4, 5, 6, 7, 0, 1, 2}, 0) + " should be [4].");
        System.out.println("Answer is: " + search_rev1(new int[]{4, 5, 6, 7, 0, 1, 2}, 3) + " should be [-1].");
        System.out.println("Answer is: " + search_rev1(new int[]{5, 6, 1, 2, 3, 4}, 1) + " should be [2].");
        System.out.println("Answer is: " + search_rev1(new int[]{}, 1) + " should be [-1].");
        System.out.println("Answer is: " + search_rev1(new int[]{5, 1, 2, 3, 4}, 1) + " should be [1].");
        System.out.println("Answer is: " + search_rev1(new int[]{5, 1, 2, 3, 4}, 1) + " should be [1].");
        System.out.println("Answer is: " + search_rev1(new int[]{1, 3}, 2) + " should be [-1].");
    }

    public static int search_rev1(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sv = nums[start], mv = nums[mid], ev = nums[end];
//            System.out.println("start =" + start + " mid=" + mid + " end="+ end);
            if (mv == target) return mid;
            if (sv == target) return start;
            if (ev == target) return end;
            if (sv < mv) {
                if (target > sv && target < mv) end = mid;
                else start = mid + 1;
            } else {
                if (target < ev && target > mv) start = mid + 1;
                else end = mid;
            }
        }
        if (nums[start] == target) return start;
        return -1;
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
