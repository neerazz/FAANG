import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on:  Jun 07, 2020
 * Questions:
 */
public class CoinChange2 {
    static Map<String, Integer> memo;

    public static void main(String[] args) {
        System.out.println("********************************** Method 1 *******************************");
        System.out.println(change(5, new int[]{1, 2, 5}) + " should be [4].");
        System.out.println(change(3, new int[]{2}) + " should be [0].");
        System.out.println(change(10, new int[]{10}) + " should be [1].");
        System.out.println(change(500, new int[]{3, 5, 7, 8, 9, 10, 11}) + " should be [35502874].");
    }

    public static int change(int amount, int[] coins) {
        memo = new HashMap<>();
        List<Integer> list = Arrays.stream(coins).boxed().sorted((v1, v2) -> v2 - v1).collect(Collectors.toList());
        return helper(0, amount, list);
    }

    private static int helper(int start, int amount, List<Integer> list) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        String val = start + "-" + amount;
        if (memo.containsKey(val)) return memo.get(val);
        int pos = 0;
        for (int end = start; end < list.size(); end++) {
            pos += helper(end, amount - list.get(end), list);
        }
        memo.put(val, pos);
        return pos;
    }
}
