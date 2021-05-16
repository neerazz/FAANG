package biweekly.biweekly38;

import java.util.*;

/**
 * Created on:  Oct 31, 2020
 * Questions:
 */

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public static void main(String[] args) {

    }

    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);
        int pre = points[0][0], max = 0;
        for (int[] point : points) {
            max = Math.max(max, point[0] - pre);
            pre = point[0];
        }
        return max;
    }
}
