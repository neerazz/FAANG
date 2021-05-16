package biweekly.biweekly35;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 19, 2020
 * Questions: https://leetcode.com/problems/make-sum-divisible-by-p
 */
public class MakeSumDivisibleByP {
    public static void main(String[] args) {
        System.out.println(minSubarray(new int[]{6, 3, 5, 2}, 9) + " = 2");
        System.out.println(minSubarray(new int[]{3, 6, 8, 1}, 8) + " = -1");
        System.out.println(minSubarray(new int[]{4, 5, 8, 5, 4}, 7) + " = 1");
        System.out.println(minSubarray(new int[]{3, 1, 4, 2}, 6) + " = 1");
        System.out.println(minSubarray(new int[]{1, 2, 3}, 3) + " = 0");
        System.out.println(minSubarray(new int[]{1, 2, 3}, 7) + " = -1");
        System.out.println(minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3) + " = 0");
    }

    public static int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int num : nums) sum += num;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        int min = nums.length, requiredRemainder = (int) (sum % p);
        if (requiredRemainder == 0) return 0;
        long curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
//            Search for subset that can give a remainder exactly same as the required remainder.
//              It can be found by doing requiredRemainder - curRem, But there are situations that it can produce negative value.
//              To avoid that do it p - requiredRemainder + curRem.
            long curRem = curSum % p, key = (p - requiredRemainder + curRem) % p;
            if (nums[i] % p == requiredRemainder) return 1;
            if (map.containsKey(key)) {
                min = Math.min(min, i - map.get(key));
            }
            map.put(curRem, i);
        }
        return min == nums.length ? -1 : min;
    }

    public static int minSubarray_naive(int[] nums, int p) {
        long sum = 0;
        long[] prefixSum = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = sum;
            sum += nums[i];
        }
        if (sum % p == 0) return 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (isPossible(nums, i, sum, p)) return i;
        }
        return -1;
    }

    private static boolean isPossible(int[] nums, int remove, long sum, int p) {
        long cur = 0;
        int p1 = 0, p2 = 0;
        while (p2 < remove - 1) {
            cur += nums[p2++];
        }
        while (p2 < nums.length) {
            cur += nums[p2++];
            if ((sum - cur) % p == 0) {
                return true;
            }
            cur -= nums[p1++];
        }
        return false;
    }
}
