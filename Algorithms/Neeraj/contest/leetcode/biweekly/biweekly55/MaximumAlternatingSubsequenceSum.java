package biweekly.biweekly55;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-55/problems/maximum-alternating-subsequence-sum/
 */

public class MaximumAlternatingSubsequenceSum {

    public static void main(String[] args) {

    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of(new int[]{4, 2, 5, 3}, 7),
                Arguments.of(new int[]{6, 2, 1, 2, 4, 5}, 10),
                Arguments.of(new int[]{4, 9, 7, 4, 8}, 13),
                Arguments.of(new int[]{19, 9, 1, 6, 14, 11, 9, 5, 7, 11}, 38),
                Arguments.of(new int[]{5, 6, 7, 8}, 8)
        );
    }

    static Function<int[], Long> function = MaximumAlternatingSubsequenceSum::maxAlternatingSum;
//    static Function<int[], Long> function = MaximumAlternatingSubsequenceSum::maxAlternatingSum_2;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(int[] input, long expected) {
        assertEquals(expected, function.apply(input));
    }

    public static long maxAlternatingSum_2(int[] nums) {
        long odd = 0, even = 0;
        for (int a : nums) {
            even = Math.max(even, odd + a);
            odd = even - a;
        }
        return even;
    }

    public static long maxAlternatingSum(int[] nums) {
        int len = nums.length;
        long max = 0;
        Long[] dp = new Long[len];
        for (int i = 0; i < len; i++) {
            max = Math.max(max, helper(nums, i, len, dp));
        }
        System.out.println("dp = " + Arrays.toString(dp));
        return max;
//        return helper(nums, 0, len, dp);
    }

    private static long helper(int[] nums, int cur, int len, Long[] dp) {
        if (cur >= len) return 0;
        if (dp[cur] != null) return dp[cur];
        long max = nums[cur];
//        long max = Math.max(nums[cur], helper(nums, cur + 1, len, dp));
        for (int i = cur + 1; i < len; i++) {
            long curSum = nums[cur] - nums[i];
            long next = helper(nums, i + 1, len, dp);
            long curMax = Math.max(Math.max(curSum, curSum + next), next);
            max = Math.max(max, curMax);
        }
        return dp[cur] = max;
    }
}
