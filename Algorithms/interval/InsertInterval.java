import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jul 08, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/3jKlyNMJPEM
 */

public class InsertInterval {

    public static List<Interval> insert_2(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0, len = intervals.size();
//        Take all teh intervals before the new Interval.
        while (i < len && isBefore(intervals.get(i), newInterval)) {
            result.add(intervals.get(i++));
        }
//        Take all the intervals that are overlapping with newInterval
        while (i < len && hasOverLap(intervals.get(i), newInterval)) {
            Interval cur = intervals.get(i++);
            newInterval.start = Math.min(newInterval.start, cur.start);
            newInterval.end = Math.max(newInterval.end, cur.end);
        }
        result.add(newInterval);
//        Add all the remaining intervals
        while (i < len) {
            result.add(intervals.get(i++));
        }
        return result;
    }

    private static boolean isBefore(Interval a, Interval b) {
        return a.end < b.start;
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> temp = new ArrayList<>();
        boolean isMerged = false;
        for (Interval cur : intervals) {
            if (isBeforeWithOverLap(newInterval, cur)) {
                isMerged = true;
                temp.add(newInterval);
            }
            temp.add(cur);
        }
        if (!isMerged) temp.add(newInterval);
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval pre = null;
        for (Interval cur : temp) {
            if (pre == null) {
                pre = cur;
                continue;
            }
            if (hasOverLap(pre, cur)) {
                pre = expand(pre, cur);
            } else {
                mergedIntervals.add(pre);
                pre = cur;
            }
        }
        mergedIntervals.add(pre);
        return mergedIntervals;
    }

    private static boolean isBeforeWithOverLap(Interval a, Interval b) {
        return a.start < b.start || (a.start == b.start && a.end <= b.end);
    }

    private static Interval expand(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }

    private static boolean hasOverLap(Interval a, Interval b) {
        return Math.max(a.start, b.start) <= Math.min(a.end, b.end);
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert_2(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert_2(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert_2(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
