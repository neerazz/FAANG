package contest1485;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 12, 2021
 * Questions:
 */

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            min = Integer.MAX_VALUE;
            getMinOperations(a, b, 0);
            System.out.println(min);
//            System.out.println(getMinOperations_bfs(a, b));
        }
    }

    static int min;

    private static void getMinOperations(long a, long b, int steps) {
        if (a == 0) {
            min = Math.min(min, steps);
        } else {
            if (b > 1) getMinOperations(Math.floorDiv(a, b), b, steps + 1);
            if (a != 0 && min > steps && b <= a) getMinOperations(a, b + 1, steps + 1);
        }
    }

    private static int getMinOperations_bfs(int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b, 0});
        visited.add(getKey(a, b));
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int v1 = poll[0], v2 = poll[1], steps = poll[2];
            if (v1 == 0) return steps;
            if (visited.add(getKey(v1 / v2, v2))) {
                queue.add(new int[]{v1 / v2, v2, steps + 1});
            }
            if (visited.add(getKey(v1, v2 + 1))) {
                queue.add(new int[]{v1, v2 + 1, steps + 1});
            }
        }
        return -1;
    }

    private static String getKey(int a, int b) {
        return String.format("%d %d", a, b);
    }
}
