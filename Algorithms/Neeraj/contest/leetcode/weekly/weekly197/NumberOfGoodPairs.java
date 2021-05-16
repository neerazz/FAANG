package weekly.weekly197;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created on:  Jul 11, 2020
 * Questions: https://leetcode.com/problems/number-of-good-pairs
 * Number of Good Pairs
 */
public class NumberOfGoodPairs {
    public static void main(String[] args) {

    }

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], val -> new LinkedList<>()).add(i);
        }
        int count = 0;
        for (int key : map.keySet()) {
            Queue<Integer> val = map.get(key);
            while (val.size() > 1) {
                count += val.size() - 1;
                val.poll();
            }
        }
        return count;
    }
}
