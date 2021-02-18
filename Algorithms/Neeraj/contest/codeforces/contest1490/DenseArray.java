package contest1490;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 16, 2021
 * Questions: https://codeforces.com/contest/1490/problem/A
 */

public class DenseArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int count = 0, pre = sc.nextInt();
            for (int j = 1; j < n; j++) {
                int cur = sc.nextInt();
                while (!isDense(pre, cur)) {
                    count++;
                    if (pre < cur) pre *= 2;
                    else pre = pre / 2 + pre % 2;
                }
                pre = cur;
            }
            System.out.println(count);
        }
    }

    private static boolean isDense(int pre, int cur) {
        return Math.max(pre, cur) <= 2 * Math.min(pre, cur);
    }
}
