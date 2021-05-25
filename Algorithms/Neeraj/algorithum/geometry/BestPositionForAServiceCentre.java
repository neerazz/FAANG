/**
 * Created on:  May 23, 2021
 * Questions: https://leetcode.com/problems/best-position-for-a-service-centre/
 */

public class BestPositionForAServiceCentre {

    public static void main(String[] args) {
        System.out.println(getMinDistSum(new int[][]{{0, 1}, {1, 0}, {1, 2}, {2, 1}}) + " = 4.00000");
    }

    //    https://leetcode.com/problems/best-position-for-a-service-centre/discuss/1100761/Java-Define-Search-Space-Rectangle-and-Start-with-mid-point-4-ms
    public static double getMinDistSum(int[][] positions) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] point : positions) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            minY = Math.min(minY, point[1]);
            maxY = Math.max(maxY, point[1]);
        }
        double xCenter = minX + (double) (maxX - minX) / 2;
        double yCenter = minY + (double) (maxY - minY) / 2;
//        Try moving the point center point closer to all the other points and get the distance.
        double variation = Math.max(maxX - minX, maxY - minY);
        double dist = dists(xCenter, yCenter, positions);
        int[] dir = {-1, 1};
        while (variation > 0.00001) {
            boolean found = false;
            for (int xDir : dir) {
                for (int yDir : dir) {
//                    Keep moving the center points and calculate the distance.
                    double newDist = dists(xCenter + xDir * variation, yCenter + yDir * variation, positions);
                    if (dist > newDist) {
                        dist = newDist;
                        xCenter = xCenter + xDir * variation;
                        yCenter = yCenter + yDir * variation;
                        found = true;
                        System.out.println("Center = " + String.format("[%f,%f]", xCenter, yCenter));
                    }
                }
            }
            variation /= found ? 1 : 2;
        }
        return dist;
    }

    private static double dists(double xCenter, double yCenter, int[][] positions) {
        double dist = 0;
        for (int[] point : positions) {
            dist += dist(xCenter, yCenter, point[0], point[1]);
        }
        return dist;
    }

    private static double dist(double xCenter, double yCenter, int x, int y) {
        double xDist = xCenter - x, yDist = yCenter - y;
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }
}
