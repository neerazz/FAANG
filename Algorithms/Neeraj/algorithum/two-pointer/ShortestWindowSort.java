/**
 * Created on:  Oct 06, 2020
 * Questions: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */

public class ShortestWindowSort {

    public static void main(String[] args) {

    }

    public static int sort(int[] arr) {
        int len = arr.length;
        int left = 0, right = len - 1;
        // Find the left point that is ussorted.
        while (left < len - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == len - 1) return 0;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        if (left == 0 && right == len - 1) return len;
        // Validate the left index values is less than right val;
        int l1 = left, r1 = right;
        for (int i = left; i <= right; i++) {
            int cur = arr[i];
            while (l1 >= 0 && arr[l1] > cur) l1--;
            while (r1 < len && cur > arr[r1]) r1++;
        }
        return r1 - l1 - 1;
    }
}
