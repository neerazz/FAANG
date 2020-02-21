package ds.arraysAndString;

import java.util.Arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println("Answer is:" + Arrays.toString(nums) + " should be [5,6,7,1,2,3,4]");
    }

//    Self solved. Time: O(N), space: O(K)
    public static void rotate_elegent(int[] nums, int k) {
        int size = nums.length, noOfRotations = k % size;
        int[] newarray = new int[noOfRotations];
        System.arraycopy(nums,size-noOfRotations,newarray,0,noOfRotations);
        int start = size-noOfRotations-1;
        for (int i = size-1; i >= noOfRotations; i--) {
            nums[i] = nums[start--];
        }
        System.arraycopy(newarray, 0, nums, 0, noOfRotations);
    }

    //    Naive Approach. Time complexity: O(nk)
    public static void rotate(int[] nums, int k) {
        int size = nums.length;
        for (int i = 0; i < k; i++) {
            int end = nums[size - 1];
            int index = size - 1;
            while (index > 0) {
                nums[index] = nums[index - 1];
                index--;
            }
            nums[0] = end;
        }
    }
}
