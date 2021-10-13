import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  Oct 12, 2021
 * Ref: https://leetcode.com/problems/maximum-number-of-visible-points/
 */
public class MaximumNumberOfVisiblePoints {

    public static void main(String[] args) {
        System.out.println(visiblePoints(toList(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {1, 2}, {2, 1}}), 0, toList(new int[]{1, 1})));
    }

    static List<List<Integer>> toList(int[][] nums) {
        return Arrays.stream(nums).map(MaximumNumberOfVisiblePoints::toList).collect(Collectors.toList());
    }

    static List<Integer> toList(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }


    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int duplicate = 0;
        for (List<Integer> point : points) {
            if (equal(point, location)) {
//                There is a point same as location, that is an edge case.
                duplicate++;
            } else {
                Double curAngle = angle(point, location);
                angles.add(curAngle);
            }
        }
        Collections.sort(angles);
        int p1 = 0, p2 = 0, max = duplicate, len = angles.size();
//        Add 360 so that you handle the edge case.
//          https://leetcode.com/problems/maximum-number-of-visible-points/discuss/877845/JAVA-Sliding-Window/1067045
        for (int i = 0; i < len; i++) {
            angles.add(angles.get(i) + 360);
        }
        while (p2 < 2 * len) {
            while (angles.get(p2) - angles.get(p1) > angle) {
//                If the starting and the ending point has angles more than the allowed range, then reduce the slide.
                p1++;
            }
            int curMax = p2 - p1 + 1;
            max = Math.max(max, curMax + duplicate);
            p2++;
        }
        return max;
    }

    private static boolean equal(List<Integer> a, List<Integer> b) {
        return a.size() == b.size() && a.get(0).equals(b.get(0)) && a.get(1).equals(b.get(1));
    }

    static Double angle(List<Integer> a, List<Integer> b) {
        int x = a.get(0) - b.get(0);
        int y = a.get(1) - b.get(1);
        return Math.atan2(x, y) * (180 / Math.PI);
    }
}
