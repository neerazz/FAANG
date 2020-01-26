package problems.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/binary-search/144/more-practices/1034/
Given two arrays, write a function to compute their intersection.
Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:
Each element in the result must be unique.
The result can be in any order.
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        System.out.println("Answer is: " + Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})) + " should be [2,2].");
        System.out.println("Answer is: " + Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})) + " should be [4,9].");
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> output = new ArrayList<>();
        List<Integer> nums1List = Arrays.stream(nums1).boxed().collect(Collectors.toList());

        for (int i = 0; i < nums2.length; i++) {
            int current = nums2[i];
            if (nums1List.contains(current)) {
                nums1List.remove((Integer) current);
                output.add(current);
            }
        }
        return output.stream().mapToInt(i -> i).toArray();
    }
}
