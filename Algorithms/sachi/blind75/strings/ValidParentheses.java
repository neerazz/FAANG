package blind75.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
https://leetcode.com/problems/valid-parentheses/
P

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid. An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([)]"
Output: false

Example 5:
Input: s = "{[]}"
Output: true

 */
public class ValidParentheses {


    //Insight - Use stacks
    //Only add opening brackets to stack.
    //When you get a closing bracket - pop and match
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char out = stack.pop();
                if (out != map.get(c)) return false;
            }
        }
        return stack.isEmpty();
    }

}
