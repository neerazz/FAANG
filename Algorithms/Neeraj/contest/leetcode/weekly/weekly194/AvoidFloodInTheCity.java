package weekly.weekly194;

import java.util.*;

/**
 * Created on:  Jun 20, 2020
 * Questions: https://leetcode.com/problems/avoid-flood-in-the-city/submissions/
 */
public class AvoidFloodInTheCity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 2, 0, 2, 3, 0, 1})));
    }

    public static int[] avoidFlood(int[] rains) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake > 0) {
                map.computeIfAbsent(lake, val -> new LinkedList<>()).add(i);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] == v2[1] ? Integer.compare(v2[0], v1[0]) : Integer.compare(v1[1], v2[1]));
        Set<Integer> filled = new HashSet<>();
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake > 0) {
                if (filled.contains(lake)) return new int[0];
                Queue<Integer> queue = map.get(lake);
                while (!queue.isEmpty() && queue.peek() <= i) {
                    queue.poll();
                }
                int next = queue.isEmpty() ? Integer.MAX_VALUE : queue.poll();
                filled.add(lake);
                rains[i] = -1;
                pq.add(new int[]{lake, next});
            } else if (!pq.isEmpty()) {
//                Then try to pick a lake to empty.
                filled.remove(rains[i] = pq.poll()[0]);
            } else {
                rains[i] = 1;
            }
        }
        return rains;
    }
}
