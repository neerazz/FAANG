package contest1487;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 15, 2021
 * Questions: https://codeforces.com/contest/1487/problem/B
 */

public class CatCycle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), k = sc.nextInt();
            System.out.println(getKPosition(n, k));
//            System.out.println(getKPosition_naive(n, k));
//            System.out.println(getKPosition_skip(n, k));
        }
    }

//    https://www.youtube.com/watch?v=ceOIfdS33hs
    private static int getKPosition(int n, int k) {
//        You need position at k. so you have to make only k-1 steps.
        k--;
        if (n % 2 == 0) return (k % n) + 1;
//        Collision always happen when the n is odd, and the collision happens always at center.
        int collision = n / 2;
//        You need to find out how many collisions will happen while making k steps.
//          Because every time when there is a collision then batB makes one extra step.
//          So when there is collision then the number of steps increases by extra_steps.
        return ((k / collision) + k) % n + 1;
    }

    private static long getKPosition_skip(long n, long k) {
        long a = n, b = 1, collision = 0, step = 0;
        while (step++ < k - 1) {
            a = a == 1 ? n : a - 1;
            b = b == n ? 1 : b + 1;
            collision++;
            if (a == b) {
                b = b == n ? 1 : b + 1;
                break;
            }
        }
        while (step < k - 1) {
            if (step + collision < k - 1) {
//            Fast forward to next number where the next collision is supposed to happen
                step += collision;
                long move = collision % n;
                while (move-- > 0) {
                    a = a == 1 ? n : a - 1;
                    b = b == n ? 1 : b + 1;
                }
            } else {
                step++;
                a = a == 1 ? n : a - 1;
                b = b == n ? 1 : b + 1;
            }
            if (a == b) {
                b = b == n ? 1 : b + 1;
            }
        }
        return b;
    }

    private static int getKPosition_naive(int n, int k) {
        int a = n, b = 1;
        for (int i = 1; i < k; i++) {
            a = a == 1 ? n : a - 1;
            b = b == n ? 1 : b + 1;
            while (a == b) {
                b = b == n ? 1 : b + 1;
            }
            System.out.println("Steps " + i + ": a=" + a + ", b =" + b);
        }
        return b;
    }
}
