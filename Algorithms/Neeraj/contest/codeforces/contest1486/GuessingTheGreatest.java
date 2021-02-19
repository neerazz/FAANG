package contest1486;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 18, 2021
 * Questions: https://codeforces.com/contest/1486/problem/C1#
 */

public class GuessingTheGreatest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int s = 1, e = sc.nextInt(), ans = -1;
        while (s < e) {
            int idx = query(sc, s, e);
            if (e - s + 1 <= 2) {
//                If there are only two numbers between start and end.
                if (idx == s) ans = s + 1;
                else ans = s;
                break;
            }
            int mid = (s + e) / 2;
            if (idx <= mid) {
//                If the second highest is on the left side, then make a call from start to mid
//                  If the call still returns the same idx then the highest is on the left side.
                int idx2 = query(sc, s, mid);
                if (idx2 == idx) e = mid;
                else s = mid;
            } else {
//                  If the call still returns the same idx then the highest is on the right side.
                int idx2 = query(sc, mid, e);
                if (idx2 == idx) s = mid;
                else e = mid;
            }
        }
        System.out.println("! " + ans);
    }

    private static int query(Scanner sc, int s, int e) {
        if (s == e) return s;
        System.out.println("? " + s + " " + e);
        System.out.flush();
        return sc.nextInt();
    }
}
