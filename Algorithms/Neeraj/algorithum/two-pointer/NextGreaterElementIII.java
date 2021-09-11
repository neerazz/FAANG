import java.util.LinkedList;

/**
 * Created on:  Dec 23, 2020
 * Questions: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/572/week-4-december-22nd-december-28th/3578/
 */

public class NextGreaterElementIII {

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(12) + " should be 21");
        System.out.println(nextGreaterElement(21) + " should be -1");
        System.out.println(nextGreaterElement(154320) + " should be 201345");
        System.out.println(nextGreaterElement(1) + " should be -1");
    }

    public static int nextGreaterElement(int n) {
        int[] nums = getDigits(n);
        boolean found = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            int min = nums[i], idx = -1;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    if (idx == -1 || nums[j] < min) {
                        min = nums[j];
                        idx = j;
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                swap(nums, i, idx);
//                 THen sort every thing after i++.
                sort(nums, i + 1);
                break;
            }
        }
        if (found) {
            return buildNumber(nums);
        } else {
            return -1;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void sort(int[] nums, int start) {
//         Sort every thing from the start idx.
        for (int i = start; i < nums.length; i++) {
            int min = nums[i], idx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    idx = j;
                }
            }
            if (idx == i) continue;
            swap(nums, i, idx);
        }
    }

    private static int buildNumber(int[] nums) {
        long result = 0;
        for (int num : nums) {
            result = result * 10 + num;
        }
        return result >= Integer.MAX_VALUE ? -1 : (int) result;
    }

    private static int[] getDigits(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        while (n > 0) {
            list.addFirst(n % 10);
            n /= 10;
        }
        return list.stream().mapToInt(val -> val).toArray();
    }
}
