/*
In a given integer array nums, there is always exactly one largest element.
Find whether the largest element in the array is at least twice as much as every other number in the array.
If it is, return the index of the largest element, otherwise return -1.

Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.

Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.

-- When finding second largest number - Use Integer.MIN_VALUE;
-- Check second even if no largest. 
//This is what you missed.
int largest = Integer.MIN_VALUE;
int second = Integer.MIN_VALUE;

*/
import java.util.Scanner;

public class LargestNumberTwice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println(dominantIndex(input));
        scanner.close();
    }

    private static int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                second = largest;
                largest = nums[i];
                index = i;
            }else if(nums[i]> second){
                second = nums[i];
            }
        }
        if (largest >= second * 2) {
            return index;
        } else {
            return -1;
        }
    }
}