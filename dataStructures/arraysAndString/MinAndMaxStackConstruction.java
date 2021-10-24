import java.util.Stack;

class MinAndMaxStackConstruction {
    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack();
        System.out.println("********************************");
        stack.push(2);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
        System.out.println("********************************");
        stack.push(7);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
        System.out.println("********************************");
        stack.push(1);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
        System.out.println("********************************");
        stack.push(8);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
        System.out.println("********************************");
        stack.push(3);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
        System.out.println("********************************");
        stack.push(9);
        System.out.println(stack.getMin());
        System.out.println(stack.getMax());
        System.out.println(stack.peek());
        System.out.println("********************************");
        System.out.println(stack.pop() + " = 9");
        System.out.println(stack.getMin() + " = 1");
        System.out.println(stack.getMax() + " = 8");
        System.out.println(stack.peek() + " = 3");
        System.out.println("********************************");
        System.out.println(stack.pop() + " = 3");
        System.out.println(stack.getMin() + " = 1");
        System.out.println(stack.getMax() + " = 8");
        System.out.println(stack.peek() + " = 8");
    }

    static class MinMaxStack {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        public int peek() {
            // This will just get the last inserted item.
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.peek();
        }

        public int pop() {
            // This will remove the last inserted Item.
            if (stack.isEmpty()) {
                return -1;
            }
            int pop = this.stack.pop();
            // System.out.println("Before min =" + min + " max =" + max);
            if (pop == min || pop == max) {
                calculateMinAndMax();
            }
            // System.out.println("After min =" + min + " max =" + max);
            return pop;
        }

        private void calculateMinAndMax() {
            int size = stack.size();
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                int cur = stack.get(i);
                min = Math.min(min, cur);
                max = Math.max(max, cur);
            }
        }

        public void push(Integer number) {
            stack.add(number);
            if (number > max || number < min) {
                calculateMinAndMax();
            }
        }

        public int getMin() {
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        public int getMax() {
            return max == Integer.MIN_VALUE ? -1 : max;
        }
    }
}
