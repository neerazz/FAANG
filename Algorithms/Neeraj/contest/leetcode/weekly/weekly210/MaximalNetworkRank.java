package weekly.weekly210;

import java.util.*;

/**
 * Created on:  Oct 10, 2020
 * Questions: https://leetcode.com/problems/maximal-network-rank
 */

public class MaximalNetworkRank {

    public static void main(String[] args) {
        System.out.println(maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}));
        System.out.println(maximalNetworkRank(2, new int[][]{{1, 0}}));
    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < roads.length; i++) {
            map.get(roads[i][0]).add(i);
            map.get(roads[i][1]).add(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> first = map.get(i);
            for (int j = i + 1; j < n; j++) {
                Set<Integer> second = map.get(j);
                int count = first.size() + second.size();
                for (int next : second) {
                    if (first.contains(next)) count--;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
