/*
    Created on:  Apr 19, 2020
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Questions: https://www.hackerrank.com/challenges/sparse-arrays/problem
 */
public class SparseArrays {
    public static void main(String[] args) {

    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : strings) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int[] op = new int[queries.length];
        int idx = 0;
        for (String query : queries) {
            op[idx++] = map.getOrDefault(query, 0);
        }
        return op;
    }
}
