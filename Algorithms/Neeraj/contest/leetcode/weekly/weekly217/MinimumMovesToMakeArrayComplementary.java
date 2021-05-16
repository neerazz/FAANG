package weekly.weekly217;

import java.util.*;

/**
 * Created on:  Nov 28, 2020
 * Questions:
 */

public class MinimumMovesToMakeArrayComplementary {

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 2, 2, 1}, 2));
        System.out.println(minMoves(new int[]{1,2,4,3}, 4));
    }

    public static int minMoves(int[] nums, int limit) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len / 2; i++) {
            int sum = nums[i] + nums[len - i - 1];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        int minMoves = Integer.MAX_VALUE;
        for (int key : map.keySet()) {
            int cur = 0;
            for (int key2 : map.keySet()) {
                int diff = Math.abs(key2 - key);
                int moves = diff / limit + (diff % limit > 0 ? 1 : 0);
                cur += (moves) * map.get(key2);
            }
            minMoves = Math.min(minMoves, cur);
        }
        return minMoves;
    }
}
