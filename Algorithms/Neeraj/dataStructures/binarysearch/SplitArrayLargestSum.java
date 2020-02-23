/*
https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1042/
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
Note:
If n is the length of array, assume the following constraints are satisfied:
1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:
Input:
nums = [7,2,5,10,8]
m = 2
Output:
18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        System.out.println("Answer is :" + splitArray(new int[]{7, 2, 5, 10, 8}, 2) + " should be [18].");
    }

    public static int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int lo = max;
        int hi = sum;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int numOfSubarrays = split(nums, mid);
            if (numOfSubarrays > m) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int split(int[] nums, int validMaxSum) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            if (sum + num > validMaxSum) {
                sum = num;
                count++;
            } else {
                sum += num;
            }
        }
        return count;
    }
}
