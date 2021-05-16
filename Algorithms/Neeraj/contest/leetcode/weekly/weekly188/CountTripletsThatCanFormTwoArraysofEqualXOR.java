package weekly.weekly188;
/*
    Created on:  May 09, 2020
 */

/**
 * Questions: https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/submissions/
 */
public class CountTripletsThatCanFormTwoArraysofEqualXOR {
    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}) + " should be [4].");
        System.out.println(countTriplets(new int[]{1, 1, 1, 1, 1}) + " should be [10].");
        System.out.println(countTriplets(new int[]{2, 3}) + " should be [0].");
        System.out.println(countTriplets(new int[]{1, 3, 5, 7, 9}) + " should be [3].");
        System.out.println(countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}) + " should be [8].");
    }

    public static int countTriplets(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = arr[i];
//            Find all the points (i,k) so that the xor is zero.
            for (int j = i + 1; j < arr.length; j++) {
                xor ^= arr[j];
//                If the xor is zero, then (j-i) triplets there can be present.
                if (xor == 0) {
                    ans += j - i;
                }
            }
        }
        return ans;
    }
}
