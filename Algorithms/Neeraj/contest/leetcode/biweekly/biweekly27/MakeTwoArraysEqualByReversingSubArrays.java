package biweekly.biweekly27;

/**
 * Created on:  May 30, 2020
 * Questions: https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */
public class MakeTwoArraysEqualByReversingSubArrays {
    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}) + " should be [true].");
    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ target[i] ^ arr[i];
        }
        return sum == 0;
    }
}
