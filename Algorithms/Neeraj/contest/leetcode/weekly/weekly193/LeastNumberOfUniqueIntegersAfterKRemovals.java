package weekly.weekly193;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on:  Jun 13, 2020
 * Questions: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {

    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : arr) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        List<Integer> collect = map.entrySet().stream().sorted((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue())).map(entry -> entry.getKey()).collect(Collectors.toList());
        int unique = map.size();
        for (int val : collect) {
            int count = map.get(val);
            if (count <= k) {
                k -= count;
                unique--;
            }
            if (k <= 0) break;
        }
        return unique;
    }
}
