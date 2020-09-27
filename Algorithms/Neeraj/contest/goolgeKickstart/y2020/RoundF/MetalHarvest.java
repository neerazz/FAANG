package y2020.RoundF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created on:  Sep 26, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff48/00000000003f4b8b#problem
 */
public class MetalHarvest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] points = new int[n][2];
            for (int j = 0; j < n; j++) {
                points[j][0] = sc.nextInt();
                points[j][1] = sc.nextInt();
            }
            result[i] = getCount(n, k, points);
        }

        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static long getCount(int n, int k, int[][] points) {
//        System.out.println("n = " + n + ", k = " + k + ", points = " + Arrays.deepToString(points));
        Arrays.sort(points, (p1, p2) -> p1[0] - p2[0]);
        if (n == 0) return 0;
        long robs = 1, deadPoint = k + 1;
        for (int[] point : points) {
            if (point[1] < deadPoint) continue;
//            A new robot is need to harvest current point. Find the starting point.
            long start = Math.max(deadPoint, point[0]);
            deadPoint = start + k;
            robs++;
            while (deadPoint < point[1]) {
                robs++;
                deadPoint += k;
            }
        }
        return robs;
    }
}
