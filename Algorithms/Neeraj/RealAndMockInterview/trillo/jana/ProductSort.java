package jana;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class ProductSort {

    public static void main(String[] args) {
        System.out.println(itemSort(new int[]{}));
    }

    private static int[] itemSort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> sortedProducts = map.entrySet()
                .stream()
                .sorted((e1, e2) -> e1.getValue().equals(e2.getValue()) ? Integer.compare(e1.getKey(), e2.getKey()) : Integer.compare(e2.getValue(), e1.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        int[] sorted = new int[nums.length];
        int i = 0;
        for (int key : sortedProducts) {
            int occurrence = map.get(key);
            while (occurrence-- > 0) {
                sorted[i++] = key;
            }
        }
        return sorted;
    }
}
