package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Stack;

public class EvaluateRpn {
    @EpiTest(testDataFile = "evaluate_rpn.tsv")

    public static int eval(String expression) {
        Stack<Integer> stack = new Stack<>();
        int val = 0;
        for (int i = 0; i < expression.length(); i++) {
            char cur = expression.charAt(i);
            if (cur == ',') {
                stack.add(val);
                val = 0;
            } else if (Character.isDigit(cur)) {
                val = val * 10 + (cur - '0');
            } else {
                int second = stack.pop();
                int first = stack.pop();
                if (cur == '+') stack.add(first + second);
                if (cur == '-') stack.add(first - second);
                if (cur == '*') stack.add(first * second);
                if (cur == '/') stack.add(first / second);
            }
        }
        return stack.isEmpty() ? 0 : stack.peek();
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "EvaluateRpn.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
