package contest1497;

import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 17, 2021
 * Questions: https://codeforces.com/contest/1497/problem/B
 */

public class MArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[] rems = new int[m];
            for (int i = 0; i < n; i++) {
                rems[sc.nextInt() % m]++;
            }
            System.out.println(findPairs(rems, m));
        }
    }

    private static int findPairs(int[] rems, int m) {
        int count = rems[0] > 0 ? 1 : 0;
        for (int i = 1; i <= (m - 1) / 2; i++) {
            int min = Math.min(rems[i], rems[m - i]);
            rems[m - i] -= min;
            rems[i] -= min;
            if (min > 0) {
                count++;
                if (rems[m - i] > 0) rems[m - i]--;
                if (rems[i] > 0) rems[i]--;
            }
            count += rems[i] + rems[m - i];
        }
        if (m % 2 == 0 && rems[m / 2] > 0) count++;
        return count;
    }
}
