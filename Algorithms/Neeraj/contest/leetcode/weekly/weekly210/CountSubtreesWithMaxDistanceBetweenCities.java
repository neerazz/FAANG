package weekly.weekly210;

import java.util.*;

/**
 * Created on:  Oct 10, 2020
 * Questions: https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities
 */

public class CountSubtreesWithMaxDistanceBetweenCities {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countSubgraphsForEachDiameter(4, new int[][]{{1, 2}, {2, 3}, {2, 4}})));
    }

    public static int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        boolean[] visited = new boolean[n + 1];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        System.out.println("map = " + map);
        int[] distances = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                calculateDistance(j, map, 0, i, distances);
            }
        }
        System.out.println("distances = " + Arrays.toString(distances));
        return distances;
    }

    private static void calculateDistance(int cur, Map<Integer, Set<Integer>> map, int curDist, int dist, int[] distances) {
        if (curDist == dist) {
            distances[dist]++;
        } else {
            for (int dep : map.get(cur)) {
                calculateDistance(dep, map, curDist + 1, dist, distances);
            }
        }
    }
}
