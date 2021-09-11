import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jan 14, 2021
 * Questions: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3603/
 */

public class MinimumOperationsToReduceXToZero {

    public static void main(String[] args) {
        System.out.println("Answer  : " + minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365));
        System.out.println("Expected: " + minOperations_dp(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365));

        System.out.println("Answer  : " + minOperations(new int[]{1241, 8769, 9151, 3211, 2314, 8007, 3713, 5835, 2176, 8227, 5251, 9229, 904, 1899, 5513, 7878, 8663, 3804, 2685, 3501, 1204, 9742, 2578, 8849, 1120, 4687, 5902, 9929, 6769, 8171, 5150, 1343, 9619, 3973, 3273, 6427, 47, 8701, 2741, 7402, 1412, 2223, 8152, 805, 6726, 9128, 2794, 7137, 6725, 4279, 7200, 5582, 9583, 7443, 6573, 7221, 1423, 4859, 2608, 3772, 7437, 2581, 975, 3893, 9172, 3, 3113, 2978, 9300, 6029, 4958, 229, 4630, 653, 1421, 5512, 5392, 7287, 8643, 4495, 2640, 8047, 7268, 3878, 6010, 8070, 7560, 8931, 76, 6502, 5952, 4871, 5986, 4935, 3015, 8263, 7497, 8153, 384, 1136}, 894887480));
        System.out.println("Expected: " + minOperations_dp(new int[]{1241, 8769, 9151, 3211, 2314, 8007, 3713, 5835, 2176, 8227, 5251, 9229, 904, 1899, 5513, 7878, 8663, 3804, 2685, 3501, 1204, 9742, 2578, 8849, 1120, 4687, 5902, 9929, 6769, 8171, 5150, 1343, 9619, 3973, 3273, 6427, 47, 8701, 2741, 7402, 1412, 2223, 8152, 805, 6726, 9128, 2794, 7137, 6725, 4279, 7200, 5582, 9583, 7443, 6573, 7221, 1423, 4859, 2608, 3772, 7437, 2581, 975, 3893, 9172, 3, 3113, 2978, 9300, 6029, 4958, 229, 4630, 653, 1421, 5512, 5392, 7287, 8643, 4495, 2640, 8047, 7268, 3878, 6010, 8070, 7560, 8931, 76, 6502, 5952, 4871, 5986, 4935, 3015, 8263, 7497, 8153, 384, 1136}, 894887480));
    }

    public static int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int target = sum - x;
        if (target == 0) return nums.length;
        int len = maxSubArrayWithSum(nums, target);
        return len == 0 ? -1 : nums.length - len;
    }

    private static int maxSubArrayWithSum(int[] nums, int target) {
        int max = 0, p1 = 0, p2 = 0, sum = 0;
        while (p2 < nums.length) {
            sum += nums[p2];
            while (sum > target && p1 < p2) {
                sum -= nums[p1++];
            }
            if (sum == target && p2 - p1 + 1 > max) {
                max = p2 - p1 + 1;
            }
            p2++;
        }
        return max;
    }

    public static int minOperations_dp(int[] nums, int x) {
        Map<String, Integer> memo = new HashMap<>();
        int result = helper(nums, 0, nums.length - 1, 0, x, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int helper(int[] nums, int start, int end, int soFar, int x, Map<String, Integer> memo) {
        if (x == soFar) return 0;
        if (soFar > x || start > end) return Integer.MAX_VALUE;
        if (start == end) {
            if (nums[start] + soFar == x) return 1;
            return Integer.MAX_VALUE;
        }
        String key = String.format("%d-%d %d", start, end, soFar);
        if (memo.containsKey(key)) return memo.get(key);
        int left = helper(nums, start + 1, end, soFar + nums[start], x, memo);
        int right = helper(nums, start, end - 1, soFar + nums[end], x, memo);
        int cur = Math.min(left, right) == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(left, right) + 1;
        memo.put(key, cur);
        return cur;
    }
}
