import java.util.LinkedList;
import java.util.Queue;

/**
 * Created on:  Nov 15, 2020
 * Questions: https://leetcode.com/discuss/interview-question/560088/Uber-phone-interview-question
 */

public class SolveExpression {

    public static void main(String[] args) {
        System.out.println(evaluate("3"));
        System.out.println(evaluate("( + 1 2 )"));
        System.out.println(evaluate("( + 3 4 5 )"));
        System.out.println(evaluate("( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ) 7 ) 3 )"));
        System.out.println(evaluate("( + 7 ( * 8 12 ) ( * 2 ( + 9 4 ( * 1 3 ) ( + 1 3 ) ) 7 ) 3 )"));
    }

    //    Assuming that the input have no any invalid chars except number, ( , ) , + and *
    private static int evaluate(String exp) {
        String[] split = exp.split(" ");
        Queue<String> queue = new LinkedList<>();
        for (String val : split) queue.add(val);
        return helper(queue);
    }

    private static int helper(Queue<String> queue) {
        int cur = -1;
        String op = "";
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            if (poll.equals("(")) {
                int next = helper(queue);
                cur = getValue(cur, next, op);
            } else if (poll.equals(")")) {
                break;
            } else if (isExpression(poll)) {
                op = poll;
            } else {
                cur = getValue(cur, Integer.parseInt(poll), op);
            }
        }
        return cur;
    }

    private static int getValue(int cur, int num, String op) {
//        This will handle the case when checking the first number.
//          Ex : * 2 3. When first time this method is called, with (-1, 2, *). It should return 2, the calculation should not be done.
        if (cur == -1) return num;
        return switch (op) {
            case "+" -> cur + num;
            case "*" -> cur * num;
            default -> num;
        };
    }

    private static boolean isExpression(String inp) {
        return switch (inp) {
            case "+", "*" -> true;
            default -> false;
        };
    }

}
