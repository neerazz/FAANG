package biweekly27;

/**
 * Created on:  May 30, 2020
 * Questions: https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */
public class MakeTwoArraysEqualByReversingSubArrays {
    public static void main(String[] args) {

    }

    public boolean canBeEqual(int[] target, int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ target[i] ^ arr[i];
        }
        return sum == 0;
    }
}
