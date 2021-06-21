package biweekly.biweekly54;

/**
 * Created on:  Jun 12, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-54/problems/minimum-cost-to-change-the-final-value-of-expression/
 */

public class MinimumCostToChangeTheFinalValueOfExpression {

    public static void main(String[] args) {

    }

    public static int minOperationsToFlip(String expression) {
        return -1;
    }

    private static int evaluate(String str) {
        String reduced = reduceParenthesis(str);
        int val = 0;
        char exp = ' ';
        for (char cur : reduced.toCharArray()) {
            if (cur == '&' || cur == '|') {
                exp = cur;
            } else {
                int curNum = cur - '0';
                if (exp == ' ') val = curNum;
                else if (exp == '&') val = val & curNum;
                else val = val | curNum;
            }
        }
        return val;
    }

    private static String reduceParenthesis(String str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length(), i = 0;
        while (i < len) {
            char cur = str.charAt(i);
            if (cur == '(') {
//                Find the balancing closer.
                int j = i, open = 1;
                while (++j < len) {
                    cur = str.charAt(j);
                    if (cur == '(') open++;
                    else if (cur == ')') open--;
                    if (open == 0) break;
                }
                sb.append(reduceParenthesis(str.substring(i + 1, j)));
                i = j + 1;
            } else {
                sb.append(cur);
                i++;
            }
        }
        return sb.toString();
    }
}