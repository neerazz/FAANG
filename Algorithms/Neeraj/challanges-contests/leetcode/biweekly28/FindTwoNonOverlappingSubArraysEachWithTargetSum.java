package biweekly28;

import java.util.*;

/**
 * Created on:  Jun 13, 2020
 * Questions:
 */
public class FindTwoNonOverlappingSubArraysEachWithTargetSum {
    public static void main(String[] args) {
        System.out.println(minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3) + " should be [2]");
        System.out.println(minSumOfLengths(new int[]{7, 3, 4, 7}, 7) + " should be [2]");
        System.out.println(minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6) + " should be [-1]");
        System.out.println(minSumOfLengths(new int[]{5, 5, 4, 4, 5}, 3) + " should be [-1]");
        System.out.println(minSumOfLengths(new int[]{3, 1, 1, 1, 5, 1, 2, 1}, 3) + " should be [3]");
        System.out.println(minSumOfLengths(new int[]{78, 18, 1, 94, 1, 1, 1, 29, 58, 3, 4, 1, 2, 56, 17, 19, 4, 1, 63, 2, 16, 11, 1, 1, 2, 1, 25, 62, 10, 69, 12, 7, 1, 6, 2, 92, 4, 1, 61, 7, 26, 1, 1, 1, 67, 26, 2, 2, 70, 25, 2, 68, 13, 4, 11, 1, 34, 14, 7, 37, 4, 1, 12, 51, 25, 2, 4, 3, 56, 21, 7, 8, 5, 93, 1, 1, 2, 55, 14, 25, 1, 1, 1, 89, 6, 1, 1, 24, 22, 50, 1, 28, 9, 51, 9, 88, 1, 7, 1, 30, 32, 18, 12, 3, 2, 18, 10, 4, 11, 43, 6, 5, 93, 2, 2, 68, 18, 11, 47, 33, 17, 27, 56, 13, 1, 2, 29, 1, 17, 1, 10, 15, 18, 3, 1, 86, 7, 4, 16, 45, 3, 29, 2, 1, 1, 31, 19, 18, 16, 12, 1, 56, 4, 35, 1, 1, 36, 59, 1, 1, 16, 58, 18, 4, 1, 43, 31, 15, 6, 1, 1, 6, 49, 27, 12, 1, 2, 80, 14, 2, 1, 21, 32, 18, 15, 11, 59, 10, 1, 14, 3, 3, 7, 15, 4, 55, 4, 1, 12, 4, 1, 1, 53, 37, 2, 5, 72, 3, 6, 10, 3, 3, 83, 8, 1, 5}
                , 97) + " should be [5]");
    }

    public static int minSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
//        This is to have a reference to starting index.
        int sum = 0;
//        Calculate the pre sums, Sum of all the left elements till that index.
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        int leftSize = Integer.MAX_VALUE, result = Integer.MAX_VALUE;

//        Loop through the array again.
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
//            If the (sum - target) is present in map, that means the subarray with target sum is present somewhere that you have travelled so far.
//            Ex: [1,2,3], map = {(0,-1),(1,0),(3,1),(6,2)}, target = 3
//                 i       i=0, sum = 1, target-sum = 2, not present
//                   i     i=1, sum = 3, target-sum = 0, size = i- map.get(0) = 0
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
