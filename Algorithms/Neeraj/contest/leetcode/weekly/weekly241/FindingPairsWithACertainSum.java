package weekly.weekly241;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  May 15, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-241/problems/finding-pairs-with-a-certain-sum/
 */

public class FindingPairsWithACertainSum {

    public static void main(String[] args) {

    }

    static class FindSumPairs {
        Map<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        int[] nums2;

        public FindSumPairs(int[] nums1, int[] nums2) {
            buildMap(nums1, map1);
            buildMap(nums2, map2);
            this.nums2 = nums2;
        }

        private void buildMap(int[] nums, Map<Integer, Integer> map) {
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        public void add(int index, int val) {
            int before = nums2[index], after = nums2[index] += val;
            int occ1 = map2.remove(before), occ2 = map2.getOrDefault(after, 0);
            if (occ1 > 1) map2.put(before, occ1 - 1);
            map2.put(after, occ2 + 1);
        }

        public int count(int tot) {
            int pair = 0;
            for (int val1 : map1.keySet()) {
                int rem = tot - val1;
                pair += map1.get(val1) * map2.getOrDefault(rem, 0);
            }
            return pair;
        }
    }
}
