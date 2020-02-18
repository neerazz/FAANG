package ds.binarysearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        System.out.println("Answer is:" + findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3) + " should be [1,2,3,4].");
        System.out.println("Answer is:" + findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1) + " should be [1,2,3,4].");
        System.out.println("Answer is:" + findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5) + " should be [3,3,4].");
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        return Arrays.stream(arr).boxed().sorted((a, b) -> a.equals(b) ? a - b : Math.abs(a - x) - Math.abs(b - x)).collect(Collectors.toList()).subList(0, k).stream().sorted().collect(Collectors.toList());
    }
}
