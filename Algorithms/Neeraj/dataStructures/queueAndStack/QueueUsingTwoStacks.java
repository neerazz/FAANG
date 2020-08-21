import java.util.Scanner;
import java.util.Stack;

/**
 * Created on:  Aug 19, 2020
 * Questions: https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 */
public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        MyQueueUsingStack myQueueUsingStack = new MyQueueUsingStack();
        final Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for (int i = 0; i < tests; i++) {
            int q = scanner.nextInt();
            if (q == 1) {
                int val = scanner.nextInt();
                myQueueUsingStack.enqueue(val);
            } else if (q == 2) {
                myQueueUsingStack.dequeue();
            } else {
                myQueueUsingStack.print();
            }
        }
        scanner.close();
    }

    static class MyQueueUsingStack {
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();

        public void print() {
            if (stack2.isEmpty()) {
//                Then get all teh values from stack 1 to stack2.
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }
            System.out.println(stack2.isEmpty() ? -1 : stack2.peek());
        }

        public int dequeue() {
            if (stack2.isEmpty()) {
//                Then get all teh values from stack 1 to stack2.
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }

        public void enqueue(int val) {
            stack1.add(val);
        }
    }
}
