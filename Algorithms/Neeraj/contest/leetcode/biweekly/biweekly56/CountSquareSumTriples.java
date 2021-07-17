package biweekly.biweekly56;

/**
 * Created on:  Jul 10, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-56/problems/count-square-sum-triples/
 */

public class CountSquareSumTriples {

    public static void main(String[] args) {

    }

    public static int countTriples(int n) {
        int count = 0;
        for (int a = 2; a <= n; a++) {
            for (int b = 2; b <= n; b++) {
                if (a == b) continue;
                int sqr = a * a + b * b;
                int c = (int) Math.sqrt(sqr);
                if (c * c == sqr && c <= n) {
                    System.out.printf("(%d, %d, %d) = (%d,%d,%d)", a, b, c, a * a, b * b, c * c);
                    count++;
                }
            }
        }
        return count;
    }
}
