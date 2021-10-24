/*
    Created on:  Apr 19, 2020
 */

/**
 * Questions: https://www.hackerrank.com/challenges/crush/problem
 */
public class ArrayManipulation {
    public static void main(String[] args) {
        System.out.println(arrayManipulation(5, new int[][]{{1, 2, 100}, {2, 5, 100}, {3, 4, 100}}));
        System.out.println(arrayManipulation(4, new int[][]{{2, 3, 603}, {1, 1, 286}, {4, 4, 882}}));
    }

    static long arrayManipulation(int n, int[][] queries) {
        long[] cal = new long[n];
        long max = 0;
        for (int[] query : queries) {
            int a = query[0], b = query[1], k = query[2];
//            Just add the value at beginning.
            cal[a - 1] += k;
//            And reduce the value at end+1 one.
//            This way when we sum all the values from left to right.
//                  The values gets added at start and gets carried till the end and since we are reducing the k at end+1, it reduces.
            if (b < n) cal[b] -= k;
        }
        long sum = 0;
        for (long l : cal) {
            sum += l;
            max = Math.max(max, sum);
        }
        return max;
    }

    static long arrayManipulation_naive(int n, int[][] queries) {
        long[] cal = new long[n];
        long max = Long.MIN_VALUE;
        for (int[] query : queries) {
            int a = query[0], b = query[1], k = query[2];
            for (int i = a - 1; i < b; i++) {
                cal[i] += k;
                max = Math.max(max, cal[i]);
            }
        }
        return max == Long.MIN_VALUE ? 0 : max;
    }
}
