import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RemoveCoveredIntervals {
    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}}));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (i1, i2) -> i1[0] == i2[0] ? i2[1] - i1[1] : i1[0] - i2[0]
        );
        Collections.addAll(pq, intervals);
        int[] pre = pq.poll();
        int overlap = 0, len = intervals.length;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (hasOverLap(pre, cur)) {
                overlap++;
            } else {
                pre = cur;
            }
        }
        return len - overlap;
    }

    private static boolean hasOverLap(int[] pre, int[] cur) {
        return pre[0] <= cur[0] && pre[1] >= cur[1];
    }
}
