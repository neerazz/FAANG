package recursion2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/explore/learn/card/recursion-ii/507/beyond-recursion/2903/
Given a collection of distinct integers, return all possible permutations.
Example:
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutations {
    static List<List<Integer>> output;

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute_elegant(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        output = new ArrayList<>();
        backTrack(nums, 0, new LinkedList<>());
        return output;
    }

    private static void backTrack(int[] nums, int index, LinkedList<Integer> integers) {
        if (integers.size() == nums.length) {
            output.add(new LinkedList<>(integers));
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (!integers.contains(temp)) {
                integers.add(temp);
                backTrack(nums, index + 1, integers);
                integers.removeLast();
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static void permute(int[] nums, int len) {
        if (len <= 1) {
            ArrayList<Integer> x = new ArrayList(nums.length);
            for (int y : nums) {
                x.add(y);
            }
            output.add(x);
            return;
        }
        int j = len - 1;
        for (int i = 0; i < j; i++) {
            swap(nums, i, j);
            permute(nums, j);
            swap(nums, i, j);
        }
        permute(nums, j);
    }

    public static List<List<Integer>> permute_elegant(int[] nums) {
        output = new ArrayList<List<Integer>>();
        permute(nums, nums.length);
        return output;
    }
}
