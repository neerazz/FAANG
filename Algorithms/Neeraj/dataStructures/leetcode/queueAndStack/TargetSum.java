package ds.queueAndStack;

/*
https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1389/
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
Find out how many ways to assign symbols to make sum of integers equal to target S.
Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
public class TargetSum {
    static int numberOfWays = 0;

    public static void main(String[] args) {
        System.out.println("Answer is :" + findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3) + " should be [5].");
        System.out.println("Answer is :" + findTargetSumWays(new int[]{1, 0}, 1) + " should be [2].");
    }

    public static int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) {
            if (nums[0] == S || nums[0] * -1 == S) return 1;
            else return 0;
        }
        findNumberOfWays(nums, 0, 0, -1, S);
        findNumberOfWays(nums, 0, 0, +1, S);
        int output = numberOfWays;
        numberOfWays = 0;
        return output;
    }

    private static int findNumberOfWays(int[] nums, int index, int sum, int multiplicationFactor, int target) {
        if (index >= nums.length) return sum;
        sum += nums[index] * multiplicationFactor;
        int sumA = findNumberOfWays(nums, index + 1, sum, -1, target);
        int sumB = findNumberOfWays(nums, index + 1, sum, 1, target);
        if (index == nums.length - 1 && (sumA == target || sumB == target)) numberOfWays++;
        return sum;
    }
}
