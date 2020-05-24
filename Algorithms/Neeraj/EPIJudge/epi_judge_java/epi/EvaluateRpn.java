package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Stack;

public class EvaluateRpn {
    @EpiTest(testDataFile = "evaluate_rpn.tsv")

    public static int eval(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] split = expression.split(",");
        for (String val : split) {
            if (val.length() == 1 && !Character.isDigit(val.charAt(0))) {
                int second = stack.pop();
                int first = stack.pop();
                if (val.charAt(0) == '+') stack.add(first + second);
                if (val.charAt(0) == '-') stack.add(first - second);
                if (val.charAt(0) == '*') stack.add(first * second);
                if (val.charAt(0) == '/') stack.add(first / second);
            } else {
                stack.add(Integer.parseInt(val));
            }
        }
        return stack.isEmpty() ? -1 : stack.peek();
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
