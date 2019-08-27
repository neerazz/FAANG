package queueAndStack;

import java.util.ArrayList;

/*
https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
 */
public class MinStackImpl {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin() + " --> Return -3");
        minStack.pop();
        System.out.println(minStack.top() + " --> Returns 0.");
        System.out.println(minStack.getMin() + " --> Returns -2.");
    }
}

class MinStack {
    ArrayList<Integer> arrayList;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        arrayList = new ArrayList<>();
    }

    public void push(int x) {
        arrayList.add(x);
    }

    public void pop() {
        if (arrayList.size() > 0) {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public int top() {
        if (arrayList.size() > 0) {
            return arrayList.get(arrayList.size() - 1);
        }
        return -1;
    }

    public int getMin() {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arrayList.size(); i++) {
            minValue = Math.min(minValue, arrayList.get(i));
        }
        return minValue;
    }
}