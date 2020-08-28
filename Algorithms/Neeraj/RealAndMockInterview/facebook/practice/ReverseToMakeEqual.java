package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Aug 26, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=2869293499822992
 */
public class ReverseToMakeEqual {
    public static void main(String[] args) {
        System.out.println(areTheyEqual(new int[]{1, 2, 3, 4}, new int[]{1, 4, 3, 2}));
    }

    static boolean areTheyEqual(int[] array_a, int[] array_b) {
        if (array_a.length != array_b.length) return false;
        int len = array_a.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int cur : array_a) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        for (int cur : array_b) {
            if (!map.containsKey(cur)) return false;
            map.put(cur, map.get(cur) - 1);
            if (map.get(cur) > 1) map.put(cur, map.get(cur) - 1);
            else map.remove(cur);
        }
        return map.isEmpty();
    }
}
