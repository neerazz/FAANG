package weekly.weekly209;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created on:  Oct 03, 2020
 * Questions: https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x
 */
public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{3, 5}));
        System.out.println(specialArray(new int[]{17, 11, 11, 4, 15, 5, 15, 13, 2, 0, 8, 12, 11}));
    }

    public static int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        LinkedHashMap<Integer, Integer> counts = new LinkedHashMap<>();
        TreeMap<Integer, Integer> greaterEqual = new TreeMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int less = 0;
        for (int key : counts.keySet()) {
            greaterEqual.put(key, len - less);
            less += counts.get(key);
        }
        for (int i = 1; i <= len; i++) {
            Map.Entry<Integer, Integer> entry = greaterEqual.ceilingEntry(i);
            if (entry != null && entry.getValue().equals(i)) return i;
        }
        return -1;
    }
}
