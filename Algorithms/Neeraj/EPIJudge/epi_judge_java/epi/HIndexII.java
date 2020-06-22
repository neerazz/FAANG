package epi;

/**
 * Created on:  Jun 18, 2020
 * Questions: https://leetcode.com/problems/h-index/
 */
public class HIndexII {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{100}) + " should be [100]");
    }

    public static int hIndex(int[] c) {
        int n = c.length;
        int s = 0, e = n - 1;

        while (s < e) {
            int m = (s + e) / 2;
            if (c[m] < n - m) {
                s = m + 1;
            } else {
                e = m;
            }
        }

        if (s < n && c[s] >= n - s) return n - s;
        else return 0;
    }
}
