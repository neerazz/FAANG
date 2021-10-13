import java.util.*;

/**
 * Created on:  Aug 12, 2021
 * Ref :
 */
public class ValidSquare {
    public static void main(String[] args) {

    }

    public static boolean validSquare_rev1(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isSquare(p1, p2, p3, p4);
    }

    static boolean isSquare(int[]... points) {
        Map<Double, Integer> map = new HashMap<>();
        double min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;
                double dist = dist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0) + 1);
                min = Math.min(min, dist);
                max = Math.max(max, dist);
            }
        }
        return map.size() == 2 && map.get(min) == 8 && map.get(max) == 4;
    }

    static double dist(int[] a, int[] b) {
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return Math.sqrt(x * x + y * y);
    }

    public boolean validSquare(int[]... points) {
        Map<Double, List<String>> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;
                if (Arrays.equals(points[i], points[j])) return false;
                double dist = dist(points[i], points[j]);
                map.computeIfAbsent(dist, val -> new ArrayList<>()).add(String.format("%d -> %d", i, j));
            }
        }
        Set<Integer> req = new HashSet<>();
        req.add(8);
        req.add(4);
        if (map.size() != 2) return false;
        for (List<String> line : map.values()) {
            req.remove(line.size());
        }
        return req.isEmpty();
    }
}
