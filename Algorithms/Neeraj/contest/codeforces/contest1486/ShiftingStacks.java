package contest1486;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 18, 2021
 * Questions: https://codeforces.com/contest/1486/problem/A
 */

public class ShiftingStacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            long carry = 0;
            boolean possible = true;
            for (int j = 0; j < n; j++) {
                long cur = sc.nextInt();
                carry += cur - j;
                if (carry < 0) {
                    possible = false;
                }
            }
            System.out.println(possible ? "YES" : "NO");
        }
    }
}
