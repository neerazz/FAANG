package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import javax.swing.*;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class StackWithMax {

    @EpiTest(testDataFile = "stack_with_max.tsv")
    public static void stackTest(List<StackOp> ops) throws TestFailure {
        try {
            Stack s = new Stack();
            int result;
            for (StackOp op : ops) {
                switch (op.op) {
                    case "Stack":
                        s = new Stack();
                        break;
                    case "push":
                        s.push(op.arg);
                        break;
                    case "pop":
                        result = s.pop();
                        if (result != op.arg) {
                            throw new TestFailure("Pop: expected " + op.arg +
                                    ", got " + result);
                        }
                        break;
                    case "max":
                        result = s.max();
                        if (result != op.arg) {
                            throw new TestFailure("Max: expected " + op.arg +
                                    ", got " + result);
                        }
                        break;
                    case "empty":
                        result = s.empty() ? 1 : 0;
                        if (result != op.arg) {
                            throw new TestFailure("Empty: expected " + op.arg +
                                    ", got " + s);
                        }
                        break;
                    default:
                        throw new RuntimeException("Unsupported stack operation: " + op.op);
                }
            }
        } catch (NoSuchElementException e) {
            throw new TestFailure("Unexpected NoSuchElement exception");
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "StackWithMax.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }

    public static class Stack {

        Deque<Integer> myStack = new LinkedList<>();
        Integer maxVal = Integer.MIN_VALUE;

        public boolean empty() {
            return myStack.isEmpty();
        }

        public Integer max() {
            return maxVal;
        }

        public Integer pop() {
            if (maxVal.equals(myStack.peek())) {
                //Compute new MAX Val
                maxVal = Integer.MIN_VALUE;
                Integer popValue = myStack.pop();
                Iterator<Integer> it = myStack.iterator();
                while (it.hasNext()) {
                    maxVal = Math.max(maxVal, (Integer) it.next());
                }
                return popValue;

            }
            return myStack.pop();
        }

        public void push(Integer x) {
            maxVal = Math.max(x, maxVal);
            myStack.push(x);
        }
    }

    @EpiUserType(ctorParams = {String.class, int.class})
    public static class StackOp {
        public String op;
        public int arg;

        public StackOp(String op, int arg) {
            this.op = op;
            this.arg = arg;
        }
    }
}
