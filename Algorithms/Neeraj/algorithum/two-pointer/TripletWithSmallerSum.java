import java.util.Arrays;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/mElknO5OKBO
 */

public class TripletWithSmallerSum {

    public static void main(final String[] args) {

    }

    public static int searchTriplets(final int[] arr, final int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1, end = arr.length - 1;
            while (start < end) {
                final int sum = arr[i] + arr[start] + arr[end];
                if (sum < target) {
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
