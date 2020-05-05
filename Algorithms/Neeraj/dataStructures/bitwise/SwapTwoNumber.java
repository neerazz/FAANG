/*
    Created on:  May 04, 2020
 */

import java.util.Arrays;

/**
 * Questions: https://www.geeksforgeeks.org/swap-two-numbers-without-using-temporary-variable/
 */
public class SwapTwoNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(swap(5, 3)));
    }

    private static int[] swap(int a, int b) {
        return new int[]{(a ^b)^a, (a^b) ^ b};
    }
}
