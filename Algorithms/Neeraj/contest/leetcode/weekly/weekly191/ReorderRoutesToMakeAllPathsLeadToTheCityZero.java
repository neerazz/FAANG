package weekly.weekly191;

import java.util.*;

/**
 * Created on:  May 30, 2020
 * Questions: https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public static void main(String[] args) {
        System.out.println(minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}) + "\t should be [3].");
    }

    public static int minReorder(int n, int[][] connections) {
        Set<String> dirs = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] con : connections) {
//            Store the actual directions in a set.
            String dir = con[0] + "-" + con[1];
//            And make a bidirectional relationship between cities.
            map.computeIfAbsent(con[0], val -> new HashSet<>()).add(con[1]);
            map.computeIfAbsent(con[1], val -> new HashSet<>()).add(con[0]);
            dirs.add(dir);
        }
        int change = 0;
//        Get all the routes that is connected to zero from bidirectional.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!queue.isEmpty()) {
//            As we are starting with zero. So mark that to be the new destination.
            int to = queue.poll();
            for (int from : map.getOrDefault(to, new HashSet<>())) {
//                This is the key. If you have already checked from this point. Then you should not check again.
                if (visited.contains(from)) continue;
                String newDir = from + "-" + to;
                if (!dirs.contains(newDir)) {
//                    If the new direction is not possible with previous directions. THen We have to change the edge.
                    change++;
                    dirs.add(newDir);
                }
                if (!visited.contains(from)) {
                    queue.add(from);
                    visited.add(from);
                }
            }
        }
        return change;
    }
}
