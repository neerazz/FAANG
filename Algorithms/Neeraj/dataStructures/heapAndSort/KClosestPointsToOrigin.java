import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created on:  May 30, 2020
 * Questions: https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {

    }

    //    Time: NLogN
    public static int[][] kClosest_short_Code(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> Integer.compare((o1[0] * o1[0]) + (o1[1] * o1[1]), (o2[0] * o2[0]) + (o2[1] * o2[1])));
        return Arrays.copyOfRange(points, 0, K);
    }

    //    Time: NLogK
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Origin> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.dist, o1.dist));
        for (int[] p : points) {
            queue.add(new Origin(p[0], p[1]));
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int[][] op = new int[queue.size()][2];
        int index = 0;
        while (!queue.isEmpty()) {
            Origin poll = queue.poll();
            op[index++] = new int[]{poll.x, poll.y};
        }
        return op;
    }

    static class Origin {
        int x;
        int y;
        int dist;

        public Origin(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = (x * x) + (y * y);
        }
    }
}
