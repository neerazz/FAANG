package contest1409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Sep 27, 2020
 * Questions: https://codeforces.com/contest/1409/problem/D
 */
public class DecreaseTheSumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            int s = sc.nextInt();
            System.out.println(getMinSwaps(n, s));
        }
    }

    private static long getMinSwaps(long n, int s) {
        long counter = 0, pow = 10;
        while (getSum(n) > s) {
//            The difference number needs to be added to the counter.
//              Ex: 23, pow  10;
//                  Starting diff = 10 - 23 % 10 = 7, pow = 100, n = 23 + 7 = 30
//                  Next diff = 100 - 30 = 70, pow = 1000, n = 100
            long diff = pow - n % pow;
            counter += diff;
            n += diff;
            pow *= 10;
        }
        return counter;
    }

    private static long getSum(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
