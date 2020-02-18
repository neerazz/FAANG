package ds.recursion;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*

Question: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
Solution: We can figure out what target each subset must sum to.
Then, let's recursively search, where at each call to our function, we choose which of k subsets the next value will join.
Input : 7 4
4 3 2 3 5 2 1
Output : true

Input: 10 5
1 1 1 1 1 1 1 1 1 1
Output: true

Input: 12 3
10 10 10 7 7 7 7 7 7 6 6 6
 */
public class PartitionToKEqualSumSubsets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.next());
        int subSets = Integer.parseInt(sc.next());
        int[] arrays = new int[size];
        for (int i = 0; i < size; i++) {
            arrays[i] = Integer.parseInt(sc.next());
        }
        System.out.println(canPartitionKSubsets(arrays, subSets));
    }

    public static boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;
        }
        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }

    public static boolean canPartitionKSubsets2(int[] nums, int k) {
//        First find out what target each subset must sum to.
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int eachSubSetSum = sum / k;
        List<Integer> asList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return canSubsets(asList, eachSubSetSum, k);
    }

    public static boolean canSubsets(List<Integer> asList, int eachSubSetSum, int k) {
        if (asList.size() < 1) {
            return false;
        }
        int firstSubSet = asList.get(0);
        if (firstSubSet == eachSubSetSum) {
            asList.remove(0);
            k--;
        } else if (firstSubSet < eachSubSetSum) {
//            Then find the next subset.
            for (int i = 1; i < asList.size(); i++) {
                int sum = firstSubSet + asList.get(i);
                if (sum == eachSubSetSum) {
                    asList.remove(i);
                    asList.remove(0);
                    k--;
                    break;
                }
            }
        }
        if (k == 0) {
            return true;
        }
        return canSubsets(asList, eachSubSetSum, k);
    }
}
