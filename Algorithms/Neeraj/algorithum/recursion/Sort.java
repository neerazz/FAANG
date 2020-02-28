import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2944/
Given an array of integers nums, sort the array in ascending order.
Example 1:
Input: [5,2,3,1]
Output: [1,2,3,5]
Example 2:
Input: [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println("Answer is: \t[" + Arrays.toString(sortArray(new int[]{5, 2, 3, 1})) + "] \nShould be: \t[1,2,3,5]");
        System.out.println("Answer is: \t[" + Arrays.toString(sortArray(new int[]{5, 1, 1, 2, 0, 0})) + "] \nShould be: \t[0,0,1,1,2,5]");
    }

    public static int[] sortArray(int[] nums) {
        return mergeSortArray(nums);
    }

    private static int[] mergeSortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        int mid = nums.length / 2;
//        Split into two.
        int[] left = mergeSortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = mergeSortArray(Arrays.copyOfRange(nums, mid, nums.length));
//        Merge the two array.
        return mergeArray(left, right);
    }

    private static int[] mergeArray(int[] left, int[] right) {
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;
        int[] result = new int[left.length + right.length];
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
//        Append the remaining from left.
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
//        Append the remaining from right.
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        return result;
    }
}
