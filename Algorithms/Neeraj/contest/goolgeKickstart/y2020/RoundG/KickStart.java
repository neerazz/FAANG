package y2020.RoundG;

import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 18, 2020
 * Questions:https://codingcompetitions.withgoogle.com/kickstart/round/00000000001a0069/0000000000414bfb
 */

public class KickStart {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = sc.nextInt();
        int[] result = new int[tests];
        for (int i = 0; i < tests; i++) {
            result[i] = getFragments(sc.next());
        }
        for (int i = 0; i < tests; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[i]);
        }
    }

    private static int getFragments(String str) {
        int len = str.length();
        int count = 0, kick = 0;
        for (int i = 0; i < len; i++) {
            if (i + 4 <= len && str.substring(i, i + 4).equals("KICK")) kick++;
            if (i + 5 <= len && str.substring(i, i + 5).equals("START")) {
                count += kick;
            }
        }
        return count;
    }

    private static int getFragments_naive(String str) {
        Set<Integer> kick = new HashSet<>(), start = new HashSet<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (i + 4 <= len && str.substring(i, i + 4).equals("KICK")) kick.add(i);
            if (i + 5 <= len && str.substring(i, i + 5).equals("START")) start.add(i);
        }
//        System.out.println("kick = " + kick);
//        System.out.println("start = " + start);
        int count = 0;
        for (int k : kick) {
            for (int s : start) {
                if (s >= k + 4) count++;
            }
        }
        return count;
    }
}
