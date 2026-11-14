import java.util.Stack;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.designgurus.io/course-play/grokking-the-coding-interview/doc/problem-challenge-2-comparing-strings-containing-backspaces-medium
 */

public class BackspaceCompare {

    public static void main(String[] args) {

    }

    public static boolean compare(String str1, String str2) {
        str1 = BackspaceCompare.resolveString(str1);
        str2 = BackspaceCompare.resolveString(str2);
        return str1.equals(str2);
    }

    private static String resolveString(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
