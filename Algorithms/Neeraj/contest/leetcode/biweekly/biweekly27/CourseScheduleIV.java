package biweekly.biweekly27;

import java.util.*;

/**
 * Created on:  May 30, 2020
 * Questions: https://leetcode.com/problems/course-schedule-iv/
 */
public class CourseScheduleIV {
    public static void main(String[] args) {

    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        Map<Integer, Graph> graphs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graphs.put(i, new Graph(i));
        }
        for (int[] pre : prerequisites) {
            graphs.get(pre[0]).req.add(graphs.get(pre[1]));
            graphs.get(pre[1]).preReq++;
        }
        List<Boolean> op = new ArrayList<>();
        for (int[] query : queries) {
            String direction = query[0] + "->" + query[1];
            if (memo.containsKey(direction)) {
                op.add(memo.get(direction));
            } else {
                op.add(bfs(query[0], query[1], graphs));
            }
        }
        return op;
    }

    private Boolean bfs(int start, int end, Map<Integer, Graph> graphs) {
        if (start == end) return true;
        String dir = start + "->" + end;
        if (memo.containsKey(dir)) return memo.get(dir);
        boolean dependent = false;
        Set<Integer> visited = new HashSet<>();
        Queue<Graph> queue = new LinkedList<>();
        queue.add(graphs.get(start));
        visited.add(start);
        while (!queue.isEmpty()) {
            Graph poll = queue.poll();
            if (poll.val == end) {
                dependent = true;
                break;
            }
            for (Graph dep : poll.req) {
                if (!visited.contains(dep.val)) {
                    queue.add(dep);
                    visited.add(dep.val);
                }
            }
        }
        memo.put(dir, dependent);
        return dependent;
    }

    Map<String, Boolean> memo = new HashMap<>();

    static class Graph {
        int val;
        int preReq = 0;
        List<Graph> req = new ArrayList<>();

        public Graph(int val) {
            this.val = val;
        }
    }
}
