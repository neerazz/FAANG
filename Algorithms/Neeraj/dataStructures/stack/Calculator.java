import java.util.LinkedList;

/**
 * Created on:  Sep 03, 2021
 * Ref: https://app.coderpad.io/9PJQ27GY
 */
public class Calculator {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.evaluate("7 + 3 * 5 - 20 / 10"));
    }

    public int evaluate(String expression) {
        if (expression == null || expression.length() == 0) return 0;
        String[] split = expression.split("\\s+");
        LinkedList<String> stack = new LinkedList<>();
        int len = split.length, i = 1, j = 2;
        stack.add(split[0]);
        while (j < len) {
            String ope = split[i];
            String val = split[j];
            if (ope.equals("*") || ope.equals("/")) {
//                String pre = stack.pop();
                String pre = stack.removeLast();
                stack.add(solve(pre, ope, val));
            } else {
                stack.add(ope);
                stack.add(val);
            }
            j += 2;
            i += 2;
        }
        int result = Integer.parseInt(stack.removeFirst());
        while (stack.size() >= 2) {
            String ope = stack.removeFirst();
            int cur = Integer.parseInt(stack.removeFirst());
            result = ope(result, ope, cur);
        }
        return result;
    }

    String solve(String pre, String opr, String cur) {
        int preInt = Integer.parseInt(pre);
        int curInt = Integer.parseInt(cur);
        int result = opr.equals("*") ? preInt * curInt : preInt / curInt;
        return String.valueOf(result);
    }

    public int evaluate_helper(String expression) {
        if (expression == null || expression.length() == 0) return 0;
        String[] split = expression.split("\\s+");
        int len = split.length, i = 1, j = 2;
        int result = Integer.parseInt(split[0]);
        while (j < len) {
            int curVal = Integer.parseInt(split[j]);
            result = ope(result, split[i], curVal);
            j += 2;
            i += 2;
        }
        return result;
    }

    private int ope(int a, String ope, int b) {
        if (ope.equals("+")) {
            return a + b;
        } else {
            return a - b;
        }
    }
}
