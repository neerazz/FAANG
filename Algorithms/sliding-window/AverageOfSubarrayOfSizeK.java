import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Jun 28, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/7D5NNZWQ8Wr
 */

public class AverageOfSubarrayOfSizeK {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findAverages(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2})));
    }

    public static double[] findAverages(int k, int[] arr) {
        List<Double> result = new ArrayList<>();
        double windowSum = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if (i - start + 1 == k) {
                result.add(windowSum / k);
                windowSum -= arr[start++];
            }
        }
        return result.stream().mapToDouble(val -> val).toArray();
    }
}
