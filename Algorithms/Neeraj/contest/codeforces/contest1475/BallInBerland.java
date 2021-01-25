package contest1475;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 25, 2021
 * Questions: https://codeforces.com/contest/1475/problem/C
 */

public class BallInBerland {


    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), k = sc.nextInt();
            int[] boys = new int[k], girls = new int[k];
            for (int j = 0; j < k; j++) {
                boys[sc.nextInt() - 1]++;
            }
            for (int j = 0; j < k; j++) {
                girls[sc.nextInt() - 1]++;
            }
            System.out.println(getPossibilities(a, b, k, boys, girls));
        }
    }

//    Solution: https://codeforces.com/contest/1475/submission/105410879
    private static long getPossibilities(int a, int b, int k, int[] boys, int[] girls) {
//        Get total number of combinations that can be formed over all.
        long total = ((long) k * (k - 1)) / 2;
//        Because each boy can be present in only one set, reduce it from the remaining.
        for (int boy : boys) {
            total -= ((long) boy * (boy - 1)) / 2;
        }
        for (int girl : girls) {
            total -= ((long) girl * (girl - 1)) / 2;
        }
        return total;
    }
}
