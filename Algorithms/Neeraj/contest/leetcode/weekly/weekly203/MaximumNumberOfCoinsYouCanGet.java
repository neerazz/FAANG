package weekly.weekly203;

import java.util.Stack;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://leetcode.com/problems/maximum-number-of-coins-you-can-get
 */
public class MaximumNumberOfCoinsYouCanGet {
    public static void main(String[] args) {
        System.out.println(findLatestStep(new int[]{3, 5, 1, 2, 4}, 1));
    }

    public static int findLatestStep(int[] arr, int m) {
        int[] counts = new int[arr.length + 2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]] = 1 + counts[arr[i] - 1] + counts[arr[i] + 1];
            if (counts[arr[i]] == m) stack.add(i + 1);
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }
}
