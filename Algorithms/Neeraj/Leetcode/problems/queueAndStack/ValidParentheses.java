package problems.queueAndStack;

import java.util.Stack;

/*
https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println("Answer is :" + isValid("()") + " should be [true].");
        System.out.println("Answer is :" + isValid("()[]{}") + " should be [true].");
        System.out.println("Answer is :" + isValid("(]") + " should be [false].");
        System.out.println("Answer is :" + isValid("([)]") + " should be [false].");
        System.out.println("Answer is :" + isValid("{[]}") + " should be [true].");
        System.out.println("Answer is :" + isValid("){") + " should be [true].");
        System.out.println("Answer is :" + isValid("") + " should be [true].");
    }

    public static boolean isValid(String s) {
        if (s.isEmpty()) return true;
        if (s.length() == 1) return false;
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String currentValue = String.valueOf(s.charAt(i));
            if (currentValue.equals("(") || currentValue.equals("[") || currentValue.equals("{"))
                stringStack.add(currentValue);
            else {
                if (stringStack.isEmpty()) return false;
                String lastValue = stringStack.pop();
                if (currentValue.equals(")") && !lastValue.equals("(")) return false;
                if (currentValue.equals("]") && !lastValue.equals("[")) return false;
                if (currentValue.equals("}") && !lastValue.equals("{")) return false;
            }
        }
        return stringStack.isEmpty();
    }
}
