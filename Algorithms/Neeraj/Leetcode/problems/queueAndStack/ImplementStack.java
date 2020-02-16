package problems.queueAndStack;

import java.util.ArrayList;

/*
https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1360/
 */
public class ImplementStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(-2);
        myStack.push(0);
        myStack.push(-3);
        System.out.println(myStack.getMin() + " --> Return -3");
        myStack.pop();
        System.out.println(myStack.top() + " --> Returns 0.");
        System.out.println(myStack.getMin() + " --> Returns -2.");
    }
}

class MyStack {
    ArrayList<Integer> arrayList;

    /**
     * initialize your data structure here.
     */
    public MyStack() {
        arrayList = new ArrayList<>();
    }

    public void push(int x) {
        arrayList.add(x);
    }

    public int pop() {
        int result = -1;
        if (arrayList.size() > 0) {
            result = arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        }
        return result;
    }

    public int top() {
        if (arrayList.size() > 0) {
            return arrayList.get(arrayList.size() - 1);
        }
        return -1;
    }

    public boolean empty() {
        return arrayList.isEmpty();
    }

    public int getMin() {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arrayList.size(); i++) {
            minValue = Math.min(minValue, arrayList.get(i));
        }
        return minValue;
    }
}