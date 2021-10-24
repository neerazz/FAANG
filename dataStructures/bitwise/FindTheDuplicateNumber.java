import java.util.Arrays;

/**
 * Created on:  Jun 25, 2020
 * Questions: https://leetcode.com/problems/find-the-duplicate-number
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println("***************************** Solution 1 *********************************");
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}) + " should be [2].");
        System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}) + " should be [3].");
        System.out.println(findDuplicate(new int[]{2, 2, 2, 2, 2}) + " should be [2].");
        System.out.println("***************************** Solution 2 *********************************");
        System.out.println(findDuplicate_opt(new int[]{1, 3, 4, 2, 2}) + " should be [2].");
        System.out.println(findDuplicate_opt(new int[]{3, 1, 3, 4, 2}) + " should be [3].");
        System.out.println(findDuplicate_opt(new int[]{2, 2, 2, 2, 2}) + " should be [2].");
    }

    public static int findDuplicate_opt(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return hare;
    }

    public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int pre = -1;
        for (int num : nums) {
            if (pre == num) return pre;
            pre = num;
        }
        return pre;
    }
}
