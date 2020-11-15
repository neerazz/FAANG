import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://leetcode.com/discuss/interview-question/914249/Uber-or-Phone-or-Union-and-Intersection-of-Two-Sorted-Interval-Lists
 */

public class UnionAndIntersectionOfTwoSortedIntervalLists {

    public static void main(String[] args) {

    }

    public List<int[]> mergeTwoList(int[][] i1, int[][] i2) {
        Stack<int[]> merged = new Stack<>();
        Queue<int[]> interval1 = new LinkedList<>(), interval2 = new LinkedList<>();
        for (int[] cur : i1) interval1.add(cur);
        for (int[] cur : i2) interval2.add(cur);
        while (!interval1.isEmpty() && !interval2.isEmpty()) {
            int[] p1 = interval1.peek(), p2 = interval2.peek();
            int[] cur = new int[2];
            if (hasOverLap(p1, p2)) {
//                Merge the p1 and p2 intervals.
                cur = merge(interval1.poll(), interval1.poll());
            } else if (p1[0] < p2[0]) {
                cur = interval1.poll();
            } else {
                cur = interval2.poll();
            }
//            Check if the current interval has overlap with the previously inserted interval
            if (hasOverLap(merged.peek(), cur)) {
                merged.add(merge(merged.pop(), cur));
            } else {
                merged.add(cur);
            }
        }
        while(!interval1.isEmpty()){
            if (hasOverLap(merged.peek(), interval1.peek())) {
                merged.add(merge(merged.pop(), interval1.poll()));
            } else {
                merged.add(interval1.poll());
            }
        }
        while(!interval2.isEmpty()){
            if (hasOverLap(merged.peek(), interval2.peek())) {
                merged.add(merge(merged.pop(), interval2.poll()));
            } else {
                merged.add(interval2.poll());
            }
        }
        return new ArrayList<>(merged);
    }

    private int[] merge(int[] p1, int[] p2) {
        return new int[]{Math.min(p1[0], p2[0]), Math.max(p1[1], p2[1])};
    }

    private boolean hasOverLap(int[] i1, int[] i2) {
        if (i1[0] > i2[0]) return hasOverLap(i2, i1);
//       Assuming i1 interval starts first.
        return Math.max(i1[0], i2[0]) <= Math.min(i1[1], i2[1]);
    }

    public List<Integer> mergeTwoList(List<Integer> l1, List<Integer> l2) {
        int i1 = 0, i2 = 0;
        List<Integer> merged = new ArrayList<>();
        while (i1 < l1.size() && i2 < l2.size()) {
            int v1 = l1.get(i1), v2 = l2.get(i2);
            if (v1 < v2) {
                merged.add(v1);
                i1++;
            } else {
                merged.add(v2);
                i2++;
            }
        }
        while (i1 < l1.size()) {
            merged.add(l1.get(i1++));
        }
        while (i2 < l2.size()) {
            merged.add(l2.get(i2++));
        }
        return merged;
    }

    public List<Integer> intersectionOfTwoList(List<Integer> l1, List<Integer> l2) {
        int i1 = 0, i2 = 0;
        List<Integer> intersection = new ArrayList<>();
        while (i1 < l1.size() && i2 < l2.size()) {
            int v1 = l1.get(i1), v2 = l2.get(i2);
            if (v1 == v2) {
                intersection.add(v1);
                i1++;
                i2++;
            } else if (v1 < v2) {
                i1++;
            } else if (v1 > v2) {
                i2++;
            }
        }
        return intersection;
    }
}
