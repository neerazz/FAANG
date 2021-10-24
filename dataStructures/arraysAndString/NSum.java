/*
    Created on:  May 09, 2020
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Questions:
 */
public class NSum {
    static List<Integer[]> op;

    public static void main(String[] args) {
        threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        op = new ArrayList<>();
        if (array.length < 3) return op;
        Arrays.sort(array);
        int n = 3;
        getAllNSumPairs(array, targetSum, n, n, new LinkedList<>(), 0);
        return op;
    }

    private static void getAllNSumPairs(int[] array, int targetSum, int currPair, int totalPairs, LinkedList<Integer> ops, int start) {
        int len = array.length;
        if (currPair == 2) {
//            Then Perform Two sum.
            List<int[]> twoSumOpS = new ArrayList<>();
            if (twoSumPossible(array, targetSum, start, twoSumOpS)) {
                for (int[] twoSumOp : twoSumOpS) {
                    ops.addLast(twoSumOp[0]);
                    ops.addLast(twoSumOp[1]);
                    op.add(ops.toArray(new Integer[0]));
                    ops.removeLast();
                    ops.removeLast();
                }
            }
        } else {
            for (int end = start; end < len; end++) {
                ops.addLast(array[end]);
                getAllNSumPairs(array, targetSum - array[end], currPair - 1, totalPairs, ops, end + 1);
                ops.removeLast();
            }
        }
    }

    private static boolean twoSumPossible(int[] array, int targetSum, int i, List<int[]> twoSumOp) {
        int start = i, end = array.length - 1;
        while (start < end) {
            int sum = array[start] + array[end];
            if (sum == targetSum) {
                twoSumOp.add(new int[]{array[start], array[end]});
                start++;
                end--;
            } else if (sum < targetSum) {
                start++;
            } else {
                end--;
            }
        }
        return !twoSumOp.isEmpty();
    }
}
