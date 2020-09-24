package contest1419;

import java.util.Scanner;

/**
 * Created on:  Sep 23, 2020
 * Questions: https://codeforces.com/contest/1419/problem/B
 */
public class Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            long n = sc.nextLong();
            System.out.println(solve(n));
            t--;
        }
    }

    static int solve(long n) {
        int count = 0;
        long x = 1;
        long total = 0;
        long totaltillnow = 0;
        while (totaltillnow < n) {
            total += x * x + total;
            totaltillnow += total;
            x *= 2;
            count++;
        }
        if (totaltillnow > n) count--;
        return count;
    }
}
