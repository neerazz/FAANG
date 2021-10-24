import java.util.Arrays;
import java.util.List;
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
        System.out.println("********************************* Solution 1 ********************************");
        System.out.println(canPartitionKSubsets(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 4) + " = true");
        System.out.println(canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4) + " = false");
        System.out.println("********************************* Solution 2 ********************************");
        System.out.println(canPartitionKSubsets_rev2(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 4) + " = true");
        System.out.println(canPartitionKSubsets_rev2(new int[]{2, 2, 2, 2, 3, 4, 5}, 4) + " = false");
        System.out.println(canPartitionKSubsets_rev2(new int[]{4, 3, 2, 3, 5, 2, 1}, 4) + " = true");
        System.out.println(canPartitionKSubsets_rev2(new int[]{605, 454, 322, 218, 8, 19, 651, 2220, 175, 710, 2666, 350, 252, 2264, 327, 1843}, 4) + " = true");
    }

    public static boolean canPartitionKSubsets_rev2(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        long perset = sum / k;
        int len = nums.length, found = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num > perset) return false;
            else if (num == perset) {
                visited[i] = true;
                found++;
            }
        }
        return hasSet(nums, 0, 0, perset, visited, found, k);
    }

    static boolean hasSet(int[] nums, int start, long soFar, long req, boolean[] visited, int cnt, int k) {
        if (cnt == k) return true;
        if (soFar == req) {
//            When you formed a group, start reconsidering from start.
            return hasSet(nums, 0, 0, req, visited, cnt + 1, k);
        }
        if (soFar > req) return false;
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (hasSet(nums, i + 1, soFar + nums[i], req, visited, cnt, k)) return true;
                visited[i] = false;
            }
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
