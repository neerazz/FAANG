import java.util.Arrays;

/**
 * Created on:  Jul 08, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/qVV79nGVgAG
 */

public class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1.start == i2.start ? Integer.compare(i1.end, i2.end) : Integer.compare(i1.start, i2.start));
        Interval pre = null;
        for (Interval cur : intervals) {
            if (pre != null && Math.max(pre.start, cur.start) < Math.min(pre.end, cur.end)) {
                return false;
            }
            pre = cur;
        }
        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
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
