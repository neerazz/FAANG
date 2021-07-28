package algo.grokking.twopointer;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 * <p>
 * Example 1:
 * <p>
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * Example 2:
 * <p>
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * Example 3:
 * <p>
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */

public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        int[] input = new int[]{-2, 0, 1, 2};
        System.out.println(searchTriplet(input, 2));
        System.out.println(threeSumClosest(input, 2));

        input = new int[]{-3, -1, 1, 2};
        System.out.println(searchTriplet(input, 1));
        System.out.println(threeSumClosest(input, 1));

        input = new int[]{1, 0, 1, 1};
        System.out.println(searchTriplet(input, 3));
        System.out.println(threeSumClosest(input, 3));

        input = new int[]{1, 1, -1, -1, 3};
        System.out.println(searchTriplet(input, 1));
        System.out.println(threeSumClosest(input, 1));


    }

    /**
     * Sort Arrays, Use two pointers
     * Ignore equal case
     * Compare Abs sum - target with result - target
     */
    public static int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }

    //Poor Solution
    public static int searchTriplet(int[] arr, int targetSum) {
        int sol = Integer.MAX_VALUE;
        int prevDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i];
            int start = i + 1, end = arr.length - 1;
            while (start < end) {
                int second = arr[start];
                int third = arr[end];
                int sum = first + second + third;
                if (Math.abs(targetSum - sum) < prevDiff) {
                    sol = sum;
                    prevDiff = Math.min(targetSum - sum, prevDiff);
                } else if (targetSum - sum == prevDiff) {
                    sol = Math.min(sum, sol);
                    prevDiff = Math.min(Math.abs(targetSum) - sum, prevDiff);
                }
                if (sum == targetSum) {
                    start++;
                    end--;
                } else if (sum < targetSum) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return sol;
    }


}
