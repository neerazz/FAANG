package weekly.weekly245;

import java.util.*;

/**
 * Created on:  Jun 12, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-245/problems/merge-triplets-to-form-target-triplet/
 */

public class MergeTripletsToFormTargetTriplet {

    public static void main(String[] args) {
        System.out.println(mergeTriplets(new int[][]{{1, 2, 5}, {1, 7, 4}}, new int[]{2, 7, 5}) + " = false");
        System.out.println(mergeTriplets(new int[][]{{3, 5, 1}, {10, 5, 7}}, new int[]{3, 5, 7}) + " = false");
    }

    public static boolean mergeTriplets(int[][] triplets, int[] target) {
        Map<Integer, Set<Integer>> map1 = new HashMap<>();
        Map<Integer, Set<Integer>> map2 = new HashMap<>();
        Map<Integer, Set<Integer>> map3 = new HashMap<>();
        for (int i = 0; i < triplets.length; i++) {
            map1.computeIfAbsent(triplets[i][0], val -> new HashSet<>()).add(i);
            map2.computeIfAbsent(triplets[i][1], val -> new HashSet<>()).add(i);
            map3.computeIfAbsent(triplets[i][2], val -> new HashSet<>()).add(i);
        }
//        return map1.containsKey(target[0]) && map2.containsKey(target[1]) && map3.containsKey(target[2]);
        Set<Integer> set1 = map1.get(target[0]);
        Set<Integer> set2 = map2.get(target[1]);
        Set<Integer> set3 = map3.get(target[2]);
        if (set1 == null || set2 == null || set3 == null) return false;
        for (int i1 : set1) {
            for (int i2 : set2) {
                for (int i3 : set3) {
                    int[] current = {
                            max(triplets[i1][0], triplets[i2][0], triplets[i3][0]),
                            max(triplets[i1][1], triplets[i2][1], triplets[i3][1]),
                            max(triplets[i1][2], triplets[i2][2], triplets[i3][2])};
                    if (Arrays.equals(current, target)) return true;
                }
            }
        }
        return false;
    }

    static int max(int v1, int v2, int v3) {
        return Math.max(Math.max(v1, v2), v3);
    }
}
