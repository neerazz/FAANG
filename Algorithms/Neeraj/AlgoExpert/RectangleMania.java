import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 04, 2021
 * Questions: https://www.algoexpert.io/questions/Rectangle%20Mania
 */

public class RectangleMania {

    public static void main(String[] args) {
        System.out.println(rectangleMania(buildPoint(new int[][]{{0, 0}, {0, 1}, {1, 0}, {2, 1}, {1, 3}, {3, 3}, {0, -4}, {3, -5}, {1, -3}, {3, -2}, {-1, 0}, {-10, 0}, {-1, -1}, {2, -2}})) + " = 0");
        System.out.println(rectangleMania(buildPoint(new int[][]{{0, 0}, {0, 1}, {1, 1}, {1, 0}, {2, 1}, {2, 0}, {3, 1}, {3, 0}, {1, 3}, {3, 3}, {0, -4}, {3, -4}})));
    }

    private static Point[] buildPoint(int[][] points) {
        Point[] op = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            op[i] = new Point(points[i][0], points[i][1]);
        }
        return op;
    }

    public static int rectangleMania(Point[] coords) {
        Arrays.sort(coords, (c1, c2) -> c1.x == c2.x ? c1.y - c2.y : c1.x - c2.x);
        Map<Integer, List<Point>> mapX = new HashMap<>(), mapY = new HashMap<>();
        int count = 0;
        Set<String> points = new HashSet<>();
        for (Point cur : coords) {
            if (mapX.containsKey(cur.x) && mapY.containsKey(cur.y)) {
                for (Point x : mapX.getOrDefault(cur.x, new ArrayList<>())) {
                    for (Point y : mapY.getOrDefault(cur.y, new ArrayList<>())) {
                        int fourX = y.x, fourY = x.y;
                        if (points.contains(String.format("%d, %d", fourX, fourY))) count++;
                    }
                }
            }
            mapX.computeIfAbsent(cur.x, val -> new ArrayList<>()).add(cur);
            mapY.computeIfAbsent(cur.y, val -> new ArrayList<>()).add(cur);
            points.add(String.format("%d, %d", cur.x, cur.y));
        }
        return count;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "" + x + ", " + y;
        }
    }
}
