package grokking.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 * <p>
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 *
 * <p>
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 *
 * <p>
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
 * or [1, 1, 6].
 */

public class SmallestSubarrayWithAGivenSum {

    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 5, 2, 3, 2};
        int s = 7;
        System.out.println(minSubArrayLen(input, s));

        input = new int[]{2, 1, 5, 2, 8};
        System.out.println(minSubArrayLen(input, 7));

        input = new int[]{3, 4, 1, 1, 6};
        System.out.println(minSubArrayLen(input, 8));
    }


    public static int minSubArrayLen(int[] arr, int s) {
        int start = 0, end = 0, sol = Integer.MAX_VALUE, sum = 0;
        while (end < arr.length) {
            sum += arr[end++];
            while (sum >= s) {
                sol = Math.min(sol, end - start);
                sum -= arr[start++];
            }
        }
        return sol != Integer.MAX_VALUE ? sol : 0;
    }

    public static int findMinSubArraySolution(int[] arr, int S) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // shrink the window as small as possible until the 'windowSum' is smaller than 'S'
            while (windowSum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


}
