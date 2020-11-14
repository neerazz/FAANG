import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/gxk639mrr5r
 */

public class TripletSumToZero {

    public static void main(final String[] args) {

    }

    public static List<List<Integer>> searchTriplets(final int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int target = arr[i] * -1;
            int start = i + 1, end = arr.length - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == target) {
                    triplets.add(Arrays.asList(arr[i], arr[start++], arr[end--]));
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return triplets;
    }
}
