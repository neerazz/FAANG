package practice;

import java.util.Arrays;

/**
 * Created on:  Aug 26, 2020
 * Questions:
 */
public class ContiguousSubarrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSubarrays(new int[]{3, 4, 1, 6, 2})));
        System.out.println(Arrays.toString(countSubarrays(new int[]{1, 2, 3, 2, 1})));
        System.out.println(Arrays.toString(countSubarrays(new int[]{1, 2, 6, 1, 3, 1})));
    }

    static int[] countSubarrays(int[] arr) {
        // Write your code here
        int len = arr.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = 1;
            // Expand left
            int left = i - 1, right = i + 1;
            while (left >= 0 && arr[left] < arr[i]) {
                cur++;
                left--;
            }
            // Expand towards the right
            while (right < len && arr[right] < arr[i]) {
                cur++;
                right++;
            }
            result[i] = cur;
        }
        return result;
    }
}
