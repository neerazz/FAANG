package leetcode.v1.easy;

import java.util.Deque;
import java.util.LinkedList;

class MinStack {

    Deque<Integer> myStack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        myStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        minStack.getMin();  // --> Returns -3.
        minStack.pop();
        minStack.getMin();   //--> Returns -2.
    }

    public void push(int x) {
        myStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = myStack.pop();
        if (minStack.peek() == x) {
            minStack.pop();
        }
    }

    public int top() {
        return myStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */