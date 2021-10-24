/*
    Created on:  Apr 28, 2020
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Questions: https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/maahismathi/
 */
public class Maahismathi {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) throws Exception {
//        FastReader sr = new FastReader("C:\\Users\\bnira\\Downloads\\501534587c-In000.txt.clean.txt");
        FastReader sr = new FastReader();
        int n = sr.nextInt();
        int[] golds = new int[n];
        for (int i = 0; i < n; i++) {
            golds[i] = sr.nextInt();
        }
        Arrays.sort(golds);
        int q = sr.nextInt();
        int[] queries = new int[q];
        for (int i = 0; i < q; i++) {
            queries[i] = sr.nextInt();
        }
        for (int query : queries) {
            System.out.println(getValue(query, golds));
        }
    }

    private static int getValue(int query, int[] golds) {
        if (memo.containsKey(query)) return memo.get(query);
        int len = golds.length, paidIdx = 0, paidAmt = 0;
        int processed = 0;
        while (processed < len) {
            paidAmt += golds[paidIdx++];
            processed++;
            processed += query;
        }
        memo.put(query, paidAmt);
        return paidAmt;
    }
}
