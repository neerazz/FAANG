package contest1462;

import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 19, 2020
 * Questions: https://codeforces.com/contest/1462/problem/B
 */

public class LastYearSSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int len = sc.nextInt();
            String str = sc.next();
            System.out.println(canForm2020(str, len) ? "YES" : "NO");
        }
    }

    private static boolean canForm2020(String str, int len) {
        if (str.equals("2020")) return true;
        if (len < 4) return false;
        for (int i = 0; i <= 4; i++) {
            String cur = str.substring(0, i) + str.substring(len - 4 + i);
            if (cur.equals("2020")) return true;
        }
        return false;
    }
}
