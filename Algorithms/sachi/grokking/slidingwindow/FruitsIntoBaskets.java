package grokking.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with 2 distinct characters
 */
public class FruitsIntoBaskets {

    public static void main(String[] args) {
        char[] input = new char[]{'A', 'B', 'C', 'A', 'C'};
        System.out.println(findLength(input));
    }

    public static int findLength(char[] arr) {
        int start = 0, end = 0, sol = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        while (end < arr.length - 1) {
            if (canGoNext(end, arr, map)) {
                end++;
                sol = Math.max(sol, end - start + 1);
                map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            } else {
                if (map.get(arr[start]) == 1) {
                    map.remove(arr[start]);
                } else {
                    map.put(arr[start], map.getOrDefault(arr[start], 1) - 1);
                }
                start++;
            }
        }
        return sol;
    }

    public static boolean canGoNext(int end, char[] arr, Map<Character, Integer> map) {
        return map.containsKey(arr[end + 1]) || map.size() < 2;
    }

}
