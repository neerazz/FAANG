import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 10, 2021
 * Ref: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
 */
public class ArithmeticSlicesIiSubsequence {
    public static void main(String[] args) {

    }

    public static int numberOfArithmeticSlices(int[] nums) {
        Map<String, Integer> dp = new HashMap<>();
        int len = nums.length;
        int total = 0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                total += helper(nums, j+1, nums[j], (long)nums[j] - nums[i], dp);
            }
        }
        return total;
    }

    static int helper(int[] nums, int start, int pre, long diff, Map<String, Integer> dp){
        int len = nums.length;
        if(start >= len) return 0;
        String key = start + " " + diff;
        if(dp.containsKey(key)) return dp.get(key);
        int cur =0;
        long expected = pre + diff;
        for(int i=start; i<len; i++){
            if(nums[i] == expected){
                cur += helper(nums, i+1, nums[i], diff, dp)+1;
            }
        }
        dp.put(key, cur);
        return cur;
    }

    static int total;
    public static int numberOfArithmeticSlices_naive(int[] nums) {
        total = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            dfs(nums, nums[i], i + 1, 1, 0);
        }
        return total;
    }

    static void dfs(int[] nums, int pre, int start, int k, int diff) {
        int len = nums.length;
        if (k >= 3) total++;
        if (start >= len) return;
        if (k == 1) {
//             find the second item and add the diff
            for (int i = start; i < len; i++) {
                dfs(nums, nums[i], i + 1, k + 1, nums[i] - pre);
            }
            return;
        }
        int exp = pre + diff;
        for (int i = start; i < len; i++) {
            if (nums[i] == exp) {
                dfs(nums, nums[i], i + 1, k + 1, diff);
            } else if (nums[i] > exp) break;
        }
    }
}
