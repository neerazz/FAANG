import java.util.PriorityQueue;

/**
 * Created on:  Oct 10, 2020
 * Questions: https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3490/
 */

public class MinimumNumberOfArrowsToBurstBalloons {

    public static void main(String[] args) {
//        System.out.println(findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[0] == p2[0] ? Integer.compare(p1[1], p2[1]) : Integer.compare(p1[0], p2[0]));
        for (int[] point : points) {
            pq.add(point);
        }
        int count = 0;
        int[] pre = pq.poll();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (hasOverLap(pre, cur)) {
                pre = new int[]{Math.max(pre[0], cur[0]), Math.min(pre[1], cur[1])};
            } else {
                count++;
                pre = cur;
            }
        }
        count++;
        return count;
    }

    private static boolean hasOverLap(int[] a, int[] b) {
        return b[0] <= a[1];
    }
}
