import java.util.Stack;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
Example 1:
Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:
Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {
    public static void main(String[] args) {

    }

    // https://www.youtube.com/watch?v=r0-zx5ejdq0
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.add(i);
            } else {
//                 Remove the current opening brace index.
                stack.pop();
                if (stack.isEmpty()) {
//                     If stack is empty after removing the last opening brase
                    stack.add(i);
                }
//                 Now calculate the new max with curindex - the top element of stack.
                max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
}
