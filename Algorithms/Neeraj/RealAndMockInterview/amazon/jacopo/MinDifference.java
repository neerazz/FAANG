package jacopo;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class MinDifference {

    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{1, 3, 5}, new int[]{5, 3, 1}));
    }

    private static int minDifference(int[] a, int[] b) {
        int len = a.length, sum = 0;
        TreeSet<Integer> sorted = new TreeSet<>();
        Queue<Integer> pq = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int diff = diff(a[i], b[i]);
            sum += diff;
            sorted.add(a[i]);
            if (diff > 0) pq.add(i);
        }
//        Loop through all the indices that are different, and find the closest value in a that can be set to get a max Difference.
        int reducedBySwapping = 0;
        while (!pq.isEmpty()) {
            int idx = pq.poll();
            int diff = diff(a[idx], b[idx]);
            Integer floor = sorted.floor(b[idx]), ceiling = sorted.ceiling(b[idx]);
            int cellDiff = ceiling == null ? Integer.MAX_VALUE : diff(b[idx], ceiling);
            int floorDiff = floor == null ? Integer.MAX_VALUE : diff(b[idx], floor);
            if (cellDiff < diff && diff - cellDiff > reducedBySwapping) {
                reducedBySwapping = diff - cellDiff;
            }
            if (floorDiff < diff && diff - floorDiff > reducedBySwapping) {
                reducedBySwapping = diff - floorDiff;
            }
        }
        return sum - reducedBySwapping;
    }

    private static int diff(int a, int b) {
        return Math.abs(a - b);
    }
}
