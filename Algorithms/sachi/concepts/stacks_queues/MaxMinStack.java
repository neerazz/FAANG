package concepts.stacks_queues;

import java.util.Deque;
import java.util.LinkedList;

public class MaxMinStack {

    public static void main(String[] args) {

    }

    public class myStack {

        public class MyPersonalStackClass {
            private Integer val;
            private Integer min;
            private Integer max;

            public MyPersonalStackClass(Integer val, Integer min, Integer max) {
                this.val = val;
                this.min = min;
                this.max = max;
            }
        }

        Deque<MyPersonalStackClass> stack = new LinkedList<>();

        public void push(Integer x) {
            if (stack.isEmpty()) {
                stack.push(new MyPersonalStackClass(x, x, x));
            } else {
                Integer max;
                Integer min;
                MyPersonalStackClass curr = stack.peek();
                max = x > curr.max ? x : curr.max;
                min = x < curr.min ? x : curr.min;
                stack.push(new MyPersonalStackClass(x, min, max));
            }
        }

        public Integer pop() {
            return stack.pop().val;
        }

        public Integer min() {
            if (!stack.isEmpty()) {
                return stack.peek().min;
            } else {
                return null;
            }
        }

        public Integer max() {
            if (!stack.isEmpty()) {
                return stack.peek().max;
            } else {
                return null;
            }
        }

    }
}
