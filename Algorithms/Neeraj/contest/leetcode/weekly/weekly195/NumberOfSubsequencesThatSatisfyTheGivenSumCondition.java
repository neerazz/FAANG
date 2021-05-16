package weekly.weekly195;

import java.util.*;

/**
 * Created on:  Jun 27, 2020
 * Questions:
 * Number of Subsequences That Satisfy the Given Sum Condition
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
 */
public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public static void main(String[] args) {
        System.out.println("************************************ Solution 1 ************************************");
        System.out.println(numSubseq(new int[]{3, 5, 6, 7}, 9) + " should be [4]");
        System.out.println(numSubseq(new int[]{3, 3, 6, 8}, 10) + " should be [6]");
        System.out.println(numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12) + " should be [61]");
        System.out.println(numSubseq(new int[]{5, 2, 4, 1, 7, 6, 8}, 16) + " should be [127]");
        System.out.println("************************************ Solution 2 (Missing Edge Cases) ************************************");
        System.out.println(numSubseq_wrong(new int[]{3, 5, 6, 7}, 9) + " should be [4]");
        System.out.println(numSubseq_wrong(new int[]{3, 3, 6, 8}, 10) + " should be [6]");
        System.out.println(numSubseq_wrong(new int[]{2, 3, 3, 4, 6, 7}, 12) + " should be [61]");
        System.out.println(numSubseq_wrong(new int[]{5, 2, 4, 1, 7, 6, 8}, 16) + " should be [127]");
        System.out.println(numSubseq_wrong(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22) + " should be [272187084]");
        System.out.println("************************************ Solution 3 ************************************");
        System.out.println(numSubseq_optimal(new int[]{3, 5, 6, 7}, 9) + " should be [4]");
        System.out.println(numSubseq_optimal(new int[]{3, 3, 6, 8}, 10) + " should be [6]");
        System.out.println(numSubseq_optimal(new int[]{2, 3, 3, 4, 6, 7}, 12) + " should be [61]");
        System.out.println(numSubseq_optimal(new int[]{5, 2, 4, 1, 7, 6, 8}, 16) + " should be [127]");
        System.out.println(numSubseq_optimal(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22) + " should be [272187084]");
    }

    private static int numSubseq_optimal(int[] nums, int target) {
        int len = nums.length, mod = 1_000_000_007;
        int[] dp = new int[len+1];
        dp[0] =1;
        for (int i = 1; i < len; i++) {
            dp[i] = (dp[i-1] * 2) % mod;
        }
        Arrays.sort(nums);
        int result =0, start = 0, end = len-1;
//        Find teh two sum of two point below the given target.
//          If the sum is less then the target, then you can add that value to the result.
        while(start <= end){
//            Do it till start == end because we have subset of one element also that satisfies the condition.
            if(nums[start] + nums[end] > target){
//                If those two points sum is greater then reduce teh high pointer and keep checking.
                end--;
            }else{
//                If sum of start and end is less then or equal then.
//                  The result for current combination will the possibilities of elements between first and last element.
//                  Then move the start pointer because next pointers will also include the possibilities of starting..
                result = (result + dp[end - start]) % mod;
                start++;
            }
        }
        return result;
    }

    private static int numSubseq_wrong(int[] nums, int target) {
        int len = nums.length;
        Integer[][] dp = new Integer[len + 1][3];
        nums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
        Integer[] result = helper(nums, target, 0, dp);
        return result[0];
    }

    private static Integer[] helper(int[] nums, int target, int start, Integer[][] dp) {
        Integer[] result = new Integer[3];
        if (start == nums.length - 1) {
            int cur = 0;
            if (nums[start] + nums[start] <= target) cur++;
            result[0] = cur;
            result[1] = result[2] = nums[start];
        } else {
            if (dp[start][0] != null) return dp[start];
            Integer[] next = helper(nums, target, start + 1, dp);
            int curMin = next[1], curMax = Math.max(next[2], nums[start]), curResult = next[0];
            if (curMin + curMax <= target) {
                curResult = (2 * next[0]) % mod;
            }
            if (nums[start] + nums[start] <= target) curResult++;
            result[0] = curResult;
            result[1] = curMin;
            result[2] = curMax;
        }
        return dp[start] = result;
    }

    static int op, mod = 1_000_000_007;

    public static int numSubseq(int[] nums, int target) {
        op = 0;
        memo = new HashMap<>();
        Integer[] dp = new Integer[nums.length + 1];
        nums = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
        helper(nums, target, 0, dp);
        return dp[0];
    }

    static Map<Integer, List<List<Integer>>> memo;

    private static List<List<Integer>> helper(int[] nums, int target, int start, Integer[] dp) {
        if (start == nums.length) return Collections.emptyList();
        if (dp[start] != null) {
            op = ((op % mod) + (dp[start] % mod)) % mod;
            return memo.get(start);
        }
        List<List<Integer>> next = helper(nums, target, start + 1, dp);
        List<List<Integer>> cur = new ArrayList<>(next);
        cur.add(Collections.singletonList(nums[start]));
        for (List<Integer> level : next) {
            List<Integer> temp = new ArrayList<>(level);
            temp.add(nums[start]);
            cur.add(temp);
        }
        dp[start] = getValue(cur, target);
        memo.put(start, cur);
        return cur;
    }

    private static int getValue(List<List<Integer>> cur, int target) {
        int min, max, result = 0;
        for (List<Integer> level : cur) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int val : level) {
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
            if (min + max <= target) result++;
        }
        return result;
    }
}
