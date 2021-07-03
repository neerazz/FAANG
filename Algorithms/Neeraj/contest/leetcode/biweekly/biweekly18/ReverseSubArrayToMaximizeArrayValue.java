package biweekly.biweekly18;

import java.util.Arrays;

/*
You are given an integer array nums. The value of this array is defined as the sum of |nums[i]-nums[i+1]| for all 0 <= i < nums.length-1.
You are allowed to select any subarray of the given array and reverse it. You can perform this operation only once.
Find maximum possible value of the array.

Example 1:
Input: nums = [2,3,1,5,4]
Output: 10
Explanation: By reversing the subarray [3,1,5] the array becomes [2,5,1,3,4] whose value is 10.

Example 2:
Input: nums = [2,4,9,24,2,1,10]
Output: 68

Constraints:
1 <= nums.length <= 3*10^4
-10^5 <= nums[i] <= 10^5
 */
public class ReverseSubArrayToMaximizeArrayValue {
    public static void main(String[] args) {
        System.out.println(maxValueAfterReverse(new int[]{2, 3, 1, 5, 4}) + " should be 10.");
        System.out.println(maxValueAfterReverse(new int[]{2, 4, 9, 24, 2, 1, 10}) + " should be 68.");
        System.out.println(maxValueAfterReverse_elegent(new int[]{2, 4, 9, 24, 2, 1, 10}) + " should be 68.");
    }

    public static int maxValueAfterReverse_elegent(int[] A) {
        int total = 0, res = 0, min2 = 123456, max2 = -123456, n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            int a = A[i], b = A[i + 1];
            total += Math.abs(a - b);
            res = Math.max(res, Math.abs(A[0] - b) - Math.abs(a - b));
            res = Math.max(res, Math.abs(A[n - 1] - a) - Math.abs(a - b));
            min2 = Math.min(min2, Math.max(a, b));
            max2 = Math.max(max2, Math.min(a, b));
        }
        return total + Math.max(res, (max2 - min2) * 2);
    }

    public static int maxValueAfterReverse(int[] nums) {
        int initial = findValue(nums);
        System.out.println("initial = " + initial);
        int maxAfterSwap = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int after = findReverseSum(nums, i, j);
                maxAfterSwap = Math.max(after - initial, maxAfterSwap);
                System.out.println("i = " + i + ", j = " + j + " maxAfterSwap = " + maxAfterSwap);
            }
        }
        return initial + maxAfterSwap;
    }

    private static int findValue(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += Math.abs(nums[i] - nums[i + 1]);
        }
        return sum;
    }

    private static int findReverseSum(int[] nums, int i, int j) {
        int[] reverse = Arrays.copyOf(nums, nums.length);
        int left = i, right = j;
        while (left < right) {
            int temp = reverse[left];
            reverse[left] = reverse[right];
            reverse[right] = temp;
            left++;
            right--;
        }
        return findValue(reverse);
    }
}
