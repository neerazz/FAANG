import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Oct 07, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/gx7O7nO0R8l
 */

public class EvaluateExpression {

    public static List<Integer> diffWaysToEvaluateExpression(String input) {
        List<Integer> result = new ArrayList<>();
        try {
            result.add(Integer.parseInt(input));
        } catch (NumberFormatException ex) {
            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);
                if (!Character.isDigit(cur)) {
                    List<Integer> left = diffWaysToEvaluateExpression(input.substring(0, i));
                    List<Integer> right = diffWaysToEvaluateExpression(input.substring(i + 1));
                    for (int l : left) {
                        for (int r : right) {
                            result.add(getValue(l, r, cur));
                        }
                    }
                }
            }
        }
        return result;
    }

    private static int getValue(int a, int b, char o) {
        if (o == '+') return a + b;
        if (o == '-') return a - b;
        return a * b;
    }

    public static void main(String[] args) {
        List<Integer> result = EvaluateExpression.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        result = EvaluateExpression.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }
}
