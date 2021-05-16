package weekly.weekly206;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 12, 2020
 * Questions:
 */
public class CountUnhappyFriends {
    public static void main(String[] args) {
        System.out.println(unhappyFriends(4, new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}}, new int[][]{{0, 1}, {2, 3}}) + " = 2");
        System.out.println(unhappyFriends(2, new int[][]{{1}, {0}}, new int[][]{{1, 0}}) + " = 0");
        System.out.println(unhappyFriends(4, new int[][]{{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}}, new int[][]{{1, 3}, {0, 2}}) + " = 4");
        System.out.println(unhappyFriends(4, new int[][]{{1, 3, 2}, {2, 3, 0}, {1, 0, 3}, {1, 0, 2}}, new int[][]{{2, 1}, {3, 0}}) + " = 0");
    }

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] dists = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                dists[i][preferences[i][j]] = j + 1;
            }
        }
        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int[] pair : pairs) {
            pairMap.put(pair[0], pair[1]);
            pairMap.put(pair[1], pair[0]);
        }
        int unHappy = 0;
        for (int[] pair : pairs) {
            if (isUnHappy(pair[0], pair[1], pairMap, preferences, dists)) {
                unHappy++;
            }
            if (isUnHappy(pair[1], pair[0], pairMap, preferences, dists)) {
                unHappy++;
            }
        }
        return unHappy;
    }

    private static boolean isUnHappy(int from, int to, Map<Integer, Integer> pairMap, int[][] preferences, int[][] dists) {
        for (int friend : preferences[from]) {
            if (friend == to) break;
            if (pairMap.containsKey(friend) && dists[friend][from] < dists[friend][pairMap.get(friend)]) return true;
        }
        return false;
    }
}
