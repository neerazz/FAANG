package contest1490;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 16, 2021
 * Questions: https://codeforces.com/contest/1490/problem/B
 */

public class BalancedRemainders {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), avg = n / 3, count = 0;
            int[] rems = new int[3];
            for (int j = 0; j < n; j++) {
                rems[sc.nextInt() % 3]++;
            }
            while (!isSame(rems, avg)) {
                int maxIdx = maxIdx(rems);
                int nextIdx = maxIdx == 2 ? 0 : maxIdx + 1;
                rems[maxIdx]--;
                rems[nextIdx]++;
                count++;
            }
            System.out.println(count);
        }
    }

    private static int maxIdx(int[] rems) {
        int idx = 0;
        for (int i = 1; i < 3; i++) {
            if (rems[idx] < rems[i]) idx = i;
        }
        return idx;
    }

    private static boolean isSame(int[] rems, int avg) {
        return rems[0] == rems[1] && rems[1] == rems[2] && rems[0] == avg;
    }
}
