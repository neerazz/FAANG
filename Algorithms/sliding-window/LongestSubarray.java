/**
 * Created on:  Oct 04, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/B6VypRxPolJ
 */

public class LongestSubarray {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
    }

    public static int findLength(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int start = 0, len = arr.length;
        for (int end = 0; end < len; end++) {
            if (arr[end] != 1) {
                while (start < end && k == 0) {
                    k += arr[start++] == 1 ? 0 : 1;
                }
                k--;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
