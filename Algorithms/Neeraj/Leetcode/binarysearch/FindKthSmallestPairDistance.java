package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1041/
Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Note:
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class FindKthSmallestPairDistance {
    public static void main(String[] args) {
        System.out.println("Answer is: " + smallestDistancePair(new int[]{1, 3, 1}, 1) + " should be [0].");
        System.out.println("Answer is: " + smallestDistancePair(new int[]{62, 100, 4}, 2) + " should be [58].");
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }

    public static int smallestDistancePair_brooteForce(int[] nums, int k) {
        List<Integer> pairsDistance = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i != j) {
                    pairsDistance.add(Math.abs(nums[i] - nums[j]));
                }
            }
        }
        Collections.sort(pairsDistance);
        return pairsDistance.get(k - 1);
    }
}
