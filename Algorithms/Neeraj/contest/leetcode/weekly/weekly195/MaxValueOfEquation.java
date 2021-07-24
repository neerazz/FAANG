package weekly.weekly195;

import java.util.*;

/**
 * Created on:  Jun 27, 2020
 * Questions:
 * https://leetcode.com/problems/max-value-of-equation
 */
public class MaxValueOfEquation {
    public static void main(String[] args) {

    }

    /**
     * Because xi < xj,
     * yi + yj + |xi - xj| = (yi - xi) + (yj + xj)
     * So we only need to find out the maximum yi - xi.
     * To find out the maximum element in a sliding window,
     */
    public static int findMaxValueOfEquation_optimal(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> Integer.compare(v2[1] - v2[0], v1[1] - v1[0]));
        int max = Integer.MIN_VALUE;
        for (int[] point : points) {
//            If the difference between the top element in the pq and the current element is greater, that element should not be in the window range.
            while (!pq.isEmpty() && (point[0] - pq.peek()[0]) > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                max = Math.max(max, point[0] - pq.peek()[0] + point[1] + pq.peek()[1]);
            }
            pq.add(point);
        }
        return max;
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        int len = points.length, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && Math.abs(points[i][0] - points[j][0]) <= k) {
                    max = Math.max(max, points[i][1] + points[j][1] + Math.abs(points[i][0] - points[j][0]));
                }
            }
        }
        return max;
    }
}
