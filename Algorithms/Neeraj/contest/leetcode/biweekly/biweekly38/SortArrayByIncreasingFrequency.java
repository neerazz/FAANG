package biweekly.biweekly38;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Oct 31, 2020
 * Questions:
 */

public class SortArrayByIncreasingFrequency {

    public static void main(String[] args) {

    }
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num: nums){
            counts.put(num, counts.getOrDefault(num,0)+1);
        }
        List<Integer> numsOrder = counts.entrySet().stream().sorted(
                (e1,e2) -> e1.getValue() == e2.getValue() ? e2.getKey() - e1.getKey() : e1.getValue() - e2.getValue())
                .map(entry -> entry.getKey()).collect(Collectors.toList());
        int len = nums.length, i =0;
        int[] result = new int[len];
        for(int val: numsOrder){
            int count = counts.get(val);
            while(count > 0){
                result[i++] = val;
                count--;
            }
        }
        return result;
    }
}
