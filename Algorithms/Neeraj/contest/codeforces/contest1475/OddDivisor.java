package contest1475;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 25, 2021
 * Questions: https://codeforces.com/contest/1475/problem/A
 */

public class OddDivisor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            boolean found = getOddDivisor(sc.nextLong());
            System.out.println(found ? "YES" : "NO");
        }
    }

    private static boolean getOddDivisor(long num) {
        for (long i = 3; i <= num; i += 2) {
            if (num % i == 0) return true;
        }
        return false;
    }
}
