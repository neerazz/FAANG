import java.util.Arrays;

/**
 * Created on:  Jul 13, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/B8qXVqVwDKY
 */

public class CycleSort {

    public static void main(String[] args) {
        sort(new int[]{3, 1, 5, 4, 2});
    }

    public static void sort(int[] nums) {
        System.out.println("Before: " + Arrays.toString(nums));
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1) {
                int next = nums[i];
                nums[i] = nums[next - 1];
                nums[next - 1] = next;
            }
        }
        System.out.println("After : " + Arrays.toString(nums));
    }
}
