import java.util.Scanner;
import java.util.Stack;

/*
https://www.hackerrank.com/challenges/java-stack/problem
Sample Input
{}()
({()})
{}(
[]
Sample Output
true
true
false
true
 */
public class JavaStack {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(checkParentheses(input));
        }
    }

    private static boolean checkParentheses(String s) {
        if (s.isEmpty()) return true;
        if (s.length() == 1) return false;
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String currentValue = String.valueOf(s.charAt(i));
            if (currentValue.equals("(") || currentValue.equals("[") || currentValue.equals("{"))
                stringStack.add(currentValue);
            else {
                if (stringStack.isEmpty()) return false;
                String lastValue = stringStack.pop();
                if (currentValue.equals(")") && !lastValue.equals("(")) return false;
                if (currentValue.equals("]") && !lastValue.equals("[")) return false;
                if (currentValue.equals("}") && !lastValue.equals("{")) return false;
            }
        }
        return stringStack.isEmpty();
    }
}
