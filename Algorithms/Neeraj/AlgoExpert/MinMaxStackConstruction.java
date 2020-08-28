import java.util.Stack;

/**
 * Created on:  Aug 08, 2020
 * Questions: https://www.algoexpert.io/questions/Min%20Max%20Stack%20Construction
 */
public class MinMaxStackConstruction {
    public static void main(String[] args) {
        MinMaxStack minMaxStack = new MinMaxStack();
        minMaxStack.push(5);// -
        System.out.println(minMaxStack.getMin());// 5
        System.out.println(minMaxStack.getMax());// 5
        System.out.println(minMaxStack.peek());
        // 5
        minMaxStack.push(7);// -
        System.out.println(minMaxStack.getMin());// 5
        System.out.println(minMaxStack.getMax());// 7
        System.out.println(minMaxStack.peek());// 7
        minMaxStack.push(2);// -
        System.out.println(minMaxStack.getMin());// 2
        System.out.println(minMaxStack.getMax());// 7
        System.out.println(minMaxStack.peek());// 2
        System.out.println(minMaxStack.pop());// 2
        System.out.println(minMaxStack.pop());// 7
        System.out.println(minMaxStack.getMin());// 5
        System.out.println(minMaxStack.getMax());// 5
        System.out.println(minMaxStack.peek());// 5
    }

    static class MinMaxStack {
        //        0: val, 1 : min, 2 : max
        Stack<int[]> stack = new Stack<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        public int peek() {
            return stack.isEmpty() ? -1 : stack.peek()[0];
        }

        public int pop() {
            return stack.isEmpty() ? -1 : stack.pop()[0];
        }

        public void push(Integer number) {
            if (stack.isEmpty()) {
                min = max = number;
            } else {
                min = Math.min(getMin(), number);
                max = Math.max(getMax(), number);
            }
            stack.add(new int[]{number, min, max});
        }

        public int getMin() {
            return stack.isEmpty() ? -1 : stack.peek()[1];
        }

        public int getMax() {
            return stack.isEmpty() ? -1 : stack.peek()[2];
        }
    }
}
