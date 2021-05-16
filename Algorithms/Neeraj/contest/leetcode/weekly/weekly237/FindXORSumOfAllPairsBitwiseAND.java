package weekly.weekly237;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Apr 17, 2021
 * Questions: https://leetcode.com/contest/weekly-contest-237/problems/find-xor-sum-of-all-pairs-bitwise-and/
 */

public class FindXORSumOfAllPairsBitwiseAND {

    public static void main(String[] args) {

    }

    public static int getXORSum(int[] arr1, int[] arr2) {
        Set<Integer> set1 = getMap(arr1);
        Set<Integer> set2 = getMap(arr2);
        int xor = 0;
        for (int v1 : set1) {
            for (int v2 : set2) {
                xor ^= v1 & v2;
            }
        }
        return xor;
    }

    private static Set<Integer> getMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream().filter(entry -> entry.getValue() % 2 == 1).map(Map.Entry::getKey).collect(Collectors.toSet());
    }
}
