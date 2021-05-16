package weekly.weekly201;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Aug 08, 2020
 * Questions: https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 */
public class MaximumNumberOfNonOverlappingSubarraysWithSumEqualsTarget {
    public static void main(String[] args) {
        System.out.println(maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2) + " = 2");
        System.out.println(maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6) + " = 2");
        System.out.println(maxNonOverlapping(new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10) + " = 3");
        System.out.println(maxNonOverlapping(new int[]{0, 0, 0}, 0) + " = 3");
    }

    public static int maxNonOverlapping(int[] nums, int target) {
        int len = nums.length;
        int[] counts = new int[len];
        int found = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                int index = map.get(sum - target);
                if (index == -1) {
                    found = Math.max(found, 1);
                } else if (index >= 0) {
//                    If the sub array sum is found then, update the found value
                    found = Math.max(found, counts[index] + 1);
                }
            }
            map.put(sum, i);
            counts[i] = found;
        }
        return counts[len - 1];
    }
}
