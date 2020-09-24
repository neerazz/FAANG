package contest1419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created on:  Sep 23, 2020
 * Questions: https://codeforces.com/contest/1419/problem/A
 */
public class DigitGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            String num = sc.next();
            System.out.println(getWinner(len, num));
        }
    }

    private static String getWinner(int len, String num) {
        if (len == 1) return (num.charAt(0) - '0') % 2 == 1 ? "1" : "2";
        int odd = 0, even = 0;
        for (int i = 0; i < len; i += 2) {
            odd += (num.charAt(i) - '0') % 2;
        }
        for (int i = 1; i < len; i += 2) {
            even += (num.charAt(i) - '0') % 2 == 0 ? 1 : 0;
        }
        if (len % 2 == 0) return even >= 1 ? "2" : "1";
        return odd >= 1 ? "1" : "2";
    }
}
