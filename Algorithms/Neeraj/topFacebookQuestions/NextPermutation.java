import java.util.Arrays;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public static void main(String[] args) {

    }

    /**
     * Observe the pattern. To get the next permutation, you have to find an element that have it greater right side value.
     * From that greater value on the right that can be swapped with the current value and rest of them is sorted.
     * <p>
     *
     * @implSpec https://www.youtube.com/watch?v=quAS1iydq7U&feature=emb_title
     */
    public static void nextPermutation(int[] nums) {
        int p1 = nums.length - 2;
//        Traverse from right to left and find the point where the left side value is greater than right side value.
        while (p1 >= 0 && nums[p1 + 1] <= nums[p1]) {
            p1--;
        }
        if (p1 >= 0) {
//            Traverse towards the right and find the greater element than the strictly decreasing number.
            int p2 = nums.length - 1;
            while (p2 >= 0 && nums[p2] <= nums[p1]) {
                p2--;
            }
            swap(nums, p1, p2);
            reverse(nums, p1 + 1);
        }
        reverse(nums, 0);
    }

    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
