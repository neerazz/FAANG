import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Oct 03, 2020
 * Questions: https://leetcode.com/problems/k-diff-pairs-in-an-array/submissions/
 */
public class KdiffPairsInAnArray {
    public static void main(String[] args) {

    }

    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            count += k != 0 && map.containsKey(key + k) ? 1 : 0;
            if (k == 0 && map.get(key) > 1) count++;
        }
        return count;
    }
}
