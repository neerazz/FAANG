/*
    Created on:  May 09, 2020
 */

/**
 * Questions: https://www.algoexpert.io/questions/Longest%20Peak
 * <p>
 * Write a function that takes in an array of integers and returns the length of the longest peak in the array.
 * A peak is defined as adjacent integers in the array that are strictly increasing until they reach a tip (the highest value in the peak), at which point they become strictly decreasing.
 * At least three integers are required to form a peak.
 * For example, the integers 1, 4, 10, 2 form a peak, but the integers 4, 0, 10 don't and neither do the integers 1, 2, 2, 0.
 * Similarly, the integers 1, 2, 3 don't form a peak because there aren't any strictly decreasing integers after the 3.
 * <p>
 * Sample Input
 * array = [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
 * Sample Output
 * 6 // 0, 10, 6, 5, -1, -3
 */
public class LongestPeak {
    public static void main(String[] args) {
        System.out.println(longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}) + " should be [6].");
        System.out.println(longestPeak(new int[]{1, 3, 2}) + " should be [3].");
        System.out.println(longestPeak(new int[]{1, 2, 3, 4, 5, 1}) + " should be [6].");
    }

    public static int longestPeak(int[] array) {
        int max = 0;
        if (array.length < 3) return max;
        for (int i = 1; i < array.length - 1; i++) {
            if (canFormPeek(i, array)) {
                max = Math.max(max, expand(i, array));
            }
        }
        return max;
    }

    private static int expand(int center, int[] array) {
        int len = array.length, left = center - 1, right = center + 1;
//        Keep reducing the left till it is decreasing from the center.
        while (left - 1 >= 0 && array[left - 1] < array[left]) {
            left--;
        }
//        Keep moving the right counter till it increasing.
        while (right + 1 < len && array[right] > array[right + 1]) {
            right++;
        }
//        Adding one because left and right are moved one more than satisfied value.
        return right - left + 1;
    }

    private static boolean canFormPeek(int index, int[] array) {
        return index - 1 >= 0 && index + 1 < array.length && array[index - 1] < array[index] && array[index] > array[index + 1];
    }
}
