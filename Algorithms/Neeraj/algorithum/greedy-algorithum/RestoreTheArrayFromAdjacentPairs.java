import java.util.*;

/**
 * Created on:  May 23, 2021
 * Questions: https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 */

public class RestoreTheArrayFromAdjacentPairs {

    public static void main(String[] args) {

    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        LinkedList<Integer> result = new LinkedList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        buildMap(adjacentPairs, map);
        int n = adjacentPairs.length + 1;
        int[] first = adjacentPairs[0];
        result.add(first[0]);
        result.add(first[1]);
        while (result.size() < n) {
            int left = getPre(result.getFirst(), result.get(1), map);
            if (left != Integer.MIN_VALUE) result.addFirst(left);
            int right = getNext(result.get(result.size() - 2), result.getLast(), map);
            if (right != Integer.MIN_VALUE) result.add(right);
        }
        return result.stream().mapToInt(val -> val).toArray();
    }

    private static int getNext(Integer pre, Integer cur, Map<Integer, Set<Integer>> map) {
        for (int next : map.getOrDefault(cur, new HashSet<>())) {
            if (next == pre) continue;
            else return next;
        }
        return Integer.MIN_VALUE;
    }

    private static int getPre(Integer cur, Integer next, Map<Integer, Set<Integer>> map) {
        for (int pre : map.getOrDefault(cur, new HashSet<>())) {
            if (next == pre) continue;
            else return pre;
        }
        return Integer.MIN_VALUE;
    }

    private static void buildMap(int[][] pairs, Map<Integer, Set<Integer>> map) {
        for (int[] pair : pairs) {
            int a = pair[0], b = pair[1];
            map.computeIfAbsent(a, val -> new HashSet<>()).add(b);
            map.computeIfAbsent(b, val -> new HashSet<>()).add(a);
        }
    }
}
