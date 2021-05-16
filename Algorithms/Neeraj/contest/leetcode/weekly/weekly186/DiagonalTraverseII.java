package weekly.weekly186;/*
    Created on:  Apr 25, 2020
 */

import java.util.*;

/**
 * Questions: https://leetcode.com/contest/weekly-contest-186/problems/diagonal-traverse-ii/
 */
public class DiagonalTraverseII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findDiagonalOrder(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5, 6),
                        Arrays.asList(7, 8, 9)
                ))));
        System.out.println(Arrays.toString(findDiagonalOrder_optimal(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5, 6),
                        Arrays.asList(7, 8, 9)
                ))));
    }

    public static int[] findDiagonalOrder_optimal(List<List<Integer>> nums) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int max = 0;
        for (int row = 0; row < nums.size(); row++) {
            for (int col = 0; col < nums.get(row).size(); col++) {
                map.computeIfAbsent(row + col, (val) -> new LinkedList<>()).addFirst(nums.get(row).get(col));
                max = Math.max(max, row + col);
            }
        }
        List<Integer> opList = new ArrayList<>();
        for (int i = 0; i <= max; i++) {
            opList.addAll(map.get(i));
        }
        return opList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int rows = nums.size(), cols = 0;
        List<Integer> list = new ArrayList<>();
        for (int diag = 0; diag < rows; diag++) {
            int row = diag;
            int currentColSize = nums.get(row).size();
            cols = Math.max(cols, currentColSize);
            for (int col = 0; col < cols && row >= 0; col++) {
                if (nums.get(row).size() > col) {
                    list.add(nums.get(row).get(col));
                }
                row--;
            }
        }
        for (int diag = 0; diag < cols; diag++) {
            int row = rows - 1;
            int currentColSize = nums.get(row).size();
            cols = Math.max(cols, currentColSize);
            for (int col = diag + 1; col < cols && row >= 0; col++) {
                if (nums.get(row).size() > col) {
                    list.add(nums.get(row).get(col));
                }
                row--;
            }
        }
        int[] op = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            op[i] = list.get(i);
        }
        return op;
    }
}
