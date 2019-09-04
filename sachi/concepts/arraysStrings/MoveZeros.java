/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        moveZeroes(nums);
        Arrays.stream(nums).forEach(e -> System.out.print(e + " "));
        scanner.close();

    }

    private static void moveZeroes(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[counter++] = nums[i];
            }
        }
        for (int i = counter; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
