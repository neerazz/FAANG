package weekly.weekly189;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  May 16, 2020
 * Questions: https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard
 */
public class MaximumNumberOfDartsInsideOfACircularDartboard {
    public static void main(String[] args) {
        System.out.println("******************************* Method 1 ******************************");
        System.out.println(numPoints(new int[][]{{-2, 0}, {2, 0}, {0, 2}, {0, -2}}, 2) + " should be [4]");
        System.out.println(numPoints(new int[][]{{-3, 0}, {3, 0}, {2, 6}, {5, 4}, {0, 9}, {7, 8}}, 5) + " should be [5]");
        System.out.println(numPoints(new int[][]{{-2, 0}, {2, 0}, {0, 2}, {0, -2}}, 1) + " should be [1]");
        System.out.println(numPoints(new int[][]{{1, 2}, {3, 5}, {1, -1}, {2, 3}, {4, 1}, {1, 3}}, 2) + " should be [4]");
        System.out.println(numPoints(new int[][]{{-5, 1}, {-3, -1}, {-1, 2}, {1, 4}, {-3, 0}}, 4) + " should be [5]");
        System.out.println(numPoints(new int[][]{{2, -3}, {-5, 1}, {-3, -2}, {-1, -4}, {-4, -5}, {-2, -2}, {4, 1}}, 3) + " should be [4]");

        System.out.println("******************************* Method 2 ******************************");
        System.out.println(numPoints_rev1(new int[][]{{-2, 0}, {2, 0}, {0, 2}, {0, -2}}, 2) + " should be [4]");
        System.out.println(numPoints_rev1(new int[][]{{-3, 0}, {3, 0}, {2, 6}, {5, 4}, {0, 9}, {7, 8}}, 5) + " should be [5]");
        System.out.println(numPoints_rev1(new int[][]{{-2, 0}, {2, 0}, {0, 2}, {0, -2}}, 1) + " should be [1]");
        System.out.println(numPoints_rev1(new int[][]{{1, 2}, {3, 5}, {1, -1}, {2, 3}, {4, 1}, {1, 3}}, 2) + " should be [4]");
        System.out.println(numPoints_rev1(new int[][]{{-5, 1}, {-3, -1}, {-1, 2}, {1, 4}, {-3, 0}}, 4) + " should be [5]");
        System.out.println(numPoints_rev1(new int[][]{{2, -3}, {-5, 1}, {-3, -2}, {-1, -4}, {-4, -5}, {-2, -2}, {4, 1}}, 3) + " should be [4]");
    }

    public static int numPoints_rev1(int[][] p, int r) {
        int len = p.length, max = 1;
        double[][] points = new double[len][2];
        for (int i = 0; i < len; i++) {
            points[i] = new double[]{p[i][0], p[i][1]};
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                double[] center = getCenter_rev1(points[i], points[j], r);
                if (center.length == 2 && !Double.isNaN(center[0]) && !Double.isNaN(center[1])) {
                    int cur = 2;
                    for (int k = 0; k < len; k++) {
                        if (k != i && k != j && inCircle(center, points[k], r)) {
                            cur++;
                        }
                    }
                    max = Math.max(cur, max);
                }
            }
        }
        return max;
    }

    private static double[] getCenter_rev1(double[] p1, double[] p2, int r) {
        double distance = getDistance(p1, p2);
        if (distance > 2 * r) {
            return new double[0];
        }
        double[] mid = {(p1[0] + p2[0]) / 2, (p1[1] + p2[1]) / 2};
        double distanceFromMid = Math.sqrt(Math.pow(r, 2) - (distance / 2) * (distance / 2));
        double angle = Math.atan2(p1[0] - p2[0], p2[1] - p1[1]);
        return new double[]{mid[0] + distanceFromMid * Math.cos(angle), mid[1] + distanceFromMid * Math.sin(angle)};
    }

    public static int numPoints(int[][] points, int r) {
//        Converting the points to double so that center calculation will be done with precisions.
        List<double[]> nps = Arrays.stream(points).map(point -> new double[]{(double) point[0], (double) point[1]}).collect(Collectors.toList());
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
//                Find the center of all the points.
//                double[] center = getCenter(nps.get(i), nps.get(j), (double) r);
                double[] center = getCenter_2(nps.get(i), nps.get(j), r);
                if (center.length == 2 && !Double.isNaN(center[0]) && !Double.isNaN(center[1])) {
//                    Since the current center already have two points in it, initialize the current value to 2.
                    int cur = 2;
                    for (int k = 0; k < points.length; k++) {
//                        For every point (except i & j, because center covers i & j) in the given input.
//                          Find if it is inside the circle.
                        if (k != i && k != j && inCircle(nps.get(k), center, r)) {
                            cur++;
                        }
                    }
                    max = Math.max(max, cur);
                }
            }
        }
        return max;
    }

    /**
     * Finding center of a circle's with given two diameter points can three cases:
     * 1. Both the points are same so there can be infinite circles formed.
     * 2. There can be two circles formed.
     * (Imagine drawing a line on two points, so you can have two circles that passes that line. One the actual cirle and then the mirror image of that circle.)
     * 3. Only one circle can be formed. (When the two points are exactly at 2*r distance.)
     * Considering only the 2nd and third case, find all the possible points that are in that circle.
     */

    private static double[] getCenter(double[] p1, double[] p2, double r) {
//        if two points are very far. Then return empty array
        double distanceBetweenTwoPoints = getDistance(p1, p2);
//        The maximum distance between the points must be below the length of the diameter.
        if (distanceBetweenTwoPoints > 2 * r) {
            return new double[0];
        }
        double[] center = new double[2];
        double[] mid = {(p1[0] + p2[0]) / 2, (p1[1] + p2[1]) / 2};
//        There is a right angle triangle formed, with center, p1, and mid point.
//        According to pathogens theorem r^2 = a^2 + b^2. (Square of length of distanceBetweenTwoPoints = sum of squares of other two sides)
//        We know two distance's:
//          1. p1 to center. (That is the radius) (Which also is know as distanceBetweenTwoPoints in a right angle triangle)
//          2. p1 to mid. (a) (That is one side of the triangle, we can divide the distance between two points by 2)
//        The length of other side (b) = sqrt(r^2 - a^2);
        double a = distanceBetweenTwoPoints / 2;
        double b = Math.sqrt(Math.pow(r, 2) - Math.pow(a, 2));
//         Center is "b" distance from mid. There can be two center points that can be formed.
//          If we consider x and y as the deviation angle of center from mid point.
//          x = b * (p1[0] - p2[0])/distanceBetweenTwoPoints & (p1[0] - p2[0])/distanceBetweenTwoPoints -> Gives the x-axis angle from mid.
//          y = b * (p1[1] - p2[1])/distanceBetweenTwoPoints
        double x = b * (p1[0] - p2[0]) / distanceBetweenTwoPoints, y = b * (p1[1] - p2[1]) / distanceBetweenTwoPoints;
//        There can be two centers, (mid[0]-x, mid[1]+y) & (mid[0]+x, mid[1]-y)
//          But we are going to consider only one of the center.
        center[0] = mid[0] - x;
        center[1] = mid[1] + y;
        return center;
    }

    private static double[] getCenter_2(double[] a, double[] b, double r) {
        double[] mid = new double[2];
        double[] res = new double[2];
        mid[0] = (a[0] + b[0]) / 2;
        mid[1] = (a[1] + b[1]) / 2;
        double angle = Math.atan2(a[0] - b[0], b[1] - a[1]);
        double d = Math.sqrt(r * r - Math.pow(getDistance(a, mid), 2));
        res[0] = mid[0] + d * Math.cos(angle);
        res[1] = mid[1] + d * Math.sin(angle);
        return res;
    }

    private static boolean inCircle(double[] point, double[] center, int r) {
        double dist = getDistance(point, center);
        return dist <= r;
    }

    private static double getDistance(double[] p1, double[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }
}
