import java.util.*;

/**
 * Created on:  Oct 12, 2021
 * Ref: https://leetcode.com/problems/minimum-interval-to-include-each-query/
 */
public class MinimumIntervalToIncludeEachQuery {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minInterval(new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}}, new int[]{2, 3, 4, 5})));
        System.out.println(Arrays.toString(minInterval_rev1(new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}}, new int[]{2, 3, 4, 5})));
    }

    static public int[] minInterval_rev1(int[][] intervals, int[] queries) {
//        Sort the input based in the start and end time.
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        // 0: time, 1: index
        int len = queries.length;
        List<int[]> queriesList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            queriesList.add(new int[]{queries[i], i});
        }
        Collections.sort(queriesList, (q1, q2) -> Integer.compare(q1[0], q2[0]));
        int[] result = new int[len];
        int idx = 0;
//        Create a heap with all the intervals, sorted based on ascending order of size.
//          [size of interval, end of interval]
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[0], i2[0]));
        for (int i = 0; i < len; i++) {
            int queryTime = queriesList.get(i)[0], queryIdx = queriesList.get(i)[1];
//            Check if there is any interval that can be added to queue, that happens before the query Time.
            while (idx < intervals.length && intervals[idx][0] <= queryTime) {
                int start = intervals[idx][0], end = intervals[idx][1];
                pq.add(new int[]{end - start + 1, end});
                idx++;
            }
//            Check if there is any interval that is in the queue that is ended before the query time.
            while (!pq.isEmpty() && pq.peek()[1] < queryTime) pq.poll();
            result[queryIdx] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return result;
    }

    static public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<Action> pq = new PriorityQueue<>((a1, a2) -> Integer.compare(a1.idx, a2.idx));
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            pq.add(new Action(start, interval, true));
            pq.add(new Action(end + 1, interval, false));
        }
        TreeMap<Integer, Integer> map = buildMap(pq);
        int len = queries.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            int val = queries[i];
            Integer floor = map.floorKey(val);
            result[i] = floor == null ? -1 : map.get(floor);
        }
        return result;
    }

    static TreeMap<Integer, Integer> buildMap(PriorityQueue<Action> pq) {
        TreeMap<Integer, Integer> result = new TreeMap<>();
        Set<int[]> accum = new HashSet<>();
        while (!pq.isEmpty()) {
            Action poll = pq.poll();
            if (poll.add) {
                accum.add(poll.arr);
            } else {
                accum.remove(poll.arr);
            }
            int position = poll.idx;
            int min = Integer.MAX_VALUE;
            for (int[] val : accum) {
                min = Math.min(min, dist(val));
            }
            result.put(position, min == Integer.MAX_VALUE ? -1 : min);
        }
        return result;
    }

    static int compare(int[] a, int[] b) {
        return Integer.compare(dist(a), dist(b));
    }

    static int dist(int[] val) {
        return val[1] - val[0] + 1;
    }

    static class Action {
        int idx;
        boolean add;
        int[] arr;

        Action(int idx, int[] arr, boolean add) {
            this.idx = idx;
            this.add = add;
            this.arr = arr;
        }
    }
}
