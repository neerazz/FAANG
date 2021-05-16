package weekly.weekly226;

import java.util.*;

/**
 * Created on:  Jan 30, 2021
 * Questions:
 */

public class RestoreTheArrayFromAdjacentPairs {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(restoreArray(new int[][]{{4, -2}, {1, 4}, {-3, 1}})));
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer> cons = new HashMap<>();
        Map<Integer, Set<Integer>> pairs = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int len = adjacentPairs.length, i = 0;
        int[] result = new int[len + 1];
        for (int[] pair : adjacentPairs) {
            int a = pair[0], b = pair[1];
            cons.put(a, cons.getOrDefault(a, 0) + 1);
            cons.put(b, cons.getOrDefault(b, 0) + 1);
            pairs.computeIfAbsent(a, val -> new HashSet<>()).add(b);
            pairs.computeIfAbsent(b, val -> new HashSet<>()).add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
//        Find all the nodes that has one connection.
        for (Map.Entry<Integer, Integer> entry : cons.entrySet()) {
            if (entry.getValue() == 1) {
                queue.add(entry.getKey());
                result[i++] = entry.getKey();
                visited.add(entry.getKey());
                break;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
//            Loop though all the dep nodes
            for (int dep : pairs.get(cur)) {
                if (visited.contains(dep)) continue;
                int occ = cons.get(dep);
                if (--occ <= 1) {
                    queue.add(dep);
                    result[i++] = dep;
                    visited.add(dep);
                }
            }
        }
        return result;
    }
}
