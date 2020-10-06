import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 05, 2020
 * Questions:https://www.educative.io/courses/grokking-the-coding-interview/B6VypRxPolJ
 */

public class LongestSubarrayWithOnesAfterReplacement {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        System.out.println(findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }

    public static int findLength(int[] arr, int k) {
        int p1 = 0, max = 0, len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] != 1) {
                while (p1 < i && k == 0) {
                    k += arr[p1++] == 1 ? 0 : 1;
                }
                k--;
            }
            max = Math.max(max, i - p1 + 1);
        }
        return max;
    }
}
