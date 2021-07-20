package grokking.slidingwindow;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 * <p>
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 * <p>
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
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
        System.out.println(findMinSubArray(input, s));

        input = new int[]{2, 1, 5, 2, 8};
        System.out.println(findMinSubArray(input, 7));

        input = new int[]{3, 4, 1, 1, 6};
        System.out.println(findMinSubArray(input, 8));
    }


    public static int findMinSubArray(int[] arr, int s) {
        return -1;
    }
    //Input: [2, 1, 5, 2, 3, 2], S=7
    //start end sol sum
    //0     0   ++  2
    //0     1       3
    //0     2       8
    //1     2   3   6
    //1     3   3   8
    //2     4   3   7
    //

}
