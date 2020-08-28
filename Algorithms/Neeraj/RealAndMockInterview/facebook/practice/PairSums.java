package practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Aug 25, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=840934449713537
 */
public class PairSums {
    public static void main(String[] args) {

    }

    int numberOfWays(int[] arr, int k) {
        if (arr == null || arr.length <= 1) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += map.getOrDefault(k - arr[i], 0);
            if (k - arr[i] == arr[i]) count--;
        }
        return count / 2;
    }
}
