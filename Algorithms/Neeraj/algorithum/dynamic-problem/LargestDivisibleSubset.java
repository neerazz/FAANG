import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created on:  Jun 13, 2020
 * Questions: https://leetcode.com/problems/largest-divisible-subset/
 */
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println("**************************** Solution 1 ***************************");
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}) + " should be [1,2] or [1,3]");
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}) + " should be [1,2,4,8]");
        System.out.println(largestDivisibleSubset(new int[]{1}) + " should be [1]");
        System.out.println(largestDivisibleSubset(new int[]{2, 3, 4, 9, 8}) + " should be [2,4,8]");
        System.out.println("**************************** Solution 2 ***************************");
        System.out.println(largestDivisibleSubset_rev1(new int[]{1, 2, 3}) + " should be [1,2] or [1,3]");
        System.out.println(largestDivisibleSubset_rev1(new int[]{1, 2, 4, 8}) + " should be [1,2,4,8]");
        System.out.println(largestDivisibleSubset_rev1(new int[]{1}) + " should be [1]");
        System.out.println(largestDivisibleSubset_rev1(new int[]{2, 3, 4, 9, 8}) + " should be [2,4,8]");
    }

    public static List<Integer> largestDivisibleSubset_rev1(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        List<Integer>[] dp = new ArrayList[len + 1];
        dp[0] = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] % nums[j - 1] == 0 &&
                        dp[j].size() > level.size()) {
                    level.clear();
                    level.addAll(dp[j]);
                }
            }
            level.add(nums[i - 1]);
            if(level.size() > result.size()){
                result = level;
            }
            dp[i] = level;
        }
//        System.out.println(Arrays.toString(dp));
        return result;
    }

    // https://www.youtube.com/watch?v=Wv6DlL0Sawg
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len <= 0) return Collections.emptyList();
        Arrays.sort(nums);
//        Create a DP of longest subset that can be formed at each index.
        int[] dp = new int[len];
//        Each element can be mod of itself, so the minimum subset that can be formed is 1.
        Arrays.fill(dp, 1);
//        Take a maximum int, to keep a track of the maximum size of the subset.
        int maxVal = 1, maxNumber = nums[0];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxVal) {
                        maxVal = dp[i];
                        maxNumber = nums[i];
                    }
                }
            }
        }
        List<Integer> op = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == maxVal && maxNumber % nums[i] == 0) {
                op.add(nums[i]);
                maxVal--;
                maxNumber = nums[i];
            }
        }

        return op;
    }
}
