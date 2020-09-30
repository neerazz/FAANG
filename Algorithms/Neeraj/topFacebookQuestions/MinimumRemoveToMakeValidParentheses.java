import java.util.*;

/**
 * Created on:  Jul 17, 2020
 * Questions: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 */
public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        System.out.println("******************************* Solution 1 *****************************************");
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));

        System.out.println("******************************* Solution 2 *****************************************");
        System.out.println(minRemoveToMakeValid_rev1("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid_rev1("a)b(c)d"));
        System.out.println(minRemoveToMakeValid_rev1("))(("));
        System.out.println(minRemoveToMakeValid_rev1("(a(b(c)d)"));
    }

    public static String minRemoveToMakeValid_rev1(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (isValid(poll)) return poll;
                for (int j = 0; j < poll.length(); j++) {
                    if (Character.isLetter(poll.charAt(j))) continue;
                    String cur = poll.substring(0, j) + poll.substring(j + 1);
                    queue.add(cur);
                }
            }
        }
        return "";
    }

    private static boolean isValid(String str) {
        int open = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')' && open-- == 0) return false;
        }
        return open == 0;
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
