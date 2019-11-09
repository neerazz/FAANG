/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they 
add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.

Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

*/

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        Arrays.stream(twoSum(input, target)).forEach(e -> System.out.print(e + " "));
        scanner.close();
    }

    //Sol - Have two pointers - i,j
    //Start from start and end. i = start, j = end
    private static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return numbers;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{++i, ++j};
            } else if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
        }
        return numbers;
    }
}