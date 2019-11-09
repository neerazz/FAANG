package algorithms;

import java.util.Arrays;

/*
https://www.hackerrank.com/challenges/staircase/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
public class Staircase {
    public static void main(String[] args) {
        staircase(4);
        System.out.println("**********************************************");
        staircase(6);
    }

    static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, ' ');
            Arrays.fill(chars, n - i, n, '#');
            System.out.println(String.valueOf(chars));
        }
    }
}
