package contest1409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Sep 27, 2020
 * Questions: https://codeforces.com/contest/1409/problem/B
 */
public class MinimumProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextLong(), b = sc.nextLong(), x = sc.nextLong(), y = sc.nextLong(), n = sc.nextLong();
            System.out.println(getMinProduct_optimal(a, b, x, y, n));
//            System.out.println(getMinProduct(a, b, x, y, n));
        }
    }

    private static String getMinProduct_optimal(long a, long b, long x, long y, long n) {
        long A = Math.max(x, a - n), B = Math.max(y, b - n);
//        Reduce both of them to maximum possible distance.
        long min = Math.min(A, B);
//        Take the minimum value and then reduce the remaining value from the other number.
        long rem = n - (min == A ? a - A : b - B);
        long max = min == A ? Math.max(b - rem, y) : Math.max(a - rem, x);
        return String.valueOf(min * max);
    }

    private static String getMinProduct(long a, long b, long x, long y, long n) {
        BigInteger min = null;
        long reduceA = Math.min(a - x, n);
        long reduceB = Math.min(b - y, n);
        for (int i = 0; i <= reduceA; i++) {
            for (int j = 0; j <= reduceB && i + j <= n; j++) {
                BigInteger cur = BigInteger.valueOf(a - i).multiply(BigInteger.valueOf((b - j)));
                if (min == null || cur.compareTo(min) < 0) {
                    min = cur;
                }
            }
        }
        return min.toString();
    }
}
