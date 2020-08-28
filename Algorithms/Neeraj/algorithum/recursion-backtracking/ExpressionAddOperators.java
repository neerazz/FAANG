import java.util.*;

/**
 * Created on:  Jul 16, 2020
 * Questions: https://leetcode.com/problems/expression-add-operators/
 */
public class ExpressionAddOperators {

    static Set<String> result;

    public static void main(String[] args) {
        System.out.println("********************************** Solution 1 **********************************");
        System.out.println(addOperators("123", 6) + " should be [\"1+2+3\", \"1*2*3\"] ");
        System.out.println(addOperators("232", 8) + " should be [\"2*3+2\", \"2+3*2\"] ");
        System.out.println(addOperators("105", 5) + " should be [\"1*0+5\",\"10-5\"] ");
        System.out.println(addOperators("00", 0) + " should be [\"0+0\", \"0-0\", \"0*0\"] ");
        System.out.println(addOperators("3456237490", 9191) + " should be [] ");
        System.out.println(addOperators("2147483648", -2147483648) + " should be [] ");

        System.out.println("********************************** Solution 2 **********************************");
        System.out.println(addOperators_rev1("123", 6) + " should be [\"1+2+3\", \"1*2*3\"] ");
        System.out.println(addOperators_rev1("232", 8) + " should be [\"2*3+2\", \"2+3*2\"] ");
        System.out.println(addOperators_rev1("105", 5) + " should be [\"1*0+5\",\"10-5\"] ");
        System.out.println(addOperators_rev1("00", 0) + " should be [\"0+0\", \"0-0\", \"0*0\"] ");
        System.out.println(addOperators_rev1("3456237490", 9191) + " should be [] ");
        System.out.println(addOperators_rev1("2147483648", -2147483648) + " should be [] ");
    }

    /**
     * @implNote Start with first number and make recursive call with each number in string, try all the below combinations:
     * <p>
     * 1. When add is chosen: Add the cur val with pre value. and append it to string. Also increase the calculated value, And make a recursive call.
     * <p>
     * 2. When Subtract is chosen: Subtract the current value with previous, append to string & update the calculated value. And make a recursive call.
     * <p>
     * 3. When multiply is chosen: Then the pre value should be reduced from teh computed value and add the product of pre and cur. THis way you are only multiplying only with the pre digit. And make a recursive call.
     */
    public static List<String> addOperators_rev1(String num, int target) {
        result = new HashSet<>();
        if (num == null || num.length() == 0 || target == Integer.MIN_VALUE) return new ArrayList<>(result);
        helper(num, target, 0, 0, 0, "");
        return new ArrayList<>(result);
    }

    private static void helper(String num, int target, int idx, int pre, int val, String soFar) {
        if (idx == num.length()) {
            if (val == target) {
                result.add(soFar);
            }
        } else {
            int cur = 0;
//             Loop from start till end by selecting all possibel combinations.
            for (int i = idx; i < num.length(); i++) {
                cur = cur * 10 + (num.charAt(i) - '0');
                if (num.charAt(idx) == '0' && i - idx > 0) continue;
//                 When the start index is 0, then you can only chose that number, you cannot combine with other number.
                if (soFar.length() == 0) {
                    helper(num, target, i + 1, cur, cur, soFar + cur);
                } else {
//                     Try all three char.
                    helper(num, target, i + 1, cur, val + cur, soFar + "+" + cur);
                    helper(num, target, i + 1, -cur, val - cur, soFar + "-" + cur);
                    helper(num, target, i + 1, pre * cur, val - pre + pre * cur, soFar + "*" + cur);
                }
            }
        }
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
