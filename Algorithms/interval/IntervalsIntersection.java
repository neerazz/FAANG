import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jul 08, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/JExVVqRAN9D
 */

public class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> result = new ArrayList<>();
        int i1 = 0, i2 = 0, l1 = arr1.length, l2 = arr2.length;
        while (i1 < l1 && i2 < l2) {
            Interval v1 = arr1[i1], v2 = arr2[i2];
            if (Math.max(v1.start, v2.start) <= Math.min(v1.end, v2.end)) {
                result.add(new Interval(Math.max(v1.start, v2.start), Math.min(v1.end, v2.end)));
            }
            if (v1.end <= v2.end) {
                i1++;
            } else {
                i2++;
            }
        }
        return result.toArray(new Interval[0]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[]{new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)};
        Interval[] input2 = new Interval[]{new Interval(2, 3), new Interval(5, 7)};
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[]{new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)};
        input2 = new Interval[]{new Interval(5, 10)};
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
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
