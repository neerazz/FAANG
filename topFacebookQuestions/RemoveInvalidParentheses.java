import java.util.*;

/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println("********************************** Solution 1 ***********************************");
        System.out.println(removeInvalidParentheses("()())()") + " = [\"()()()\", \"(())()\"] ");
        System.out.println(removeInvalidParentheses("(a)())()") + " = [\"(a)()()\", \"(a())()\"]");
        System.out.println(removeInvalidParentheses(")(") + " = []");
        System.out.println(removeInvalidParentheses("()()(") + " = [\"()()\"]");
        System.out.println("********************************** Solution 2 ***********************************");
        System.out.println(removeInvalidParentheses_rev1("()())()") + " = [\"()()()\", \"(())()\"] ");
        System.out.println(removeInvalidParentheses_rev1("(a)())()") + " = [\"(a)()()\", \"(a())()\"]");
        System.out.println(removeInvalidParentheses_rev1(")(") + " = []");
        System.out.println(removeInvalidParentheses_rev1("()()(") + " = [\"()()\"]");
    }

    public static List<String> removeInvalidParentheses_rev1(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        List<String> op = new ArrayList<>();
        boolean matchFound = false;
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
//                System.out.println("poll = " + poll);
                int balance = getUnBalancedParentheses(poll);
                if (balance == 0) {
                    op.add(poll);
                    matchFound = true;
                } else {
                    for (int k = 0; k < poll.length(); k++) {
                        if ((poll.charAt(k) == '(' && balance == -1) || (poll.charAt(k) == ')' && balance == 1)) {
                            String cur = poll.substring(0, k) + poll.substring(k + 1);
//                            System.out.println("cur = " + cur);
                            if (!visited.contains(cur)) {
                                queue.add(cur);
                                visited.add(cur);
                            }
                        }
                    }
                }
            }
//            System.out.println("Queue = " + queue.toString());
            if (matchFound) break;
        }
        // if(op.size() == 0) op.add("");
        return op;
    }

    //     Returns 0 -> matched, -1 : left unmatch, 1 : right unmatch
    private static int getUnBalancedParentheses(String input) {
        int open = 0;
        for (char c : input.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) open--;
                else return 1;
            }
        }
        if (open == 0) return 0;
        return -1;
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
