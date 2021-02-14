package contest1419;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 11, 2021
 * Questions: https://codeforces.com/contest/1419/problem/C
 */

public class Killjoy {

//    https://www.youtube.com/watch?v=d2o5KOSazoM
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), x = sc.nextInt();
            int same = 0, sum = 0;
            for (int j = 0; j < n; j++) {
                int cur = sc.nextInt();
                sum += cur;
                if (cur == x) {
                    same++;
                }
            }
            if (same == n) {
                System.out.println("0");
            } else if (same > 0 || sum == n * x) {
//                sum of all number is same as product of all numbers and x. That means you need one operation to cancel out the negative and positives.
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }
}
