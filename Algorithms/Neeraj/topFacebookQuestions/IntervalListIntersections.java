import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {
    public static void main(String[] args) {

    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int p1 = 0, p2 = 0, l1 = A.length, l2 = B.length;
        List<int[]> op = new ArrayList<>();

        while (p1 < l1 && p2 < l2) {
            int[] v1 = A[p1], v2 = B[p2];
            int start = Math.max(v1[0], v2[0]), end = Math.min(v1[1], v2[1]);
            if (start <= end) {
                op.add(new int[]{start, end});
            }
            if (v1[1] == v2[1]) {
                p1++;
                p2++;
            } else if (v1[1] < v2[1]) p1++;
            else p2++;
        }

        return op.toArray(new int[0][0]);
    }
}
