package arraysAndString;

import java.util.Arrays;
import java.util.Scanner;

/*
Problem: https://leetcode.com/problems/two-sum/
Sample: (4 2 7 11 15 9)
Given 4 numbers
nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
Input 2: 5 -1 -2 -3 -4 -5 -8
 */
class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumbers = scanner.nextInt();
        int[] nums = new int[totalNumbers];
        for (int i = 0; i < totalNumbers; i++) {
            nums[i] = Integer.parseInt(scanner.next());
        }
        int target = Integer.parseInt(scanner.next());
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (currentValue + nums[j] == target) {
                    indexes[0] = i;
                    indexes[1] = j;
                    return indexes;
                }
            }
        }
        return indexes;
    }
}