package arraysAndString;

/*
https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1144/

Example 1:
Input:
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation:
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.

Example 2:
Input:
nums = [1, 2, 3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.
Solution: https://medium.com/@kellidavis320/how-to-solve-pivot-index-algorithm-in-java-154e11047a58
 */
public class FindPivotIndex {
    public static void main(String[] args) {
        System.out.println("Answer is: " + pivotIndex(new int[]{1, 7, 3, 6, 5, 6}) + " should be 3.");
        System.out.println("Answer is: " + pivotIndex(new int[]{1, 2, 3}) + " should be -1.");
    }

    private static int pivotIndex(int[] nums) {
        int size = nums.length;
        if (size == 0) return -1;

//        Get the sum of previous values at current position.
        for (int i = 1; i < size; i++) {
            nums[i] += nums[i - 1];
        }
        if (nums[size - 1] - nums[0] == 0) return 0;
        int last = nums[size - 1];

        for (int i = 1; i < size; i++) {
            if (last - nums[i] == nums[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotIndex_naive(int[] nums) {
        int size = nums.length;
        if (size == 0) return -1;
        for (int i = 0; i < size; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j < i) {
                    left += nums[j];
                } else if (j > i) {
                    right += nums[j];
                }
            }
            if (left == right) return i;
        }
        return -1;
    }
}
