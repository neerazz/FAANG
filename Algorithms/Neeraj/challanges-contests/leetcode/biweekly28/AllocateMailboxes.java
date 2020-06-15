package biweekly28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created on:  Jun 13, 2020
 * Questions:
 */
public class AllocateMailboxes {
    static Map<String, Integer> memo;

    public static void main(String[] args) {
        System.out.println(minDistance(new int[]{1, 4, 8, 10, 20}, 3) + " should be [5]");
        System.out.println(minDistance(new int[]{14, 2, 5, 7, 10}, 2) + " should be [9]");
        System.out.println(minDistance(new int[]{15, 8, 9, 6}, 1) + " should be [10]");
    }

    public static int minDistance(int[] houses, int k) {
        memo = new HashMap<>();
        Arrays.sort(houses);
        return backTracking(houses, 0, k, 0);
    }

    private static int backTracking(int[] houses, int start, int k, int boxes) {
        if (boxes == k) return start >= houses.length ? 0 : Integer.MAX_VALUE;
        if (boxes > k || start >= houses.length) return Integer.MAX_VALUE;
        String key = start + "-" + boxes;
        if (memo.containsKey(key)) return memo.get(key);
        int val = Integer.MAX_VALUE;
        for (int end = start; end < houses.length; end++) {
            int dist = getDistance(houses, start, end);
            int next = backTracking(houses, end + 1, k, boxes + 1);
            if (next != Integer.MAX_VALUE) {
                val = Math.min(dist + next, val);
            }
        }
        memo.put(key, val);
        return val;
    }

    private static int getDistance(int[] houses, int start, int end) {
        if (start == end) return 0;
        // Best way to place a mailbox between [start, end] houses is to place at the median house
        int dist = 0;
        int mid = start + (end - start) / 2;
        for (int i = start; i <= end; i++) {
            dist += Math.abs(houses[mid] - houses[i]);
        }
        return dist;
    }
}
