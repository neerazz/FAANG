package weekly.weekly200;

/**
 * Created on:  Aug 01, 2020
 * Questions: https://leetcode.com/problems/count-good-triplets/
 */
public class CountGoodTriplets {
    public static void main(String[] args) {

    }

    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int len = arr.length, op = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (isGood(arr, i, j, k, a, b, c)) {
                        op++;
                    }
                }
            }
        }
        return op;
    }

    private static boolean isGood(int[] arr, int i, int j, int k, int a, int b, int c) {
        return Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c;
    }
}
