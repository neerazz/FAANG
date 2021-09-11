package grokking.slidingwindow;

import util.Util;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 * <p>
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * <p>
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */

public class MaximumSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(findMaxSumSubArray(arr, k));
        test();
    }

    public static void test() {
        int run = 100;
        for (int i = 0; i < run; i++) {
            int[] input = Util.generateRandomArray(100);
            int k = Math.abs(Util.generateRandomNumber(input.length));
            if (k == 0) continue;

            int expected = findMaxSumSubArray(input, k);
            int actual = findMaxSumSubArrayMine(input, k);

            if (expected != actual) {
                System.out.println("--------- Failed for -------");
                System.out.println("K is " + k);
                Util.print(input, "Input");
                System.out.println(expected + "Expected");
                System.out.println(actual + "Actual");
            }
        }
    }

    //[2, 1, 5, 1, 3, 2], k=3
    //Output: 9
    public static int findMaxSumSubArrayMine(int[] arr, int k) {
        int start = 0;
        int end = k - 1, sum = 0;
        int sol = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        sol = sum;
        while (end < arr.length - 1) {
            sum -= arr[start];
            start++;
            end++;
            sum += arr[end];
            sol = Math.max(sol, sum);
        }
        return sol;
    }

    public static int findMaxSumSubArray(int[] arr, int k) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }
}
