/*
    Created on:  May 04, 2020
 */

/**
 * Questions: https://www.geeksforgeeks.org/find-the-missing-number/
 */
public class FindTheMissingNumber {
    public static void main(String[] args) {
        System.out.println(getMissingNo(new int[]{1, 2, 3, 5}));
        System.out.println(getMissingNo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10}));
    }

    static int getMissingNo(int[] nums) {
        int a = 1, b = nums[0], len = nums.length;
        for (int i = 1; i < len; i++) {
            a ^= i + 1;
            b ^= nums[i];
        }
        return (a ^ len + 1) ^ b;
    }
}
