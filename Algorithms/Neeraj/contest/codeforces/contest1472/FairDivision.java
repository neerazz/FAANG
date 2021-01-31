package contest1472;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 28, 2021
 * Questions:
 */

public class FairDivision {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long[] counts = new long[3];
            for (int j = 0; j < n; j++) {
                counts[sc.nextInt()]++;
            }
//            System.out.println(canDivide_naive(counts) ? "YES" : "NO");
            System.out.println(canDivide(n, counts) ? "YES" : "NO");
        }
    }

    private static boolean canDivide(int n, long[] counts) {
//        It there are odd number od ones, then it cannot be divided.
        if (counts[1] % 2 == 1) return false;
//        If total numbers are odd and there are no 1's
        if (n % 2 == 1 && counts[1] == 0) return false;
        return true;
    }

    private static boolean canDivide_naive(long[] counts) {
        int a = 0, b = 0;
        if (counts[1] % 2 == 0 && counts[2] % 2 == 0) return true;
        while (counts[2] > 0 && counts[1] >= 2) {
            counts[2]--;
            a += 2;
            b += 2;
            counts[1] -= 2;
        }
        return a == b && counts[1] >= 0 && counts[1] % 2 == 0 && counts[2] >= 0 && counts[2] % 2 == 0;
    }
}
