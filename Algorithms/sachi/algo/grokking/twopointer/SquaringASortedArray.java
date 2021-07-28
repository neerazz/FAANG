package algo.grokking.twopointer;

import util.Util;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 * <p>
 * Example 1:
 * <p>
 * Input: [-2, -1, 0, 2, 3]
 * Output: [0, 1, 4, 4, 9]
 * Example 2:
 * <p>
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 */

public class SquaringASortedArray {

    public static void main(String[] args) {
        int[] input = new int[]{-2, -1, 0, 2, 3};
        Util.print(sortedSquares(input));
    }


    //Fill new array from end
    //Compare abs values of start & end
    public static int[] sortedSquares(int[] nums) {
        int[] sol = new int[nums.length];
        int start = 0, end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int startNum = nums[start] < 0 ? -1 * nums[start] : nums[start];
            int endNum = nums[end] < 0 ? -1 * nums[end] : nums[end];
            if (startNum > endNum) {
                sol[i] = startNum * startNum;
                start++;
            } else {
                sol[i] = endNum * endNum;
                end--;
            }
        }
        return sol;
    }
}
