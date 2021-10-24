import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created on:  Jul 16, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/gkkmqXO6zrY
 */

public class NextInterval {

    public static int[] findNextInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        int len = intervals.length;
        TreeMap<Integer, TreeSet<Integer>> startingMap = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            int start = intervals[i].start;
            startingMap.computeIfAbsent(start, val -> new TreeSet<>()).add(i);
        }
        for (int i = 0; i < len; i++) {
            int end = intervals[i].end;
            Integer key = startingMap.ceilingKey(end);
            if (key == null) {
                result[i] = -1;
            } else {
                Integer idx = startingMap.get(key).higher(i);
                result[i] = idx == null ? -1 : idx;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{new Interval(2, 3), new Interval(3, 4), new Interval(5, 6)};
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[]{new Interval(3, 4), new Interval(1, 5), new Interval(4, 6)};
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }

    static class Interval {
        int start = 0;
        int end = 0;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
