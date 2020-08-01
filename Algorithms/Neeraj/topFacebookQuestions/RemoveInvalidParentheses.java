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
        List<String> op = new ArrayList<>();
        if (s == null) return op;

//        Do a BFS by trying to remove one item at a time.
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(s);
        queue.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {

            s = queue.poll();
            if (isValid(s)) {
//                Once a string is found. Stop removing further parenthesis.
//                  Because we need all combinations of string by removing minimum number of invalid parentheses.
                op.add(s);
                found = true;
            } else if (!found) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
//                    Only parenthesis should be removed.
                    String cur = s.substring(0, i) + s.substring(i + 1);
                    if (visited.add(cur)) {
                        queue.add(cur);
                    }
                }
            }
        }

        return op;
    }

    private static boolean isValid(String poll) {
        int open = 0;
        for (char c : poll.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open <= 0) return false;
                open--;
            }
        }
        return open == 0;
    }
}
