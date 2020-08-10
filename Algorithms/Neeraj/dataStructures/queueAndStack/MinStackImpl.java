import java.util.Stack;

/**
 * Created on:  Aug 08, 2020
 * Questions: https://leetcode.com/problems/min-stack/
 */
public class MinStackImpl {
    public static void main(String[] args) {

    }

    static class MinStack {
        int min = Integer.MAX_VALUE;
        Stack<int[]> stack;

        public MinStack() {
            stack = new Stack();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                min = x;
            } else {
                min = Math.min(getMin(), x);
            }
            stack.push(new int[]{x, min});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }
}
