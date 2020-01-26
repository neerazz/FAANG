package problems.hashtable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1133/
Given a non-empty array of integers, return the k most frequent elements.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:
Input: nums = [1], k = 1
Output: [1]
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2) + " should be [1,2].");
        System.out.println(topKFrequent(new int[]{1}, 1) + " should be [1].");
        System.out.println(topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2) + " should be [-1,2].");
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> collect = map.values().stream().sorted(Comparator.reverseOrder()).limit(k).collect(Collectors.toList());
        return map.entrySet().stream().filter(e -> collect.contains(e.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
