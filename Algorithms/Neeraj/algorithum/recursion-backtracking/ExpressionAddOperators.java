import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on:  Jul 16, 2020
 * Questions: https://leetcode.com/problems/expression-add-operators/
 */
public class ExpressionAddOperators {

    static Set<String> result;

    public static void main(String[] args) {
//        System.out.println(addOperators("123", 6) + " should be [\"1+2+3\", \"1*2*3\"] ");
//        System.out.println(addOperators("232", 8) + " should be [\"2*3+2\", \"2+3*2\"] ");
//        System.out.println(addOperators("105", 5) + " should be [\"1*0+5\",\"10-5\"] ");
//        System.out.println(addOperators("00", 0) + " should be [\"0+0\", \"0-0\", \"0*0\"] ");
//        System.out.println(addOperators("3456237490", 9191) + " should be [] ");
        System.out.println(addOperators("2147483648", -2147483648) + " should be [] ");
    }

    public static List<String> addOperators(String num, int target) {
        result = new HashSet<>();
        if (num == null || num.length() == 0 || target == Integer.MIN_VALUE) return new ArrayList<>(result);
        dfs(num, target, 0, 0, 0, "");
        return new ArrayList<>(result);
    }

    private static void dfs(String num, int target, int idx, int pre, int val, String soFar) {
        if (num.length() == idx) {
            if (val == target) result.add(soFar);
        } else {
            int cur = 0;
            for (int i = idx; i < num.length(); i++) {
                cur = cur * 10 + (num.charAt(i) - '0');
//                The expression should not include number with leading zero.
//                Like: we have 1 + 05 or 1 * 05 since 05 won't be a valid operand
                if (num.charAt(idx) == '0' && i - idx > 0) continue;
                if (soFar.isEmpty()) {
                    dfs(num, target, i + 1, cur, cur, "" + cur);
                } else {
                    dfs(num, target, i + 1, cur, val + cur, soFar + "+" + cur);
                    dfs(num, target, i + 1, -cur, val - cur, soFar + "-" + cur);
//            If you put * between two values, Then per have to revert back the previous action and then multiply the previous with current.
                    dfs(num, target, i + 1, cur * pre, val - pre + pre * cur, soFar + "*" + cur);
                }
            }
        }
    }
}
