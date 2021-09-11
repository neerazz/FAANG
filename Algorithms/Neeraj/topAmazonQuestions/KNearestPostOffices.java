import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-questions#k
 */

public class KNearestPostOffices {

    public static void main(String[] args) {
        nearestPostOffice(new int[]{0, 0}, new int[][]{{-16, 5}, {-1, 2}, {4, 3}, {10, -2}, {0, 3}, {-5, -9}}, 3).forEach(val -> System.out.println(Arrays.toString(val)));
    }

    private static List<int[]> nearestPostOffice(int[] cur, int[][] locs, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p2[2], p1[2]));
//        0: x, 1: y, 2 : dist
        for (int[] loc : locs) {
            double dist = getDistance(cur, loc);
            pq.add(new double[]{loc[0], loc[1], dist});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream().map(point -> new int[]{(int) point[0], (int) point[1]}).collect(Collectors.toList());
    }

    private static double getDistance(int[] a, int[] b) {
        int x = a[0] - b[0], y = a[1] - b[1];
        return Math.sqrt(x * x + y * y);
    }
}
