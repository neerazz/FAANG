import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created on:  Jul 19, 2021
 * Ref : https://www.geeksforgeeks.org/closest-pair-of-points-onlogn-implementation/
 * https://medium.com/@andriylazorenko/closest-pair-of-points-in-python-79e2409fc0b2
 * <p>
 * We are given an array of n points in the plane, and the problem is to find out the closest pair of points in the array.
 * This problem arises in a number of applications.
 * <p>
 * For example, in air-traffic control, you may want to monitor planes that come too close together, since this may indicate a possible collision.
 * Recall the following formula for distance between two points p and q.
 */
public class ClosestPairOfPoints {
    public static void main(String[] args) {
        System.out.println(closest(Arrays.asList(new int[]{2, 3}, new int[]{12, 30}, new int[]{40, 50}, new int[]{5, 1}, new int[]{12, 10}, new int[]{3, 4})));
    }

    private static double closest(List<int[]> points) {
        List<int[]> pointsByX = new ArrayList<>(points);
        Collections.sort(pointsByX, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        List<int[]> pointsByY = new ArrayList<>(points);
        Collections.sort(pointsByY, (p1, p2) -> Integer.compare(p1[1], p2[1]));
        return findClosestDist(pointsByX, pointsByY, points.size());
    }

    private static double findClosestDist(List<int[]> pointsByX, List<int[]> pointsByY, int n) {
        if (n <= 3) {
            return getShortestDist(pointsByX, n);
        }
//        Find the center point by dividing a vertical line.
        int mid = n / 2;
        int[] center = pointsByY.get(mid);
        List<int[]> pointsByYLeft = pointsByY.subList(0, mid + 1);
        List<int[]> pointsByYRight = pointsByY.subList(mid + 1, n);

        List<int[]> pointsByXLeft = new ArrayList<>();
        List<int[]> pointsByXRight = new ArrayList<>();
        for (int[] point : pointsByX) {
            if (point[0] < center[0]) pointsByXLeft.add(point);
            else pointsByXRight.add(point);
        }
        double leftDist = findClosestDist(pointsByXLeft, pointsByYLeft, pointsByXLeft.size());
        double rightDist = findClosestDist(pointsByXRight, pointsByYRight, pointsByXRight.size());
        double minDist = Math.min(leftDist, rightDist);
//        Build an List strip that contains points closer than minDistance to the line passing through the center point.
//          Because Center point is on the left side, loop only the right points and find the closest to center.
        double overLappingMin = overLappingClosestDist(pointsByY, center, n, minDist);
        return Math.min(minDist, overLappingMin);
    }

    private static double overLappingClosestDist(List<int[]> points, int[] center, int n, double minDist) {
        for (int i = 0; i < n; i++) {
            double dist = dist(points.get(i), center);
            if (dist < minDist) minDist = dist;
            else break;
        }
        return minDist;
    }

    private static double getShortestDist(List<int[]> points, int n) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, dist(points.get(i), points.get(j)));
            }
        }
        return min;
    }

    private static double dist(int[] a, int[] b) {
        double x = a[0] - b[0], y = a[1] - b[1];
        return Math.sqrt(x * x + y * y);
    }
}
