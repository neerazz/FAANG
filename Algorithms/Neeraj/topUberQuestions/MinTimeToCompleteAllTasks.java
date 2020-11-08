import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 07, 2020
 * Questions: https://leetcode.com/discuss/interview-question/881980/Snapchat-Uber-or-Minimum-time-to-complete-all-tasks
 */

public class MinTimeToCompleteAllTasks {

    public static void main(String[] args) {
        System.out.println(minTimeToComplete(new int[][]{{}}, new int[]{}));
    }

    private static int minTimeToComplete(int[][] deps, int[] time) {
        int tasks = time.length;
        int[] inbound = new int[tasks];
        int[] times = new int[tasks];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] dep : deps) {
            inbound[dep[1]]++;
            graph.computeIfAbsent(dep[0], val -> new HashSet<>()).add(dep[1]);
        }
        int processed = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tasks; i++) {
            if (inbound[i] == 0) {
                queue.add(i);
                processed++;
            }
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int dep : graph.getOrDefault(poll, new HashSet<>())) {
                times[dep] = Math.max(time[dep], times[poll] + time[dep]);
                inbound[dep]--;
                if (inbound[dep] == 0) {
                    queue.add(dep);
                    processed++;
                }
            }
        }
        if (processed < tasks) return -1;
        return Arrays.stream(times).max().getAsInt();
    }
}
