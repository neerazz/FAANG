import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  May 24, 2021
 * Questions: https://leetcode.com/problems/number-of-boomerangs/
 */

public class NumberOfBoomerangs {

    public static void main(String[] args) {

    }

    public static int numberOfBoomerangs(int[][] points) {
        int count = 0, len = points.length;
        for (int i = 0; i < len; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                double dist = dist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
            }
            for (int pair : map.values()) {
                count += pair * (pair - 1);
            }
        }
        return count;
    }

    static double dist(int[] p1, int[] p2) {
        double x = p1[0] - p2[0], y = p1[1] - p2[1];
//        return Math.sqrt(x * x + y * y);
        return x * x + y * y;
    }
}
