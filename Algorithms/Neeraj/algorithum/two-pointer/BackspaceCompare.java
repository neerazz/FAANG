import java.util.Stack;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/g7pBzR12YPl
 */

public class BackspaceCompare {

    public static void main(final String[] args) {

    }

    public static boolean compare(String str1, String str2) {
        str1 = BackspaceCompare.resolveString(str1);
        str2 = BackspaceCompare.resolveString(str2);
        return str1.equals(str2);
    }

    private static String resolveString(final String str) {
        final Stack<Character> stack = new Stack<>();
        for (final char c : str.toCharArray()) {
            if (c == '#') {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        final StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
