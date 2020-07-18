import java.util.PriorityQueue;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {

    }

    public static int[][] kClosest(int[][] points, int k) {
        if (points.length == k) return points;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> getDistance(p2) - getDistance(p1));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] op = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            op[i++] = pq.poll();
        }
        return op;
    }

    private static int getDistance(int[] point) {
        return (point[0] * point[0]) + (point[1] * point[1]);
    }
}
