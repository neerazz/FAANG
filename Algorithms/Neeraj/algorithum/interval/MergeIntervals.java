import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return intervals;
        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1] : i1[0] - i2[0]);
        int[] pre = intervals[0];
        List<int[]> op = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            int[] cur = intervals[i];
            int os = Math.max(pre[0], cur[0]), oe = Math.min(pre[1], cur[1]);
            if (os <= oe) {
//                 There is a overlap, extend previous
                pre[1] = cur[1];
            } else {
//                 No overlap
                op.add(pre);
                pre = cur;
            }
        }
        op.add(pre);
        return op.toArray(new int[0][0]);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        Collections.sort(intervals, (i1, i2) -> i1.start == i2.start ? Integer.compare(i1.end, i2.end) : Integer.compare(i1.start, i2.start));
        Interval pre = null;
        for (Interval cur : intervals) {
            if (pre != null) {
                if (hasOverLap(pre, cur)) {
                    pre.end = Math.max(pre.end, cur.end);
                } else {
                    mergedIntervals.add(pre);
                    pre = cur;
                }
            } else {
                pre = cur;
            }
        }
        return mergedIntervals;
    }

    private static boolean hasOverLap(Interval pre, Interval cur) {
        return Math.max(pre.start, cur.start) <= Math.min(pre.end, cur.end);
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
