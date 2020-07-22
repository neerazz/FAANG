import java.util.Stack;

/**
 * Created on:  Jul 21, 2020
 * Questions: https://leetcode.com/problems/validate-stack-sequences/
 */
public class ValidateStackSequences {
    public static void main(String[] args) {

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int l1 = pushed.length, l2 = popped.length;
        if (l1 != l2) return false;
        int p2 = 0;

        Stack<Integer> stack = new Stack<>();

        for (int num : pushed) {
            while (!stack.isEmpty() && popped[p2] == stack.peek()) {
                stack.pop();
                p2++;
            }
            stack.add(num);
        }

        while (!stack.isEmpty() && stack.peek() == popped[p2]) {
            stack.pop();
            p2++;
        }
        return stack.isEmpty() && p2 == l2;
    }
}
