package weekly.weekly192;

import java.util.Arrays;

/**
 * Created on:  Jun 06, 2020
 * Questions: https://leetcode.com/problems/the-k-strongest-values-in-an-array
 */
public class TheKStrongestValuesInAnArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getStrongest(new int[]{1, 2, 3, 4, 5}, 2)) + " should be [5,1].");
        System.out.println(Arrays.toString(getStrongest(new int[]{1, 1, 3, 5, 5}, 2)) + " should be [5,5].");
        System.out.println(Arrays.toString(getStrongest(new int[]{6, 7, 11, 7, 6, 8}, 5)) + " should be [11,8,6,6,7].");
    }

    public static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int len = arr.length, mIdx = (len - 1) / 2, median = arr[mIdx];
        int[][] mArray = new int[len][2];
        int index = 0;
        for (int val : arr) {
            mArray[index++] = new int[]{val, Math.abs(val - median)};
        }
        Arrays.sort(mArray, (v1, v2) -> v1[1] == v2[1] ? v2[0] - v1[0] : v2[1] - v1[1]);
        int[] op = new int[k];
        for (int i = 0; i < k; i++) {
            op[i] = mArray[i][0];
        }
        return op;
    }
}
