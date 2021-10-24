/**
 * Created on:  Jul 13, 2021
 * Ref: https://www.educative.io/courses/grokking-the-coding-interview/Y52qNM0ljWK
 */

public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println("******************** Solution 1 **********************");
        System.out.println(findDuplicate(new int[]{1, 4, 4, 3, 2}));
        System.out.println(findDuplicate(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(findDuplicate(new int[]{2, 4, 1, 4, 4}));

        System.out.println("******************** Solution 2 **********************");
        System.out.println(findDuplicate_2(new int[]{1, 4, 4, 3, 2}));
        System.out.println(findDuplicate_2(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(findDuplicate_2(new int[]{2, 4, 1, 4, 4}));
    }

    public static int findDuplicate_2(int[] nums) {
        int slow = 0, fast = 0, len = nums.length;
        do {
            slow = next(nums, slow);
            fast = next(nums, fast);
            fast = next(nums, fast);
        } while (slow != fast);

//        find cycle length
        int cycleLength = 0;
        int current = nums[slow];
        do {
            current = nums[current];
            cycleLength++;
        } while (current != nums[slow]);
//        Find start
        int p1 = nums[0], p2 = nums[0];
        for (int i = 0; i < cycleLength; i++) {
            p1 = nums[p1] - 1;
        }
        while (p1 != p2) {
            p1 = next(nums, p1);
            p2 = next(nums, p2);
        }
        return p2;
    }

    private static int next(int[] nums, int idx) {
        return nums[idx];
    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1) {
                int cur = nums[i];
                nums[i] = nums[cur - 1];
                nums[cur - 1] = cur;
                if (nums[i] == cur) return cur;
            }
        }
        return -1;
    }
}