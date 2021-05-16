package weekly.weekly213;

import java.util.*;

/**
 * Created on:  Oct 31, 2020
 * Questions:
 */

public class CountSortedVowelStrings {

    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));
        System.out.println(countVowelStrings(3));
        System.out.println(countVowelStrings(33));
    }

    public static int countVowelStrings(int n) {
        if (n == 1) return 5;
        long[] pre = new long[5], cur = new long[5];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = 2; i <= n; i++) {
            cur[0] = pre[0] + pre[1] + pre[2] + pre[3] + pre[4];
            cur[1] = pre[1] + pre[2] + pre[3] + pre[4];
            cur[2] = pre[2] + pre[3] + pre[4];
            cur[3] = pre[3] + pre[4];
            cur[4] = pre[4];
            pre = cur;
        }
        long result = cur[0] + cur[1] + cur[2] + cur[3] + cur[4];
        return (int) result;
    }
}
