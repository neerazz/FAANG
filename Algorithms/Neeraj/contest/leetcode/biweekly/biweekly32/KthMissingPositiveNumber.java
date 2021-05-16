package biweekly.biweekly32;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Aug 08, 2020
 * Questions: https://leetcode.com/problems/kth-missing-positive-number/
 */
public class KthMissingPositiveNumber {
    public static void main(String[] args) {

    }

    public static int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        int max = 0, found = 0;
        for (int num : arr) {
            set.add(num);
            max = Math.max(max, num);
        }
        for (int i = 1; i < max || found <= k; i++) {
            if (set.contains(i)) continue;
            found++;
            if (found == k) return i;
        }
        return -1;
    }
}
