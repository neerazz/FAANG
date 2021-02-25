import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 22, 2021
 * Questions: https://leetcode.com/problems/find-the-celebrity/
 */

public class FindTheCelebrity {

    public static void main(String[] args) {

    }

    public static int findCelebrity_rev1(int n) {
        int possiblecleb = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possiblecleb, i)) {
                possiblecleb = i;
            }
        }
        return isCeleb(possiblecleb, n) ? possiblecleb : -1;
    }

    private static boolean isCeleb(int possiblecleb, int n) {
        for (int i = 0; i < n; i++) {
            if (i == possiblecleb) continue;
            if (knows(possiblecleb, i) || !knows(i, possiblecleb)) return false;
        }
        return true;
    }

    public static int findCelebrity(int n) {
        Set<Integer> celb = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                boolean knows = knows(i, j);
                // System.out.println(String.format("%d knows %d", i, j) + " " + knows + " n = " + n);
                count += knows ? 1 : 0;
                if (count == 1) break;
            }
            if (count == 0) celb.add(i);
        }
        for (int pos : celb) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (pos == i) continue;
                boolean knows = knows(i, pos);
                count += knows ? 1 : 0;
            }
            if (count == n - 1) return pos;
        }
        return -1;
    }

    //    Inbuild api.
    private static boolean knows(int a, int b) {
        return false;
    }
}
