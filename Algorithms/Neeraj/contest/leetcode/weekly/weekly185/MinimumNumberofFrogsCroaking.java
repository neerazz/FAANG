package weekly.weekly185;
/*
    Created on:  Apr 18, 2020
 */

import java.util.*;

/**
 * Questions: https://leetcode.com/problems/minimum-number-of-frogs-croaking/discuss/586477/Count-maximum-number-of-ongoing-state-machines
 */
public class MinimumNumberofFrogsCroaking {
    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("croakcroak"));
        System.out.println(minNumberOfFrogs("croakcroa"));
        System.out.println(minNumberOfFrogs("crcoakroak"));
        System.out.println(minNumberOfFrogs("aoocrrackk"));
        System.out.println(minNumberOfFrogs("crocracokrakoak"));
    }

    // solution: https://leetcode.com/problems/minimum-number-of-frogs-croaking/discuss/586477/Count-maximum-number-of-ongoing-state-machines
    public static int minNumberOfFrogs(String croakOfFrogs) {
//   Keep transferring the state of the frog.
//      When it is at c state will be 0, at r it will be 1, o -> 2, a -> 3, k -> 4
        int[] states = new int[5];
        int frog = 0, result = 0;
//        Keep a counter of flogs, when it starts
        for (char c : croakOfFrogs.toCharArray()) {
            if (c == 'c') {
//                frog result would be max of frog after considering the current.
                result = Math.max(result, ++frog);
                states[0]++;
            } else if (c == 'r') {
                if (states[0] <= 0) return -1;
                states[1]++;
                states[0]--;
            } else if (c == 'o') {
                if (states[1] <= 0) return -1;
                states[2]++;
                states[1]--;
            } else if (c == 'a') {
                if (states[2] <= 0) return -1;
                states[3]++;
                states[2]--;
            } else {
                if (states[3] <= 0) return -1;
                states[4]++;
                states[3]--;
                frog--;
            }
        }
        return frog == 0 ? result : -1;
    }

    public static int minNumberOfFrogs_wrong(String croakOfFrogs) {
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> cs = new LinkedList<>(), rs = new LinkedList<>(), os = new LinkedList<>(), as = new LinkedList<>(), ks = new LinkedList<>();
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            if (c == 'c') cs.add(i);
            if (c == 'r') rs.add(i);
            if (c == 'o') os.add(i);
            if (c == 'a') as.add(i);
            if (c == 'k') ks.add(i);
        }
        while (!cs.isEmpty()) {
            int cI = -1, rI = -1, oI = -1, aI = -1, kI = -1;
            if (!cs.isEmpty()) cI = cs.removeFirst();
            if (!rs.isEmpty()) rI = rs.removeFirst();
            if (!os.isEmpty()) oI = os.removeFirst();
            if (!as.isEmpty()) aI = as.removeFirst();
            if (!ks.isEmpty()) kI = ks.removeFirst();
            if (cI < rI && rI < oI && oI < aI && aI < kI && cI != -1) {
                int hash = cI + (rI - cI) * 10 + (oI - cI) * 100 + (aI - cI) * 1000 + (kI - cI) * 10000;
                set.add(hash);
            } else return -1;
        }
        if (!rs.isEmpty() || !os.isEmpty() || !as.isEmpty() || !ks.isEmpty()) return -1;
        return set.size();
    }
}
