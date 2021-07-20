package grokking.slidingwindow;

import util.Util;
import java.util.Arrays;



public class AverageOfContigousArrays {

    public static void main(String[] args) {
        int[] input = new int[]{3, 1, 8, 9, 0, 2};
        int k = 1;

        //double[] expected = findAveragesSolution(input, k);
        //double[] actual = findAverage(input, k);
        //Util.print(actual);

        test();

    }

    public static void test() {
        int run = 100;
        for (int i = 0; i < run; i++) {
            int[] input = Util.generateRandomArray(6);
            int k = Math.abs(Util.generateRandomNumber(input.length));
            if (k == 0) continue;

            double[] expected = findAveragesSolution(input, k);
            double[] actual = findAverage(input, k);

            if (!Arrays.equals(expected, actual)) {
                System.out.println("--------- Failed for -------");
                System.out.println("K is " + k);
                Util.print(input, "Input");
                Util.print(expected, "Expected");
                Util.print(actual, "Actual");
            }
        }
    }


    public static double[] findAveragesSolution(int[] arr, int K) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= K - 1) {
                result[windowStart] = windowSum / K; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return result;
    }


    private static double[] findAverage(int[] arr, int k) {
        if (arr.length == 0 || k > arr.length) return new double[]{};
        double[] sol = new double[arr.length - k + 1];
        int start = 0, end = k - 1, index = 0;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        sol[index++] = sum / k;
        while (end < arr.length - 1) {
            sum -= arr[start];
            start++;
            end++;
            sum += arr[end];
            sol[index++] = sum / k;
        }
        return sol;
    }
    // 0  1  2  3   4  5  6  7  8
    //[1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
    //start end sum index   sol
    //0     4   11  0       2.2
    //1     5   14  1       2.8

}
