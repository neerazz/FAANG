import java.util.*;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://leetcode.com/discuss/interview-question/914249/Uber-or-Phone-or-Union-and-Intersection-of-Two-Sorted-Interval-Lists
 */

public class UnionAndIntersectionOfTwoSortedIntervalLists {

    public static void main(String[] args) {

    }

    public int[][] intersectionOfTwoIntervals(int[][] a, int[][] b) {
        List<int[]> result = new ArrayList<>();
        int p1 = 0, p2 = 0, l1 = a.length, l2 = b.length;
        while (p1 < l1 && p2 < l2) {
            int[] v1 = a[p1], v2 = b[p2];
            if (hasOverLap(v1, v2)) {
                result.add(getIntersections(v1, v2));
            }
            if (v1[1] < v2[1]) {
                p1++;
            } else {
                p2++;
            }
        }
        return result.toArray(new int[0][0]);
    }

    private int[] getIntersections(int[] i1, int[] i2) {
        return new int[]{Math.max(i1[0], i2[0]), Math.min(i1[0], i2[1])};
    }

    public List<int[]> mergeTwoIntervals(int[][] a, int[][] b) {
        Stack<int[]> merged = new Stack<>();
        int p1 = 0, p2 = 0, l1 = a.length, l2 = b.length;
        while (p1 < l1 && p2 < l2) {
            int[] v1 = a[p1], v2 = b[p2], cur = new int[2];
            if (hasOverLap(v1, v2)) {
                cur = getMerged(v1, v2);
            }
//            Check if the current interval has overlap with the previously inserted interval
            if (hasOverLap(merged.peek(), cur)) merged.add(getMerged(merged.pop(), cur));
            else merged.add(cur);
            if (v1[1] < v2[1]) p1++;
            else p2++;
        }
        while (p1 < l1) {
            int[] cur = a[p1++];
            if (hasOverLap(merged.peek(), cur)) merged.add(getMerged(merged.pop(), cur));
            else merged.add(cur);
        }
        while (p2 < l2) {
            int[] cur = a[p2++];
            if (hasOverLap(merged.peek(), cur)) merged.add(getMerged(merged.pop(), cur));
            else merged.add(cur);
        }
        LinkedList<int[]> result = new LinkedList<>();
        while (!merged.isEmpty()) {
            result.addFirst(merged.pop());
        }
        return result;
    }

    private int[] getMerged(int[] p1, int[] p2) {
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
