import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Given nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
It doesn't matter what you leave beyond the returned length.

Example 2:
Given nums = [0,0,1,1,1,2,2,3,3,4],
Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
It doesn't matter what values are set beyond the returned length.

 */

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print(removeDuplicatesElegant(nums));
    }

    private static int removeDuplicatesElegant(int[] nums) {
        int max = Integer.MIN_VALUE;
        if (nums == null || nums.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> cache = new HashMap<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cache.get(nums[i]) == null) {
                nums[j++] = nums[i];
                cache.put(nums[i], 1);
            }
        }
        return j;
    }
}
