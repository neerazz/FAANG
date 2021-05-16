package weekly.weekly220;

import java.util.*;

/**
 * Created on:  Dec 19, 2020
 * Questions:
 */

public class JumpGameVI {

    public static void main(String[] args) {
        System.out.println(maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2));
        System.out.println(maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
        System.out.println(maxResult_rev1(new int[]{1, -1, -2, 4, -7, 3}, 2));
        System.out.println(maxResult_rev1(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2));
        System.out.println(maxResult(new int[]{1, -5, -20, 4, -1, 3, -6, -3}, 2));
    }

    public static int maxResult_rev1(int[] nums, int k) {
        int len = nums.length, max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v2[1] - v1[1]);
//        0: till point, 1: score
        for (int i = 0; i < len; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < i) pq.poll();
            int val = (pq.isEmpty() ? 0 : pq.peek()[1]) + nums[i];
            pq.add(new int[]{i + k, val});
            max = val;
        }
        return max;
    }

    public static int maxResult(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[0] - v2[0]);
//        0: till point, 1: score
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len - 1; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < i) {
//                Remove all those from pq and the map, that ends before reaching this point
                int[] poll = pq.poll();
                int count = map.remove(poll[1]);
                if (count > 1) map.put(poll[1], count - 1);
            }
            int max = map.isEmpty() ? 0 : map.lastKey(), cur = max + nums[i];
            pq.add(new int[]{i + k, cur});
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
//        Now you have reached the last index, Remove all the elements from pq and the map, that ends before last index
        while (!pq.isEmpty() && pq.peek()[0] < len - 1) {
            int[] poll = pq.poll();
            int count = map.remove(poll[1]);
            if (count > 1) map.put(poll[1], count - 1);
        }
        int max = map.isEmpty() ? 0 : map.lastKey();
        return max + nums[len - 1];
    }
}
