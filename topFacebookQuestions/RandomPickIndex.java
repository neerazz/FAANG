import java.util.*;

/**
 * Created on:  Jul 26, 2020
 * Questions: https://leetcode.com/problems/random-pick-index/
 */
public class RandomPickIndex {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 5, 6, 5, 7, 9};
        Solution sol = new Solution(nums);
        System.out.println(sol.pick(nums[sol.random.nextInt(nums.length)]));
    }

    static class Solution {
        Map<Integer, List<Integer>> map;
        Random random;

        public Solution(int[] nums) {
            map = new HashMap<>();
            random = new Random();
            for (int i = 0; i < nums.length; i++) {
                map.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> idx = map.get(target);
            return idx.get(random.nextInt(idx.size()));
        }
    }
}
