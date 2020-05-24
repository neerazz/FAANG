import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  May 23, 2020
 * Questions: https://leetcode.com/problems/interval-list-intersections/
 */
public class IntervalListIntersections {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                intervalIntersection(
                        new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                        new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}
                )));
        System.out.println(Arrays.deepToString(
                intervalIntersection(
                        new int[][]{{3, 5}, {9, 20}},
                        new int[][]{{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}}
                )));
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int p1 = 0, p2 = 0, l1 = A.length, l2 = B.length;
        List<int[]> list = new ArrayList<>();
        while (p1 < l1 && p2 < l2) {
            int start = Math.max(A[p1][0], B[p2][0]);
            int end = Math.min(A[p1][1], B[p2][1]);
            if (start <= end) {
                list.add(new int[]{start, end});
            }
//            Which ever is ending first move that pointer.
            if (A[p1][1] == B[p2][1]) {
                p1++;
                p2++;
            } else if (A[p1][1] < B[p2][1]) {
                p1++;
            } else {
                p2++;
            }
        }
        return list.toArray(new int[0][0]);
    }
}
