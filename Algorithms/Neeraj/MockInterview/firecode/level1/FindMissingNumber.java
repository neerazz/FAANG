package firecode.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an Array containing 9 numbers ranging from 1 to 10, write a method to find the missing number. Assume you have 9 numbers between 1 to 10 and only one number is missing.
findMissingNumber({1,2,4,5,6,7,8,9,10}) --> 3
 */
public class FindMissingNumber {
    public static void main(String[] args) {
        System.out.println(findMissingNumber(new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10}) + " should be [3].");
        System.out.println(findMissingNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10}) + " should be [9].");
        System.out.println(findMissingNumber(new int[]{6, 7, 8, 9, 10, 1, 2, 4, 5}) + " should be [3].");
        System.out.println(findMissingNumber(new int[]{4, 5, 6, 7, 8, 10, 1, 2, 3}) + " should be [9].");
    }

    public static int findMissingNumber(int[] arr) {
        List<Integer> number = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        for (int i = 0; i < arr.length; i++) {
            number.remove((Integer) arr[i]);
        }
        return number.get(0);
    }
}
