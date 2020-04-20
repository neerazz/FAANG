/*
    Created on:  Apr 19, 2020
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Questions: https://www.hackerrank.com/challenges/dynamic-array/problem
 */
public class DynamicArray {
    public static void main(String[] args) {
        System.out.println(dynamicArray(2,Arrays.asList(
                Arrays.asList(1,0,5),
                Arrays.asList(1,1,7),
                Arrays.asList(1,0,3),
                Arrays.asList(2,1,0),
                Arrays.asList(2,1,1))));
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> op = new ArrayList<>();
        List<Integer>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) lists[i] = new ArrayList<>();
        int lastAnswer = 0;
        for (List<Integer> query : queries) {
            int q = query.get(0), x = query.get(1), y = query.get(2);
            if (q == 1) {
                int idx = (x ^ lastAnswer) % n;
                lists[idx].add(y);
            } else {
                int idx = (x ^ lastAnswer) % n;
                lastAnswer = lists[idx].get(y % lists[idx].size());
                op.add(lastAnswer);
            }
        }
        return op;
    }
}
