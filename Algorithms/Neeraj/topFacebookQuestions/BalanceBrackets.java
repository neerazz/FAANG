import java.util.Stack;

/**
 * Created on:  Sep 09, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=211548593612944
 */
public class BalanceBrackets {
    public static void main(String[] args) {

    }

    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char cur : s.toCharArray()) {
            if (cur == '(' || cur == '{' || cur == '[') stack.add(cur);
            else if (stack.isEmpty()) return false;
            else if (cur == ')' && stack.pop() != '(') return false;
            else if (cur == ']' && stack.pop() != '[') return false;
            else if (cur == '}' && stack.pop() != '{') return false;
        }
        return stack.isEmpty();
    }
}
