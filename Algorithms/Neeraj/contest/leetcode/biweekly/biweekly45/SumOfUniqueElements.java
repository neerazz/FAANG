package biweekly.biweekly45;

import java.util.*;

/**
 * Created on:  Feb 06, 2021
 * Questions:
 */

public class SumOfUniqueElements {

    public static void main(String[] args) {

    }

    public static int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int sum = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count == 1) sum += key;
        }
        return sum;
    }
}
