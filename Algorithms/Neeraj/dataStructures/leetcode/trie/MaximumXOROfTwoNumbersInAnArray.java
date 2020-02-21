package ds.trie;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersInAnArray {
    public static void main(String[] args) {
        int[] nums = {12, 86, 52, 58, 13, 63, 64, 18, 40, 73, 44, 94};
        System.out.println(findMaximumXOR_Naive(nums) + "\t" + findMaximumXOR_Elegent(nums));
    }

    private static int findMaximumXOR_Naive(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    public static int findMaximumXOR_Elegent(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
