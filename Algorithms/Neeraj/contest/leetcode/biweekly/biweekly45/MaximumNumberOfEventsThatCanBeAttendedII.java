package biweekly.biweekly45;

import java.util.*;

/**
 * Created on:  Feb 06, 2021
 * Questions:
 */

public class MaximumNumberOfEventsThatCanBeAttendedII {

    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 1}}, 2) + " = 7");
        System.out.println(maxValue(new int[][]{{1, 2, 4}, {3, 4, 3}, {2, 3, 10}}, 2) + " = 10");
        System.out.println(maxValue(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}}, 3) + " = 9");
    }

//    https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/discuss/1052641/java-simple-dp-binary-search-code-with-comments
    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, (e1, e2) -> e1[0] == e2[0] ? Integer.compare(e1[2], e2[2]) : Integer.compare(e1[0], e2[0]));
        Integer[][] dp = new Integer[events.length + 1][k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < events.length; i++) {
//        Create a map to get the closest event after a given point.
            map.putIfAbsent(events[i][0], i);
        }
        return solve(events, 0, k, dp, map);
    }

    private static int solve(int[][] events, int start, int k, Integer[][] dp, TreeMap<Integer, Integer> map) {
        if (start >= events.length || k <= 0) return 0;
        if (dp[start][k] != null) return dp[start][k];
//        There are two options, don't attend this event, other option is attend this event.
        int withOutAttending = solve(events, start + 1, k, dp, map);
        int withAttending = events[start][2];
        Map.Entry<Integer, Integer> nextEntry = map.higherEntry(events[start][1]);
        if (nextEntry != null) {
//            After attending this event there are other events that you can attend.
            withAttending += solve(events, nextEntry.getValue(), k - 1, dp, map);
        }
        return dp[start][k] = Math.max(withOutAttending, withAttending);
    }

}
