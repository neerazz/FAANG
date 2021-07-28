package algo.grokking.twopointer;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing
 * the duplicates in-place return the length of the subarray that has no duplicate in it.
 * <p>
 * <p>
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * <p>
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(remove(input));
        System.out.println(removeNaive(input));

        input = new int[]{2, 2, 2, 11};
        System.out.println(remove(input));
        System.out.println(removeNaive(input));
    }

    //Without Additional space
    public static int remove(int[] arr) {
        return -1;
    }

    //Naive approach - O(n) Space
    public static int removeNaive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            set.add(a);
        }
        return set.size();
    }

}
