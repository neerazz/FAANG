import java.util.*;

/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()") + " = [\"()()()\", \"(())()\"] ");
        System.out.println(removeInvalidParentheses("(a)())()") + " = [\"(a)()()\", \"(a())()\"]");
        System.out.println(removeInvalidParentheses(")(") + " = []");
        System.out.println(removeInvalidParentheses("()()(") + " = [\"()()\"]");
    }

    public static List<String> removeInvalidParentheses(String s) {
        LinkedList<Integer> invalidClose = new LinkedList<>();
        LinkedList<Integer> invalidOpen = new LinkedList<>();
//        1 -> asci of '(' or ')'
//        0 -> index of the invalidClose paranthasis.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.add(i);
            } else if (cur == ')') {
                if (stack.isEmpty()) {
                    invalidClose.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        invalidOpen.addAll(stack);
//        invalidClose.forEach(arr -> System.out.println(Arrays.toString(arr)));
        return new ArrayList<>(helper(s, 0, invalidOpen, invalidClose));
    }

    private static Set<String> helper(String s, int index, LinkedList<Integer> inValidOpen, LinkedList<Integer> invalidClose) {
        Set<String> op = new HashSet<>();
        if (index > s.length()) {
            return op;
        } else if (index == s.length()) {
            if (invalidClose.isEmpty()) {
                op.add("");
                return op;
            }
            return op;
        } else if (invalidClose.isEmpty() && inValidOpen.isEmpty()) {
            op.add(s.substring(index));
            return op;
        } else if (s.charAt(index) == '(' && !inValidOpen.isEmpty() && inValidOpen.getFirst() <= index) {
//            For open brace the possibility check needs to be done only after invalid char
            int removeIndex = inValidOpen.removeFirst();
            op.addAll(helper(s, index + 1, inValidOpen, invalidClose));
            inValidOpen.addFirst(removeIndex);
        } else if (s.charAt(index) == ')' && !invalidClose.isEmpty() && invalidClose.getFirst() >= index) {
            int removeIndex = invalidClose.removeFirst();
//                If there is any invalid paranthasis after the current index and the current char is same as the invalid char.
//                Make a recursive call by removing the entry and without removing the entry.
            op.addAll(helper(s, index + 1, inValidOpen, invalidClose));
            invalidClose.addFirst(removeIndex);
        }
        Set<String> next = helper(s, index + 1, inValidOpen, invalidClose);
        for (String temp : next) {
            op.add(s.charAt(index) + temp);
        }
        return op;
    }
}
