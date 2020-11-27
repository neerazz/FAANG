import java.util.*;
import java.io.*;
import java.util.function.BiFunction;

/**
 * Created on:  Nov 24, 2020
 * Questions: https://leetcode.com/explore/challenge/card/november-leetcoding-challenge/567/week-4-november-22nd-november-28th/3542/
 */

public class BasicCalculatorII {

    public static void main(String[] args) {
        System.out.println("********************************* Solution 1 ************************************");
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
        System.out.println(calculate("1+2*5/3+6/4*2"));
        System.out.println("********************************* Solution 2 ************************************");
        System.out.println(calculate_optimal("3+2*2"));
        System.out.println(calculate_optimal(" 3/2 "));
        System.out.println(calculate_optimal(" 3+5 / 2 "));
        System.out.println(calculate_optimal("1+2*5/3+6/4*2"));
    }

    public static int calculate_optimal(String s) {
        Stack<Integer> stack = new Stack<>();
        int pre = 0;
        char preOperation = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                pre = pre * 10 + (c - '0');
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (preOperation == '+') stack.add(pre);
                if (preOperation == '-') stack.add(-1 * pre);
                if (preOperation == '*') stack.add(stack.pop() * pre);
                if (preOperation == '/') stack.add(stack.pop() / pre);
                preOperation = c;
                pre = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static int calculate(String s) {
        List<String> list = new ArrayList<>();
        int pre = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                pre = pre == -1 ? (c - '0') : pre * 10 + (c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                list.add("" + pre);
                list.add("" + c);
                pre = -1;
            }
        }
        list.add("" + pre);
//        System.out.println("List = " + list);
//        list = computeMul(list);
        list = compute(list, "*", (a, b) -> a * b, "/", (a, b) -> a / b);
//        System.out.println("List = " + list);
//        list = computeDiv(list);
//        System.out.println("List = " + list);
//        list = computeAdd(list);
        list = compute(list, "+", (a, b) -> a + b, "-", (a, b) -> a - b);
//        System.out.println("List = " + list);
//        list = computeSub(list);
//        System.out.println("List = " + list);
        return Integer.parseInt(list.get(0));
    }

    private static List<String> compute(List<String> input, String opr1, BiFunction<Integer, Integer, Integer> function1, String opr2, BiFunction<Integer, Integer, Integer> function2) {
        Stack<String> result = new Stack<>();
        boolean skip = false;
        for (int i = 0; i < input.size(); i++) {
            String cur = input.get(i);
            if (cur.equals(opr1)) {
                int pre = Integer.parseInt(result.pop());
                int next = Integer.parseInt(input.get(i + 1));
                result.add("" + function1.apply(pre, next));
                skip = true;
            } else if (cur.equals(opr2)) {
                int pre = Integer.parseInt(result.pop());
                int next = Integer.parseInt(input.get(i + 1));
                result.add("" + function2.apply(pre, next));
                skip = true;
            } else if (skip) {
                skip = false;
            } else {
                result.add(cur);
            }
        }
        return new ArrayList<>(result);
    }

    private static List<String> computeDiv(List<String> input) {
        Stack<String> result = new Stack<>();
        boolean skip = false;
        for (int i = 0; i < input.size(); i++) {
            String cur = input.get(i);
            if (cur.equals("/")) {
                int pre = Integer.parseInt(result.pop());
                int next = Integer.parseInt(input.get(i + 1));
                result.add("" + (pre / next));
                skip = true;
            } else if (skip) {
                skip = false;
            } else {
                result.add(cur);
            }
        }
        return new ArrayList<>(result);
    }

    private static List<String> computeMul(List<String> input) {
        Stack<String> result = new Stack<>();
        boolean skip = false;
        for (int i = 0; i < input.size(); i++) {
            String cur = input.get(i);
            if (cur.equals("*")) {
                int pre = Integer.parseInt(result.pop());
                int next = Integer.parseInt(input.get(i + 1));
                result.add("" + (pre * next));
                skip = true;
            } else if (skip) {
                skip = false;
            } else {
                result.add(cur);
            }
        }
        return new ArrayList<>(result);
    }

    private static List<String> computeSub(List<String> input) {
        Stack<String> result = new Stack<>();
        boolean skip = false;
        for (int i = 0; i < input.size(); i++) {
            String cur = input.get(i);
            if (cur.equals("-")) {
                int pre = Integer.parseInt(result.pop());
                int next = Integer.parseInt(input.get(i + 1));
                result.add("" + (pre - next));
                skip = true;
            } else if (skip) {
                skip = false;
            } else {
                result.add(cur);
            }
        }
        return new ArrayList<>(result);
    }

    private static List<String> computeAdd(List<String> input) {
        Stack<String> result = new Stack<>();
        boolean skip = false;
        for (int i = 0; i < input.size(); i++) {
            String cur = input.get(i);
            if (cur.equals("+")) {
                int pre = Integer.parseInt(result.pop());
                int next = Integer.parseInt(input.get(i + 1));
                result.add("" + (pre + next));
                skip = true;
            } else if (skip) {
                skip = false;
            } else {
                result.add(cur);
            }
        }
        return new ArrayList<>(result);
    }
}
