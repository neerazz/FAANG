package algo.grokking.twopointer;

import util.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 *
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 *
 */
public class PairWithTargetSum {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 6};
        Util.print(search(input, 6), "Search");
        Util.print(twoSum(input, 6), "TwoSum");
        test();
    }

    //Two pointer
    public static int[] search(int[] arr, int targetSum) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int p1 = arr[start], p2 = arr[end];
            if (p1 + p2 == targetSum) {
                return new int[]{p1, p2};
            } else if (p1 + p2 > targetSum) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }

    //Map
    public static int[] twoSum(int[] arr, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int elem : arr) {
            int compliment = targetSum - elem;
            if (map.containsKey(compliment)) {
                return new int[]{arr[map.get(compliment)], elem};
            } else {
                map.put(elem, i++);
            }
        }
        return new int[]{-1, -1};
    }


    public static void test() {
        while (true) {
            int[] input = Util.generateRandomArray();
            Arrays.sort(input);
            int a = Util.generateRandomNumber(input.length);
            int b = Util.generateRandomNumber(input.length);
            if (a == b) continue;
            int s = input[a] + input[b];

            int[] s1 = search(input, s);
            int[] s2 = twoSum(input, s);

            if (s1[0] + s1[1] != s || s2[0] + s2[1] != s) {
                Util.print(input, "Input");
                System.out.println(s);
                System.out.println(a);
                System.out.println(b);
                Util.print(s1, "Search");
                Util.print(s2, "TwoSum");
                return;
            }
        }
    }



}
