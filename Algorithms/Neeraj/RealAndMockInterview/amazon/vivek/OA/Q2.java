package vivek.OA;

import java.util.*;

/**
 * Created on:  Feb 03, 2021
 * Questions:
 */

public class Q2 {

    public static void main(String[] args) {
        System.out.println(storage(6, 6, Arrays.asList(4), Arrays.asList(2)) + " = 4");
        System.out.println(storage(2, 2, Arrays.asList(1), Arrays.asList(2)) + " = 4");
    }

    private static long storage(int n, int m, List<Integer> h, List<Integer> v) {
        LinkedHashSet<Integer> hs = new LinkedHashSet<>(), vs = new LinkedHashSet<>();
        for (int i = 0; i <= n + 1; i++) {
            hs.add(i);
        }
        for (int i = 0; i <= m + 1; i++) {
            vs.add(i);
        }
        removeSeparators(hs, h);
        removeSeparators(vs, v);
        long maxH = getMaxStorage(hs), maxV = getMaxStorage(vs);
        return maxH * maxV;
    }

    private static long getMaxStorage(LinkedHashSet<Integer> separators) {
        int pre = 0, max = 1;
        for (int cur : separators) {
            if (cur - pre > max) max = cur - pre;
            pre = cur;
        }
        return max;
    }

    private static void removeSeparators(LinkedHashSet<Integer> separators, List<Integer> remove) {
        for (int separator : remove) {
            separators.remove(separator);
        }
    }
}
