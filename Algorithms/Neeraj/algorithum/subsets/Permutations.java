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

    public static void main(final String[] args) {
        System.out.println(Permutations.permute(new int[]{1, 2, 3}));
        System.out.println(Permutations.permute_elegant(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> permute(final int[] nums) {
        Permutations.output = new ArrayList<>();
        Permutations.backTrack(nums, 0, new LinkedList<>());
        return Permutations.output;
    }

    private static void backTrack(final int[] nums, final int index, final LinkedList<Integer> integers) {
        if (integers.size() == nums.length) {
            Permutations.output.add(new LinkedList<>(integers));
        }
        for (int i = 0; i < nums.length; i++) {
            final int temp = nums[i];
            if (!integers.contains(temp)) {
                integers.add(temp);
                Permutations.backTrack(nums, index + 1, integers);
                integers.removeLast();
            }
        }
    }

    static void swap(final int[] nums, final int i, final int j) {
        final int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static void permute(final int[] nums, final int len) {
        if (len <= 1) {
            final ArrayList<Integer> x = new ArrayList(nums.length);
            for (final int y : nums) {
                x.add(y);
            }
            Permutations.output.add(x);
            return;
        }
        final int j = len - 1;
        for (int i = 0; i < j; i++) {
            Permutations.swap(nums, i, j);
            Permutations.permute(nums, j);
            Permutations.swap(nums, i, j);
        }
        Permutations.permute(nums, j);
    }

    public static List<List<Integer>> permute_elegant(final int[] nums) {
        Permutations.output = new ArrayList<List<Integer>>();
        Permutations.permute(nums, nums.length);
        return Permutations.output;
    }
}
