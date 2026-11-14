/**
 * Created on:  Jun 30, 2021
 * Ref: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/longest-subarray-with-ones-after-replacement-hard
 */

public class ReplacingOnes {

    public static void main(String[] args) {

    }

    public static int findLength(int[] arr, int k) {
        int[] counts = {0, 0};
        int len = arr.length, i = 0, j = 0, max = 0;
        while (j < len) {
            counts[arr[j]]++;
            while (i <= j && counts[0] > k) {
                counts[arr[i++]]--;
            }
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}
