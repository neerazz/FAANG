import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Aug 10, 2021
 * Ref : https://leetcode.com/problems/range-module/
 */
public class RangeModuleImpl {
    /*
     * rrrrrrrr------
     * 123456789012345
     * */
    public static void main(String[] args) {
        RangeModule obj = new RangeModule();
        obj.addRange(6, 8);
        obj.removeRange(7, 8);
        obj.removeRange(8, 9);
        obj.addRange(8, 9);
        obj.removeRange(1, 3);
        obj.addRange(1, 8);
        System.out.println(obj.queryRange(2, 4));
        System.out.println(obj.queryRange(2, 9));
        System.out.println(obj.queryRange(4, 6));
    }

    static class RangeModule {
        List<Interval> ranges;

        public RangeModule() {
            ranges = new ArrayList<>();
        }

        public void addRange(int left, int right) {
            List<Interval> temp = new ArrayList<>();
            int i = 0, len = ranges.size();
//            Add all the ranges that are less than the left
            while (i < len && ranges.get(i).end < left) {
                temp.add(ranges.get(i++));
            }
//            See if you can merge with any ranges.
            while (i < len && ranges.get(i).start <= right) {
                left = Math.min(left, ranges.get(i).start);
                right = Math.max(right, ranges.get(i).end);
                i++;
            }
//            Add the merged interval.
            temp.add(new Interval(left, right));
//            Add all the ranges that are after the right.
            while (i < len) {
                temp.add(ranges.get(i++));
            }
            ranges = temp;
        }

        public boolean queryRange(int left, int right) {
            return ranges.stream().anyMatch(range -> range.start <= left && right <= range.end);
        }

        public void removeRange(int left, int right) {
            int len = ranges.size(), i = 0;
            List<Interval> temp = new ArrayList<>();
//            Add every thing that comes before the range.
            while (i < len && ranges.get(i).end < left) {
                temp.add(ranges.get(i++));
            }
//            Check for overlapping and delete ranges.
            while (i < len && ranges.get(i).start < right) {
                Interval cur = ranges.get(i++);
                if (cur.start < left) {
                    temp.add(new Interval(cur.start, left));
                }
                if (right < cur.end) {
                    temp.add(new Interval(Math.max(right, cur.start), cur.end));
                }
            }
//            Add all the ranges that are after the right.
            while (i < len) {
                temp.add(ranges.get(i++));
            }
            ranges = temp;
        }
    }

    static class Interval {
        int start, end;

        Interval(int start, int end) {
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
