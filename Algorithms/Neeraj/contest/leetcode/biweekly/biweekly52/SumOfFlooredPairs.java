package biweekly.biweekly52;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created on:  May 15, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-52/problems/sum-of-floored-pairs/
 */

public class SumOfFlooredPairs {

    public static void main(String[] args) {
        System.out.println(sumOfFlooredPairs(new int[]{2, 5, 9}));
    }

    public static int sumOfFlooredPairs(int[] nums) {
        long sum = 0, mod = 1_000_000_007;
        int max = Integer.MIN_VALUE, maxNumbers = 1_00_000 + 2;
        int[] counts = new int[maxNumbers];
        for (int num : nums) {
            counts[num]++;
            max = Math.max(max, num);
        }
//        Get counts of numbers before an index.
        int[] preSum = new int[maxNumbers + 1];
        for (int i = 1; i <= maxNumbers; i++) {
            preSum[i] = preSum[i - 1] + counts[i - 1];
        }
        for (int i = 0; i < maxNumbers; i++) {
            if (counts[i] == 0) continue;
//            Multiply the current by 1 to max/i times:
//              This way you can find out total numbers that can occur between curr*j to cur *(j+1)-1.
            for (int j = 1; j <= max / i; j++) {
                int start = i * j, startIdx = Math.min(start, preSum.length - 1);
                int end = i * (j + 1) - 1, endIdx = Math.min(end + 1, preSum.length - 1);
                int countsInBetween = preSum[endIdx] - preSum[startIdx];
                sum += (long) j * countsInBetween * counts[i];
                sum %= mod;
            }
        }
        return (int) (sum % mod);
    }

    public static int sumOfFlooredPairs_naive2(int[] nums) {
        long sum = 0, mod = 1_000_000_007;
        Map<Integer, Integer> counts = new HashMap<>();
        TreeSet<Integer> sorting = new TreeSet<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            sorting.add(num);
        }
        int[] uniqueSorted = sorting.stream().mapToInt(i -> i).toArray();
        for (int key : sorting) {
            int idx = Arrays.binarySearch(uniqueSorted, key);
            int c1 = counts.get(key);
            for (int i = idx; i < uniqueSorted.length; i++) {
                int floor = uniqueSorted[i] / key;
                int c2 = counts.get(uniqueSorted[i]);
                sum += (long) floor * c1 * c2;
                sum %= mod;
            }
        }
        return (int) (sum % mod);
    }

    public static int sumOfFlooredPairs_naive(int[] nums) {
        Arrays.sort(nums);
        long sum = 0, mod = 1_000_000_007;
        Map<Integer, Integer> indxs = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            indxs.putIfAbsent(nums[i], i);
        }
        for (int num : nums) {
            int start = indxs.get(num);
            for (int j = start; j < len; j++) {
                sum += nums[j] / num;
                sum %= mod;
            }
        }
        return (int) (sum % mod);
    }
}
