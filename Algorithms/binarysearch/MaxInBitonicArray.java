/**
 * Created on:  Jul 18, 2021
 * Ref : https://www.educative.io/courses/grokking-the-coding-interview/RMyRR6wZoYK
 * <p>
 * Find the maximum value in a given Bitonic array. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 3, 8, 12, 4, 2]
 * Output: 12
 * Explanation: The maximum number in the input bitonic array is '12'.
 * Example 2:
 * <p>
 * Input: [3, 8, 3, 1]
 * Output: 8
 * Example 3:
 * <p>
 * Input: [1, 3, 8, 12]
 * Output: 12
 * Example 4:
 * <p>
 * Input: [10, 9, 8]
 * Output: 10
 */
public class MaxInBitonicArray {
    public static int findMax(int[] arr) {
        int len = arr.length, start = 0, end = len - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid - 1 >= 0 && mid + 1 < len) {
                if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) return arr[mid];
                else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) start = mid + 1;
                else end = mid - 1;
            } else break;
        }
        return arr[start];
    }

    public static void main(String[] args) {
        System.out.println(findMax(new int[]{1, 3, 8, 12, 4, 2}));
        System.out.println(findMax(new int[]{3, 8, 3, 1}));
        System.out.println(findMax(new int[]{1, 3, 8, 12}));
        System.out.println(findMax(new int[]{10, 9, 8}));
    }
}
