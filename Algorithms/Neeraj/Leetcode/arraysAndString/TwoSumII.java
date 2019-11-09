package arraysAndString;

import java.util.Arrays;

/*
https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1153/
 */
public class TwoSumII {
    public static void main(String[] args) {
        System.out.println("Answer is: " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)) + " should be [1,2]");
        System.out.println("Answer is: " + Arrays.toString(twoSum(new int[]{5, 25, 75}, 100)) + " should be [2 ,3]");
        System.out.println("Answer is: " + Arrays.toString(twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200)) + " should be [3,6]");
        System.out.println("Answer is: " + Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)) + " should be [1,3]");
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            if (numbers[end] + numbers[start] > target) end--;
            else if (numbers[end] + numbers[start] < target) start++;
            else return new int[]{start + 1, end + 1};
        }
        return new int[0];
    }
}
