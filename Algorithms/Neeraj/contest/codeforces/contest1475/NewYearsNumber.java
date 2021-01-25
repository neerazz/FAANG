package contest1475;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 25, 2021
 * Questions: https://codeforces.com/contest/1475/problem/B
 */

public class NewYearsNumber {

    public static void main(String[] args) {
//        runTest();
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            boolean isPossible = checkPossibility(sc.nextInt());
//            boolean isPossible = checkPossibility_dp(sc.nextInt());
            System.out.println(isPossible ? "YES" : "NO");
        }
    }

    private static boolean checkPossibility(int val) {
        int div = val / 2020, rem = val % 2020;
        return rem <= div;
    }
}
