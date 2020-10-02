package contest1426;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Oct 01, 2020
 * Questions: https://codeforces.com/contest/1426/problem/A
 */
public class FloorNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), x = sc.nextInt();
            int floor = 1;
            if (n > 2) {
                n -= 2;
                floor += n / x + (n % x > 0 ? 1 : 0);
            }
            System.out.println(floor);
        }
    }
}
