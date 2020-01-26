package problems.arraysAndString;

/*
https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1299/
Solution: https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println("Answer is: " + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}) + " should be 2.");
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, min = 0, size = nums.length;
        int current_sum = 0;

        if (size == 0) return 0;

//        Loop through the array and keep adding the value. Once the sum is greater, then increase the start counter.
        for (int i = 0; i < nums.length; i++) {
            current_sum += nums[i];
            while (current_sum >= s && start <= end) {
                if (min == 0 || min > end - start + 1) {
                    min = end - start + 1;
                }
                current_sum -= nums[start];
                start++;
            }
            end++;
        }
        return min;
    }
}
