package biweekly.biweekly26;
/*
    Created on:  May 16, 2020
 */

import java.util.*;

/**
 * Questions: https://leetcode.com/contest/biweekly-contest-26/problems/simplified-fractions/
 */
public class SimplifiedFractions {
    public static void main(String[] args) {
        System.out.println(simplifiedFractions(2) + " should be [\"1/2\"]");
        System.out.println(simplifiedFractions(3) + " should be [\"1/2\",\"1/3\",\"2/3\"]");
        System.out.println(simplifiedFractions(4) + " should be [\"1/2\",\"1/3\",\"1/4\",\"2/3\",\"3/4\"]");
        System.out.println(simplifiedFractions(1) + " should be []");
    }

    public static List<String> simplifiedFractions(int n) {
        if (n == 1) Collections.emptyList();
        Map<Double, String> map = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < n && j < i; j++) {
                Double div = (double) j / i;
                int rem = j % i;
                if (!map.containsKey(div) && rem != 0) {
                    map.put(div, j + "/" + i);
                }
            }
        }
        return new ArrayList<>(map.values());
    }
}
