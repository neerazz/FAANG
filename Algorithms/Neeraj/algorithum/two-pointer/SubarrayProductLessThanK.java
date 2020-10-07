import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/RMV1GV1yPYz
 * Problem Statement #
 * Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 * Example 2:
 * <p>
 * Input: [8, 2, 6, 5], target=50
 * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 * Explanation: There are seven contiguous subarrays whose product is less than the target.
 */

public class SubarrayProductLessThanK {

    public static void main(final String[] args) {

    }

    public static List<List<Integer>> findSubarrays(final int[] arr, final int target) {
        final List<List<Integer>> subarrays = new ArrayList<>();
        int p1 = 0;
        long product = 1;
        for (int p2 = 0; p2 < arr.length; p2++) {
            if (arr[p2] < target) {
                subarrays.add(Arrays.asList(arr[p2]));
            }
            product *= arr[p2];
            while (p1 < p2 && product >= target) {
                product /= arr[p1++];
            }
            if (product < target && p1 != p2) {
                final List<Integer> list = new ArrayList<>();
                for (int i = p1; i <= p2; i++) list.add(arr[i]);
                subarrays.add(list);
            }
        }
        return subarrays;
    }
}
