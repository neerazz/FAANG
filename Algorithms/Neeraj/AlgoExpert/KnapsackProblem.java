import java.util.*;

/**
 * Created on:  Aug 10, 2020
 * Questions: https://www.algoexpert.io/questions/Knapsack%20Problem
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        System.out.println(knapsackProblem(new int[][]{{1, 2}, {4, 3}, {5, 6}, {6, 7}}, 10));
        System.out.println(knapsackProblem(new int[][]{
                {465, 100},
                {400, 85},
                {255, 55},
                {350, 45},
                {650, 130},
                {1000, 190},
                {455, 100},
                {100, 25},
                {1200, 190},
                {320, 65},
                {750, 100},
                {50, 45},
                {550, 65},
                {100, 50},
                {600, 70},
                {255, 40}
        }, 200));
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int len = items.length;
        int[][] dp = new int[len + 1][capacity + 1];
        for (int row = 1; row <= len; row++) {
            int curValue = items[row - 1][0], curWeight = items[row - 1][1];
            for (int col = 0; col <= capacity; col++) {
                dp[row][col] = dp[row - 1][col];
                if (curWeight <= col && dp[row - 1][col - curWeight] + curValue > dp[row][col]) {
                    dp[row][col] = dp[row - 1][col - curWeight] + curValue;
                }
            }
        }
        return Arrays.asList(Collections.singletonList(dp[len][capacity]), getIndexes(items, len, capacity, dp));
    }

    private static List<Integer> getIndexes(int[][] items, int rows, int cols, int[][] dp) {
        LinkedList<Integer> op = new LinkedList<>();
        int row = rows, col = cols;
        while (row > 0) {
            if (dp[row][col] == dp[row - 1][col]) {
//            If the dp value is taken from top, then you have not selected the current item.
                row--;
            } else {
//                Else you have selected, the current item.
                op.addFirst(--row);
                col -= items[row][1];
            }
        }
        return op;
    }

    public static List<List<Integer>> knapsackProblem_bottomUp(int[][] items, int capacity) {
        Map<String, List<List<Integer>>> memo = new HashMap<>();
        return helper(items, 0, capacity, memo);
    }

    private static List<List<Integer>> helper(int[][] items, int start, int capacity, Map<String, List<List<Integer>>> memo) {
        if (capacity == 0)
            return new ArrayList<>(Arrays.asList(new ArrayList<>(Collections.singletonList(0)), new ArrayList<>()));
        if (start >= items.length || capacity < 0) return new ArrayList<>();
        String key = start + " - " + capacity;
        if (memo.containsKey(key)) return memo.get(key);
//        Get the value by selecting and not selecting the start weight.
        List<List<Integer>> result = helper(items, start + 1, capacity, memo);
        int withoutSelectingValue = result.isEmpty() ? 0 : result.get(0).get(0);
//        But selecting the current value.
        int curValue = items[start][0], curWeight = items[start][1];
        if (curWeight <= capacity) {
            List<List<Integer>> withSelecting = helper(items, start + 1, capacity - curWeight, memo);
            int withSelectingValue = withSelecting.isEmpty() ? 0 : withSelecting.get(0).get(0);
            if (withoutSelectingValue < withSelectingValue + curValue) {
                if (withSelecting.isEmpty()) {
                    withSelecting.add(new ArrayList<>(Collections.singletonList(curValue)));
//                    withSelecting.add(new ArrayList<>(Collections.singletonList(start)));
                    withSelecting.add(new ArrayList<>(Collections.singletonList(curWeight)));
                } else {
                    List<Integer> nextValue = withSelecting.get(0), weights = withSelecting.get(1);
                    nextValue.set(0, nextValue.get(0) + curValue);
//                    weights.add(start);
                    weights.add(curWeight);
                }
                result = withSelecting;
            }
        }
        memo.put(key, result);
        return result;
    }
}
