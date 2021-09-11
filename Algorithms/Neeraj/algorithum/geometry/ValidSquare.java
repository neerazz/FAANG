import java.util.*;

/**
 * Created on:  Aug 12, 2021
 * Ref :
 */
public class ValidSquare {
    public static void main(String[] args) {

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
            // System.out.println("Line : " + line);
            req.remove(line.size());
        }
        return req.isEmpty();
    }

    double dist(int[] a, int[] b) {
        int x = a[0] - b[0], y = a[1] - b[1];
        return Math.sqrt(x * x + y * y);
    }
}
