package biweekly.biweekly28;

import java.util.*;

/**
 * Created on:  Jun 13, 2020
 * Questions: https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 */
public class FindTwoNonOverlappingSubArraysEachWithTargetSum {
    public static void main(String[] args) {
        System.out.println("********************************* Solution 1 *******************************");
        System.out.println(minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3) + " should be [2]");
        System.out.println(minSumOfLengths(new int[]{7, 3, 4, 7}, 7) + " should be [2]");
        System.out.println(minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6) + " should be [-1]");
        System.out.println(minSumOfLengths(new int[]{5, 5, 4, 4, 5}, 3) + " should be [-1]");
        System.out.println(minSumOfLengths(new int[]{3, 1, 1, 1, 5, 1, 2, 1}, 3) + " should be [3]");
        System.out.println(minSumOfLengths(new int[]{78, 18, 1, 94, 1, 1, 1, 29, 58, 3, 4, 1, 2, 56, 17, 19, 4, 1, 63, 2, 16, 11, 1, 1, 2, 1, 25, 62, 10, 69, 12, 7, 1, 6, 2, 92, 4, 1, 61, 7, 26, 1, 1, 1, 67, 26, 2, 2, 70, 25, 2, 68, 13, 4, 11, 1, 34, 14, 7, 37, 4, 1, 12, 51, 25, 2, 4, 3, 56, 21, 7, 8, 5, 93, 1, 1, 2, 55, 14, 25, 1, 1, 1, 89, 6, 1, 1, 24, 22, 50, 1, 28, 9, 51, 9, 88, 1, 7, 1, 30, 32, 18, 12, 3, 2, 18, 10, 4, 11, 43, 6, 5, 93, 2, 2, 68, 18, 11, 47, 33, 17, 27, 56, 13, 1, 2, 29, 1, 17, 1, 10, 15, 18, 3, 1, 86, 7, 4, 16, 45, 3, 29, 2, 1, 1, 31, 19, 18, 16, 12, 1, 56, 4, 35, 1, 1, 36, 59, 1, 1, 16, 58, 18, 4, 1, 43, 31, 15, 6, 1, 1, 6, 49, 27, 12, 1, 2, 80, 14, 2, 1, 21, 32, 18, 15, 11, 59, 10, 1, 14, 3, 3, 7, 15, 4, 55, 4, 1, 12, 4, 1, 1, 53, 37, 2, 5, 72, 3, 6, 10, 3, 3, 83, 8, 1, 5}
                , 97) + " should be [5]");

        System.out.println("********************************* Solution 2 *******************************");
        System.out.println(minSumOfLengths_rev1(new int[]{3, 2, 2, 4, 3}, 3) + " should be [2]");
        System.out.println(minSumOfLengths_rev1(new int[]{7, 3, 4, 7}, 7) + " should be [2]");
        System.out.println(minSumOfLengths_rev1(new int[]{4, 3, 2, 6, 2, 3, 4}, 6) + " should be [-1]");
        System.out.println(minSumOfLengths_rev1(new int[]{5, 5, 4, 4, 5}, 3) + " should be [-1]");
        System.out.println(minSumOfLengths_rev1(new int[]{3, 1, 1, 1, 5, 1, 2, 1}, 3) + " should be [3]");
        System.out.println(minSumOfLengths_rev1(new int[]{78, 18, 1, 94, 1, 1, 1, 29, 58, 3, 4, 1, 2, 56, 17, 19, 4, 1, 63, 2, 16, 11, 1, 1, 2, 1, 25, 62, 10, 69, 12, 7, 1, 6, 2, 92, 4, 1, 61, 7, 26, 1, 1, 1, 67, 26, 2, 2, 70, 25, 2, 68, 13, 4, 11, 1, 34, 14, 7, 37, 4, 1, 12, 51, 25, 2, 4, 3, 56, 21, 7, 8, 5, 93, 1, 1, 2, 55, 14, 25, 1, 1, 1, 89, 6, 1, 1, 24, 22, 50, 1, 28, 9, 51, 9, 88, 1, 7, 1, 30, 32, 18, 12, 3, 2, 18, 10, 4, 11, 43, 6, 5, 93, 2, 2, 68, 18, 11, 47, 33, 17, 27, 56, 13, 1, 2, 29, 1, 17, 1, 10, 15, 18, 3, 1, 86, 7, 4, 16, 45, 3, 29, 2, 1, 1, 31, 19, 18, 16, 12, 1, 56, 4, 35, 1, 1, 36, 59, 1, 1, 16, 58, 18, 4, 1, 43, 31, 15, 6, 1, 1, 6, 49, 27, 12, 1, 2, 80, 14, 2, 1, 21, 32, 18, 15, 11, 59, 10, 1, 14, 3, 3, 7, 15, 4, 55, 4, 1, 12, 4, 1, 1, 53, 37, 2, 5, 72, 3, 6, 10, 3, 3, 83, 8, 1, 5}
                , 97) + " should be [5]");
    }

    public static int minSumOfLengths_rev1(int[] arr, int target) {
        int result = Integer.MAX_VALUE, p1 = 0, p2 = 0, len = arr.length;
        int[] best = new int[len];
        int sum = 0, bestSoFar = Integer.MAX_VALUE;
        while (p2 < len) {
            sum += arr[p2];
//            If target is more then sum , then keep increasing the p1 window.
            while (sum > target) {
                sum -= arr[p1++];
            }
            if (sum == target) {
//                Then check if any subarray with target was formed.
                if (p1 > 0 && best[p1 - 1] != Integer.MAX_VALUE) {
//                    There is one subarray that was formed before the p1 pointer.
                    int first = best[p1 - 1], second = p2 - p1 + 1;
                    result = Math.min(result, first + second);
                }
//                Keep a track of the subarray that was formed with min length so far.
                bestSoFar = Math.min(bestSoFar, p2 - p1 + 1);
            }
//            Assign the best subarray that was formed till p2 point.
            best[p2] = bestSoFar;
            p2++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
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
        int result = Integer.MAX_VALUE, leftSize = Integer.MAX_VALUE;

//        Loop through the array again.
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
//            If the (sum - target) is present in map, that means the subarray with target sum is present somewhere that you have travelled so far.
//            Ex: [1,2,3], map = {(0,-1),(1,0),(3,1),(6,2)}, target = 3
//                 i       i=0, sum = 1, target-sum = 2, not present
//                   i     i=1, sum = 3, target-sum = 0, size = i- map.get(0) = 0
            if (map.containsKey(sum - target)) {
                leftSize = Math.min(leftSize, i - map.get(sum - target));
            }
            if (leftSize != Integer.MAX_VALUE && map.containsKey(target + sum)) {
                int rightSize = map.get(target + sum) - i;
                result = Math.min(result, leftSize + rightSize);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
