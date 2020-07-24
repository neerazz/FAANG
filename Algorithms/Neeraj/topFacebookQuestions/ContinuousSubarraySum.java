import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Jul 23, 2020
 * Questions: https://leetcode.com/problems/continuous-subarray-sum/
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(checkSubarraySum(new int[]{0, 0}, 0));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (i - map.getOrDefault(sum, i) > 1) {
                return true;
            }
            map.putIfAbsent(sum, i);
        }
        return false;
    }
}
