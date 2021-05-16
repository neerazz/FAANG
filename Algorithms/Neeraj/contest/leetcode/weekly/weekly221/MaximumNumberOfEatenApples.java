package weekly.weekly221;

import java.util.*;

/**
 * Created on:  Dec 26, 2020
 * Questions:
 */

public class MaximumNumberOfEatenApples {

    public static void main(String[] args) {
        System.out.println(eatenApples(new int[]{1}, new int[]{2}));
        System.out.println(eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
        System.out.println(eatenApples(new int[]{3, 0, 0, 0, 0, 2}, new int[]{3, 0, 0, 0, 0, 2}));
        System.out.println(eatenApples(new int[]{9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5}, new int[]{3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7}));
        System.out.println(eatenApples(
                new int[]{0, 19, 19, 19, 11, 14, 33, 0, 28, 7, 0, 28, 7, 0, 21, 16, 0, 22, 0, 13, 8, 0, 19, 0, 0, 2, 26, 2, 22, 0, 8, 0, 0, 27, 19, 16, 24, 0, 20, 26, 20, 7, 0, 0, 29, 0, 0, 16, 19, 0, 0, 0, 29, 30, 17, 0, 23, 0, 0, 26, 24, 13, 3, 0, 21, 0, 18, 0},
                new int[]{0, 5, 1, 16, 7, 10, 54, 0, 40, 2, 0, 23, 4, 0, 20, 18, 0, 40, 0, 22, 8, 0, 35, 0, 0, 3, 24, 1, 8, 0, 10, 0, 0, 2, 38, 8, 4, 0, 36, 33, 14, 9, 0, 0, 56, 0, 0, 21, 27, 0, 0, 0, 14, 20, 18, 0, 42, 0, 0, 44, 3, 8, 3, 0, 10, 0, 27, 0}));
    }

    public static int eatenApples(int[] apples, int[] days) {
        TreeSet<int[]> set = new TreeSet<>((v1, v2) -> v1[2] == v2[2] ? Integer.compare(v1[1], v2[1]) : Integer.compare(v1[2], v2[2]));
        int len = apples.length, count = 0;
        int day = 1;
        for (int i = 0; i < len; i++) {
            if (apples[i] > 0) {
                set.add(new int[]{apples[i], i, i + days[i]});
            }
//            Check if any apple can be taken.
            while (!set.isEmpty() && set.first()[2] < day) {
//                Delete the rotten apples
                set.remove(set.first());
            }
            if (!set.isEmpty()) {
                int[] cur = set.first();
                if (cur[0]-- > 1) set.add(cur);
                else set.remove(cur);
                count++;
            }
            day++;
        }
        while (!set.isEmpty()) {
            while (!set.isEmpty() && set.first()[2] < day) {
//                Delete the apples that are rotten
                set.remove(set.first());
            }
            if (!set.isEmpty() && set.first()[1] <= day) {
                int[] cur = set.first();
                if (cur[0]-- > 1) set.add(cur);
                else set.remove(cur);
                count++;
            }
            day++;
        }
        return count;
    }

    public static int eatenApples_PQ(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[2] == v2[2] ? Integer.compare(v1[1], v2[1]) : Integer.compare(v1[2], v2[2]));
//        0: count, 1: start, 2: end
        int len = apples.length, count = 0, day = 1;
        for (int i = 0; i < len; i++) {
            if (apples[i] > 0) {
                pq.add(new int[]{apples[i], i, i + days[i]});
            }
        }
        while (!pq.isEmpty()) {
            while (!pq.isEmpty() && pq.peek()[2] < day) {
//                Delete the apples that are rotten
                pq.poll();
            }
            if (!pq.isEmpty() && pq.peek()[1] <= day) {
                int[] poll = pq.poll();
                if (poll[0]-- > 1) pq.add(poll);
                count++;
            }
            day++;
        }
        return count;
    }
}
