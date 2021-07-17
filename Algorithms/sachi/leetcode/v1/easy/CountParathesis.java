package leetcode.v1.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;



/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.


 * Input: "()[]{}"
 * Output: true


 * Input: "([)]"
 * Output: false
 * https://leetcode.com/problems/valid-parentheses/
 */

//Sol - Use stack
//Pitfalls - Stack remove can throw exception.
public class CountParathesis {

    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }


    public static boolean isValid(String s) {
        Map<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put(']', '[');
        parenthesis.put('}', '{');
        parenthesis.put(')', '(');

        if (s == null) return true;
        if (s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (!parenthesis.containsKey(c)) {
                stack.add(c);
            } else if (!stack.isEmpty() && parenthesis.get(c) != stack.removeLast()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}