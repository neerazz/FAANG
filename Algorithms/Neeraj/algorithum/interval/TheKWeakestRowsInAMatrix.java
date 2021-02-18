import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 15, 2021
 * Questions:
 */

public class TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {

    }

    public static int[] kWeakestRows(int[][] mat, int k) {
//        0: row, 1: sum
        PriorityQueue<int[]> pq = new PriorityQueue<>((v1, v2) -> v1[1] == v2[1] ? Integer.compare(v2[0], v1[0]) : Integer.compare(v2[1], v1[1]));
        int rows = mat.length, cols = rows > 0 ? mat[0].length : 0;
        for (int row = 0; row < rows; row++) {
            int max = pq.size() == k ? pq.peek()[1] : Integer.MAX_VALUE;
            int sum = 0;
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 1) sum++;
                else break;
                if (sum == max) break;
            }
            if (max != sum) pq.add(new int[]{row, sum});
            if (pq.size() > k) pq.poll();
        }
        int[] result = new int[pq.size()];
        int i = pq.size();
        while (!pq.isEmpty()) {
            result[--i] = pq.poll()[0];
        }
        return result;
    }
}
