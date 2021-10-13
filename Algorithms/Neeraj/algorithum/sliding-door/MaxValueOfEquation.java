import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created on:  Oct 12, 2021
 * Ref: https://leetcode.com/problems/max-value-of-equation/
 */
public class MaxValueOfEquation {
    public static void main(String[] args) {

    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        Comparator<int[]> order = (v1, v2) -> Integer.compare(diff(v2), diff(v1));
        PriorityQueue<int[]> pq = new PriorityQueue<>(order);
        int len = points.length, p1 = 0, p2 = 0;
        int max = Integer.MIN_VALUE;
        while (p2 < len) {
            int[] cur = points[p2];
            // check if the p2 val and p1 value is greater than k then reduce the slide.
            while (p1 <= p2 && points[p2][0] - points[p1][0] > k) {
                pq.remove(points[p1++]);
            }
            if (!pq.isEmpty()) {
                // get the value, and check against best
                int[] top = pq.peek();
                int curVal = diff(top) + cur[0] + cur[1];
                max = Math.max(max, curVal);
            }
            // Expand the slide
            pq.add(cur);
            p2++;
        }
        return max;
    }

    static int diff(int[] val) {
        return val[1] - val[0];
    }
}
