import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jul 17, 2020
 * Questions:
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, op = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                op += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return op;
    }
}
