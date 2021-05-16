package weekly.weekly187;
/*
    Created on:  May 02, 2020
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Questions: https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows
 */
public class FindtheKthSmallestSumofaMatrixWithSortedRows {
    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1, 3, 11}, {2, 4, 6}}, 5));
        System.out.println(kthSmallest_optimal(new int[][]{{1, 3, 11}, {2, 4, 6}}, 5));
        System.out.println(kthSmallest(new int[][]{{1, 10, 10}, {1, 4, 5}, {2, 3, 6}}, 7));
        System.out.println(kthSmallest_optimal(new int[][]{{1, 10, 10}, {1, 4, 5}, {2, 3, 6}}, 7));
    }

    public static int kthSmallest_optimal(int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;
        List<Integer> list = new ArrayList<>();
//        Initially collect all elements in first row.
        for (int i = 0; i < cols; i++) {
            list.add(mat[0][i]);
        }
//        Then Loop through all the rows from 1 till end, and keep collecting first K values into the list.
        for (int row = 1; row < rows; row++) {
            List<Integer> temp = new ArrayList<>();
//            Loop though all the elements of the temp and the ith row. And find the new sums.
            for (int pre : list) {
                for (int val : mat[row]) {
                    temp.add(pre + val);
                }
            }
//            Collect only first K values.
            list = temp.parallelStream().sorted().limit(k).collect(Collectors.toList());
        }
        return list.get(list.size() - 1);
    }

    static PriorityQueue<Integer> pq;

    public static int kthSmallest(int[][] mat, int k) {
        pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        pickFromEachRow(mat, k, 0, 0);
        return pq.poll();
    }

    private static void pickFromEachRow(int[][] mat, int k, int sum, int row) {
        if (row == mat.length) {
            pq.add(sum);
            if (pq.size() > k) {
                pq.poll();
            }
            return;
        }
        for (int col = 0; col < mat[0].length; col++) {
            pickFromEachRow(mat, k, sum + mat[row][col], row + 1);
        }
    }
}
