package contest1409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Sep 27, 2020
 * Questions: https://codeforces.com/contest/1409/problem/A
 */
public class YetAnotherTwoIntegersProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long a = sc.nextInt(), b = sc.nextInt();
            System.out.println(getDistance(a, b));
        }
    }

    private static long getDistance(long a, long b) {
        if (b < a) return getDistance(b, a);
        long diff = b - a;
        if (diff % 10 != 0) {
            diff /= 10;
            diff++;
        } else {
            diff /= 10;
        }
        return diff;
    }
}
