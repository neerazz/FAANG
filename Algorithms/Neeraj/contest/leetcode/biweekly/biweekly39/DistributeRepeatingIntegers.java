package biweekly.biweekly39;

import java.util.*;

/**
 * Created on:  Nov 14, 2020
 * Questions:
 */

public class DistributeRepeatingIntegers {

    public static void main(String[] args) {
        System.out.println(canDistribute(
                new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 24, 25, 25, 26, 26, 27, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 34, 34, 35, 35, 36, 36, 37, 37, 38, 38, 39, 39, 40, 40, 41, 41, 42, 42, 43, 43, 44, 44, 45, 45, 46, 46, 47, 47, 48, 48, 49, 49, 50, 50},
                new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
    }

    public static boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] counts = new int[map.size()];
        int idx = 0;
        for (int val : map.values()) {
            counts[idx++] = val;
        }
        Arrays.sort(counts);
        quantity = Arrays.stream(quantity).boxed().sorted((v1, v2) -> v2 - v1).mapToInt(val -> val).toArray();
        return helper(counts, 0, quantity);
    }

    private static boolean helper(int[] counts, int idx, int[] quantity) {
        if (idx == quantity.length) return true;
        int req = quantity[idx];
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            if (count >= req) {
                counts[i] -= req;
                if (helper(counts, idx + 1, quantity)) return true;
                counts[i] += req;
            }
        }
        return false;
    }
}
