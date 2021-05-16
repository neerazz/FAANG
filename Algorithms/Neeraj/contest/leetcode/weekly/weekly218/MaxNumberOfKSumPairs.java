package weekly.weekly218;

import java.util.*;

/**
 * Created on:  Dec 05, 2020
 * Questions: https://leetcode.com/contest/weekly-contest-218/problems/max-number-of-k-sum-pairs/
 */

public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {

    }

    public static int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int count =0;
        for(int key: map.keySet()){
            int rem = k - key;
            if(key == rem){
                count += map.get(key) /2;
                map.put(key, map.get(key) %2);
            }else if(map.containsKey(rem) && map.get(rem) > 0){
                int min = Math.min(map.get(key), map.get(rem));
                count += min;
                map.put(key, map.get(key)-min);
                map.put(rem, map.get(rem)-min);
            }
        }
        return count;
    }
}
