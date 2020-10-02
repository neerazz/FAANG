package contest1426;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Oct 01, 2020
 * Questions: https://codeforces.com/contest/1426/problem/B
 */
public class SymmetricMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            boolean foundSymmetry = false;
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
                foundSymmetry = foundSymmetry || b == c;
            }
            System.out.println(foundSymmetry && m % 2 == 0 ? "YES" : "NO");
        }
    }
}
