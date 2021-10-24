import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Aug 18, 2020
 * Questions: https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class NumbersWithSameConsecutiveDifferences {
    public static void main(String[] args) {

    }

    public static int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> op = new ArrayList<>();
        helper(0, N, K, 0, 0, op);
        int[] result = new int[op.size()];
        for (int i = 0; i < op.size(); i++) result[i] = op.get(i);
        return result;
    }

    private static void helper(int collect, int total, int diff, int soFar, int pre, List<Integer> op) {
        if (collect == total) {
            op.add(soFar);
        } else if (collect > 1 && soFar == 0) return;
        else if (collect == 0) {
            for (int i = 1; i < 10; i++) {
                helper(collect + 1, total, diff, i, i, op);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (Math.abs(pre - i) == diff) {
                    helper(collect + 1, total, diff, soFar * 10 + i, i, op);
                }
            }
        }
    }
}
