import java.util.*;

/**
 * Created on:  Jul 08, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/xVlyyv3rR93
 */

public class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (List<Interval> emp : schedule) {
            min = Math.min(min, emp.get(0).start);
            max = Math.max(max, emp.get(emp.size() - 1).end);
        }
        Queue<List<Interval>> queue = new LinkedList<>();
        for (List<Interval> emp : schedule) {
            List<Interval> freeTime = new ArrayList<>();
            Interval pre = null;
            for (Interval cur : emp) {
                if (pre == null && min < cur.start) {
                    freeTime.add(new Interval(min, cur.start));
                }
                if (pre != null && pre.end < cur.start) {
                    freeTime.add(new Interval(pre.end, cur.start));
                }
                pre = cur;
            }
            if (pre != null && pre.end < max) {
                freeTime.add(new Interval(pre.end, max));
            }
            if (freeTime.isEmpty()) return new ArrayList<>();
            queue.add(freeTime);
        }
        while (queue.size() >= 2) {
            List<Interval> overLap = findOverLap(queue.poll(), queue.poll());
            if (overLap.isEmpty()) return new ArrayList<>();
            queue.add(overLap);
        }
        return queue.isEmpty() ? new ArrayList<>() : queue.poll();
    }

    static List<Interval> findOverLap(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();
        int i1 = 0, i2 = 0, l1 = list1.size(), l2 = list2.size();
        while (i1 < l1 && i2 < l2) {
            Interval v1 = list1.get(i1), v2 = list2.get(i2);
            int start = Math.max(v1.start, v2.start);
            int end = Math.min(v1.end, v2.end);
            if (start < end) {
                result.add(new Interval(start, end));
            }
            if (v1.end <= v2.end) {
                i1++;
            } else {
                i2++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
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
