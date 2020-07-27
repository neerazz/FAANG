import java.util.*;

/**
 * Created on:  Jul 26, 2020
 * Questions: https://leetcode.com/problems/expression-add-operators/
 */
public class ExpressionAddOperators {
    static Set<String> op;

    public static void main(String[] args) {

    }

    public static List<String> addOperators(String num, int target) {
        op = new HashSet<>();
        if (num == null || num.length() == 0 || target == Integer.MIN_VALUE) return new ArrayList<>(op);
        dfs(num, target, 0, 0, 0, "");
        return new ArrayList<>(op);
    }

    private static void dfs(String num, int target, int start, int pre, int val, String soFar) {
        if (start == num.length()) {
            if (val == target) {
                op.add(soFar);
            }
        } else if (num.charAt(start) == '0') {
//             If the starting digit is zero then append make only char.
            int cur = 0;
            if (soFar.length() == 0) {
                dfs(num, target, start + 1, cur, val + cur, "" + cur);
            } else {
                dfs(num, target, start + 1, cur, val + cur, soFar + "+" + cur);
                dfs(num, target, start + 1, -cur, val - cur, soFar + "-" + cur);
                dfs(num, target, start + 1, pre * cur, val - pre + (pre * cur), soFar + "*" + cur);
            }
        } else {
            int cur = 0;
            for (int end = start; end < num.length(); end++) {
                cur = cur * 10 + (num.charAt(end) - '0');
                if (soFar.length() == 0) {
                    dfs(num, target, start + 1, cur, val + cur, "" + cur);
                } else {
                    dfs(num, target, start + 1, cur, val + cur, soFar + "+" + cur);
                    dfs(num, target, start + 1, -cur, val - cur, soFar + "+" + cur);
                    dfs(num, target, start + 1, pre * cur, val - pre + (pre * cur), soFar + "*" + cur);
                }
            }
        }
    }
}
