import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
Problem: https://leetcode.com/problems/two-sum/
Sample: (4 2 7 11 15 9)
Given 4 numbers
nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
Input 2: 5 -1 -2 -3 -4 -5 -8
 */
class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumbers = scanner.nextInt();
        int[] nums = new int[totalNumbers];
        for (int i = 0; i < totalNumbers; i++) {
            nums[i] = Integer.parseInt(scanner.next());
        }
        int target = Integer.parseInt(scanner.next());
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /*
    Return the two numbers
    Time: O(NLogN), Space: O(1)
     */
    public static int[] twoSum_elegant1(int[] nums, int target) {
        Arrays.sort(nums);
        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2) {
            int sum = nums[p1] + nums[p2];
            if (sum == target) {
                return new int[]{nums[p1], nums[p2]};
            } else if (sum > target) {
                p2--;
            } else {
                p1++;
            }
        }
        return new int[0];
    }

    /*
    Return the indices of teh first two number that resulted in sum.
    Time: O(N), Space: O(N)
     */
    public static int[] twoSum_elegant2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i], rem = target - cur;
            if (map.containsKey(cur)) {
                return new int[]{map.get(cur), i};
            }
            map.putIfAbsent(rem, i);
        }
        return new int[0];
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (currentValue + nums[j] == target) {
                    indexes[0] = i;
                    indexes[1] = j;
                    return indexes;
                }
            }
        }
        return indexes;
    }
}