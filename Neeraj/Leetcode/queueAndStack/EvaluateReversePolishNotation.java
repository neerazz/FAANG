package queueAndStack;

import java.util.Stack;

/*
https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1394/
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Note: Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:
Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:
Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:
Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation:
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        System.out.println("Answer is:" + evalRPN(new String[]{"2", "1", "+", "3", "*"}) + " solution should be [9].");
        System.out.println("Answer is:" + evalRPN(new String[]{"4", "13", "5", "/", "+"}) + " solution should be [6].");
        System.out.println("Answer is:" + evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}) + " solution should be [22].");
    }
//    Loop through the given token. If integer keep adding it to stack or else. Take two numbers from stack and perform that operation and push the result back to stack.
    public static int evalRPN(String[] tokens) {
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String currentString = tokens[i];
            if (currentString.equals("+") || currentString.equals("-") || currentString.equals("/") || currentString.equals("*")){
                int a = integerStack.pop();
                int b = integerStack.pop();
                int output = 0;
                switch (currentString.trim()){
                    case "+":
                        output = a+b;
                        break;
                    case "-":
                        output = b-a;
                        break;
                    case "*":
                        output = a*b;
                        break;
                    case "/":
                        output = b/a;
                        break;
                }
                integerStack.push(output);
            }
            else integerStack.push(Integer.parseInt(currentString));
        }
        return integerStack.peek();
    }
}
