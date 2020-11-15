package y2020.RoundH;

import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 14, 2020
 * Questions: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff49/000000000043adc7
 */

public class ReType {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        long[] result = new long[tests];
        for (int i = 0; i < tests; i++) {
            long n = sc.nextLong(), k = sc.nextLong(), s = sc.nextLong();
            result[i] = compete(n, k, s);
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static long compete(long n, long k, long s) {
//        Option 1: Reset
        long v1 = k - 1 + 1 + n;
//        Option 2: Go back till s, and start from there.
        long v2 = k - 1 + k - s + n - s + 1;
        return Math.min(v1, v2);
    }
}
