import java.util.Arrays;

/**
 * Created on:  Aug 15, 2021
 * Ref : https://leetcode.com/problems/optimal-account-balancing/
 */
public class OptimalAccountBalancing {
    public static void main(String[] args) {
        System.out.println(minTransfers(new int[][]{{1, 5, 1}, {3, 5, 3}, {5, 2, 2}, {5, 4, 2}}) + " = 3");
        System.out.println(minTransfers(new int[][]{{1, 5, 8}, {8, 9, 8}, {2, 3, 9}, {4, 3, 1}}) + " = 4");
    }

    public static int minTransfers(int[][] trans) {
        int[] amounts = new int[30];
        for (int[] tran : trans) {
            int from = tran[0], to = tran[1], amount = tran[2];
            amounts[from] -= amount;
            amounts[to] += amount;
        }
        Arrays.sort(amounts);
        int result = helper(amounts, amounts.length - 1);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    static int helper(int[] amounts, int end) {
//        Once all the amounts are settled then there is no need to make any transactions.
        if (amounts[end] == 0) return 0;
//        By default, assume that the settlement can't be done
        int cur = Integer.MAX_VALUE;
        for (int i = 0; i < end; i++) {
            if (amounts[i] >= 0) continue;
//            At each step, try to solve by taking money from different person
            int curNeg = amounts[i], curPos = amounts[end];
            if (Math.abs(curNeg) == curPos) {
                amounts[i] = amounts[end] = 0;
                cur = Math.min(cur, 1 + helper(amounts, end - 1));
            } else if (Math.abs(curNeg) > curPos) {
                amounts[i] += curPos;
                amounts[end] = 0;
                cur = Math.min(1 + helper(amounts, end - 1), cur);
            } else {
                amounts[i] = 0;
                amounts[end] -= Math.abs(curNeg);
                cur = Math.min(cur, 1 + helper(amounts, end));
            }
            amounts[i] = curNeg;
            amounts[end] = curPos;
        }
        return cur;
    }
}
