package ds.arraysAndString;

import java.util.Arrays;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println("Answer is: \t[" + Arrays.toString(nums) + "] \nShould be: \t[1,3,12,0,0]");
    }

    public static void moveZeroes(int[] nums) {
        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[position] = nums[i];
                position++;
            }
        }
        for (int i = position; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
