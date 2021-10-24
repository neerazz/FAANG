import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jun 22, 2020
 * Questions:
 */
public class SingleNumberII {
    public static void main(String[] args) {

    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream().filter(entry -> entry.getValue() == 1).map(entry -> entry.getKey()).findFirst().get();
    }
}
