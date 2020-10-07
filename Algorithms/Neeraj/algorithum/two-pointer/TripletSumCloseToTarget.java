import java.util.Arrays;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/3YlQz7PE7OA
 */

public class TripletSumCloseToTarget {

    public static void main(final String[] args) {

    }

    public static int searchTriplet(final int[] arr, final int target) {
        int closest = Integer.MAX_VALUE / 100;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1, end = arr.length - 1;
            while (start < end) {
                final int sum = arr[i] + arr[start] + arr[end];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(closest - target) > Math.abs(sum - target)) {
                    closest = sum;
                } else if (Math.abs(closest - target) == Math.abs(sum - target) && sum < target) {
                    closest = sum;
                }
                if (sum < target) start++;
                else end--;
            }
        }
        return closest;
    }
}
