import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 18, 2021
 * Questions:
 */

public class SumsInTheMatrix {

    public static void main(String[] args) {
        System.out.println(getSumCount(new int[][]{{}}, new int[][]{{}}));
    }

    private static List<Integer> getSumCount(int[][] matrix, int[][] queries) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] rowsSum = new int[rows], colsSum = new int[cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                rowsSum[row] += matrix[row][col];
                colsSum[col] += matrix[row][col];
            }
        }
//        Create a map, with the sum
        Map<Integer, Integer> sums = new HashMap<>();
        for (int sum : rowsSum) sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        for (int sum : colsSum) sums.put(sum, sums.getOrDefault(sum, 0) + 1);
//        Option 1: Loop from start to end of each query and get the count.
//        return getOption1(sums, queries);
//        Option 2: Create a sorted array with sum, and pre calculate the presum (i.e presum[i] will have sum of counts of numbers starting from first till i).
        return getOption2(sums, queries);
    }

//     Time: Per query: O(Log(n+m))
    private static List<Integer> getOption2(Map<Integer, Integer> sums, int[][] queries) {
        TreeSet<Integer> sortedSums = new TreeSet<>(sums.keySet());
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int total = 0;
        for (int sum : sortedSums) {
//            PreSum map will store the sum of counts that from start till the current sum.
            preSumMap.put(sum, total += sums.get(sum));
        }
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
//            Get the sum that is greater then or equal to L.
            Integer starting = sortedSums.ceiling(query[0]), ending = sortedSums.floor(query[1]);
//            Assuming that the there is at least one row or column, tthen the values will not be null
            int queryCount = preSumMap.get(ending) - preSumMap.get(starting) + sums.get(starting);
            result.add(queryCount);
        }
        return result;
    }

//     Time: Per query: O(R-L)
    private static List<Integer> getOption1(Map<Integer, Integer> sums, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int count = 0;
            for (int i = query[0]; i <= query[1]; i++) {
//                Check where there is an y row, or column that has I sum.
                count += sums.getOrDefault(i, 0);
            }
            result.add(count);
        }
        return result;
    }
}
