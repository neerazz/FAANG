package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/hash-table/183/combination-with-other-algorithms/1105/
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
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> output = new HashSet<>();
        List<Integer> nums1List = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums2.length; i++) {
            int current = nums2[i];
            if (nums1List.contains(current)) {
                output.add(current);
            }
        }
        return output.stream().mapToInt(i -> i).toArray();
    }
}
