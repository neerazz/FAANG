import java.util.Stack;

/**
 * Created on:  Oct 01, 2021
 * Ref: https://leetcode.com/problems/number-of-visible-people-in-a-queue/
 */
public class NumberOfVisiblePeopleInAQueue {
    public static void main(String[] args) {

    }

    public static int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] count = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            int height = heights[i];
            int see = 0;
            while (!stack.isEmpty() && stack.peek() < height) {
                see++;
                stack.pop();
            }
            count[i] = see + (stack.isEmpty() ? 0 : 1);
            stack.add(height);
        }
        return count;
    }
}
