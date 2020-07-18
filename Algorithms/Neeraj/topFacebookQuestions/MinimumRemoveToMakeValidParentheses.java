import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {

    }

    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Set<Integer> remove = new HashSet<>();
        Stack<Integer> queue = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                queue.add(i);
            } else if (chars[i] == ')') {
                if (queue.isEmpty()) remove.add(i);
                else queue.pop();
            }
        }
        remove.addAll(queue);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (remove.contains(i)) continue;
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
