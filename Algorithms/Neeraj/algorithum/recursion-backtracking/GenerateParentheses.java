import java.util.*;

/*
https://leetcode.com/explore/learn/card/recursion-ii/503/recursion-to-iteration/2772/
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class GenerateParentheses {
    static List<String> output;

    public static void main(final String[] args) {
        System.out.println(GenerateParentheses.generateParenthesis(3));
        System.out.println(GenerateParentheses.checkIfValidAndGetParenthesis(new LinkedList<>(Arrays.asList('(', ')', '(', ')', '(', ')'))));
    }

    public static List<String> generateParenthesis(final int n) {
        GenerateParentheses.output = new ArrayList<>();
        GenerateParentheses.backTrace(n, new LinkedList<>(), 0);
        return GenerateParentheses.output;
    }

    private static void backTrace(final int n, final LinkedList<Character> characters, final int currentValue) {
        if (characters.size() == n * 2) {
            final String value = GenerateParentheses.checkIfValidAndGetParenthesis(characters);
            if (value != null) GenerateParentheses.output.add(value);
            return;
        }
        for (int i = currentValue; i < n * 2; i++) {
//            Try with open brace
            characters.add('(');
            GenerateParentheses.backTrace(n, characters, i + 1);
            characters.removeLast();
//            Try with closed brace
            characters.add(')');
            GenerateParentheses.backTrace(n, characters, i + 1);
            characters.removeLast();
        }
    }

    private static String checkIfValidAndGetParenthesis(final LinkedList<Character> characters) {
        if (characters == null || characters.isEmpty()) return null;
        final StringBuilder sb = new StringBuilder();
        final Stack<Character> stack = new Stack<>();
        for (final Character c : characters) {
            sb.append(c);
            if (c == '(') {
                stack.add('(');
            } else {
                if (stack.isEmpty()) return null;
                final Character peek = stack.peek();
                if (peek == '(') {
                    stack.pop();
                } else {
                    return null;
                }
            }
        }
        return stack.isEmpty() ? sb.toString() : null;
    }

    public static List<String> generateParenthesis_optimal(final int n) {
        final List<String> ans = new ArrayList();
        GenerateParentheses.backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(final List<String> ans, final String cur, final int open, final int close, final int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        if (open < max)
            GenerateParentheses.backtrack(ans, cur + "(", open + 1, close, max);
        if (close < open)
            GenerateParentheses.backtrack(ans, cur + ")", open, close + 1, max);
    }
}
