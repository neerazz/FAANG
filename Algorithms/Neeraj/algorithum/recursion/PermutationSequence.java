import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jun 20, 2020
 * Questions:https://leetcode.com/problems/permutation-sequence
 */
public class PermutationSequence {
    static List<String> list;

    public static void main(String[] args) {

    }

    public static String getPermutation(int n, int k) {
        list = new ArrayList<>();
        boolean[] taken = new boolean[n + 1];
        helper(n, k, taken, "");
        return list.get(k - 1);
    }

    private static void helper(int n, int k, boolean[] taken, String sofar) {
        if (list.size() >= k) return;
        if (sofar.length() == n) {
            list.add(sofar);
        } else {
            for (int i = 1; i <= n; i++) {
                if (!taken[i]) {
                    taken[i] = true;
                    helper(n, k, taken, sofar + i);
                    taken[i] = false;
                }
            }
        }
    }
}
