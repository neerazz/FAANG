import java.util.Arrays;

/**
 * Created on:  Jul 26, 2020
 * Questions: https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
 */
public class MaximumSumOf3NonOverlappingSubarrays {
    public static void main(String[] args) {
        System.out.println("******************************** Solution 1 *******************************");
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));

        System.out.println("******************************** Solution 2 *******************************");
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays_Optimal(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
    }

    public static int[] maxSumOfThreeSubarrays_Optimal(int[] nums, int k) {
        int len = nums.length, sum = 0, idx = 0;
//        Get all possible sub array sums with size k.
        int[] sums = new int[len - k + 1];
        while (idx < k - 1) {
            sum += nums[idx++];
        }
        for (int i = k - 1; i < len; i++) {
            sum += nums[i];
            sums[i - k + 1] = sum;
            sum -= nums[i - k + 1];
        }
        int[] left = new int[sums.length], right = new int[sums.length];

//        Loop through right to left, and Get the index of starting point that gives max sum.
        int best = 0;
        for (int i = 0; i < sums.length; i++) {
            if (sums[best] < sums[i]) {
                best = i;
            }
            left[i] = best;
        }
//        Loop through right to left, and Get the index of starting point that gives max sum.
        best = sums.length - 1;
        for (int i = sums.length - 1; i >= 0; i--) {
//            When checking from right, to get the starting index of array that will give max result. THis will make sure that our output is lexicographically sorted.
            if (sums[best] <= sums[i]) {
                best = i;
            }
            right[i] = best;
        }

        int[] temp = {0, 0, 0, 0};
//        System.out.println("left   = " + Arrays.toString(left));
//        System.out.println("center = " + Arrays.toString(sums));
//        System.out.println("right  = " + Arrays.toString(right));
//        Loop the center pointer from through the extra nodes. Range(k, [len-k+1]-k).

        for (int i = k; i < len - 2 * k + 1; i++) {
            int cur = sums[left[i - k]] + sums[i] + sums[right[i + k]];
            if (cur > temp[0]) {
                temp = new int[]{cur, left[i - k], i, right[i + k]};
            }
        }
        return Arrays.copyOfRange(temp, 1, 4);
    }

    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        Integer[][][] dp = new Integer[nums.length + 1][4][4];
        Integer[] result = helper(nums, 0, 0, k, dp);
        return new int[]{result[1], result[2], result[3]};
    }

    private static Integer[] helper(int[] nums, int start, int rem, int k, Integer[][][] dp) {
        if (rem == 3) return new Integer[]{0, 0, 0, 0};
        if (dp[start][rem][0] != null) return dp[start][rem];
        int sum = 0, p2 = start, end = nums.length - (3 - rem) * k;
        Integer[] cur = new Integer[]{0, 0, 0, 0};
        for (int i = start; i <= end; i++) {
            while (p2 - i < k) {
                sum += nums[p2++];
            }
            Integer[] next = dp[i + k][rem + 1] = helper(nums, i + k, rem + 1, k, dp);
            if (next[0] + sum > cur[0]) {
                cur = Arrays.copyOf(next, 4);
                cur[0] = next[0] + sum;
                cur[rem + 1] = i;
            }
            sum -= nums[i];
        }
        return cur;
    }
}
