import java.util.*;

/**
 * Created on:  Sep 26, 2021
 * Ref: https://leetcode.com/problems/transform-to-chessboard/
 */
public class TransformToChessboard {
    public static void main(String[] args) {
        System.out.println(movesToChessboard(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}, {1, 0, 0, 1}}) + " = 2");
        System.out.println(movesToChessboard(new int[][]{{1, 1, 1, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 1, 0, 1, 1}, {1, 1, 1, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 1, 0, 1, 1}, {0, 0, 0, 1, 1, 0, 1, 1}, {0, 0, 0, 1, 1, 0, 1, 1}, {1, 1, 1, 0, 0, 1, 0, 0}, {1, 1, 1, 0, 0, 1, 0, 0}})
                + " = 2");
    }

    public static int movesToChessboard(int[][] board) {
        int n = board.length;
        Map<String, Integer> dp = new HashMap<>();
        Set<String> visited = new HashSet<>();
        int result = helper(board, n, dp, visited);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    static int helper(int[][] board, int n, Map<String, Integer> dp, Set<String> visited) {
        String key = Arrays.deepToString(board);
        if (isValid(board)) {
            dp.put(key, 0);
            return 0;
        }
        if (dp.containsKey(key)) return dp.get(key);
        if (visited.contains(key)) return Integer.MAX_VALUE;
        visited.add(key);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[][] after = deepCopy(board, n);
                int val = 0;
                swapRow(after, i, j);
                if (!Arrays.deepEquals(board, after)) {
                    val = helper(after, n, dp, visited);
                    if (val != Integer.MAX_VALUE) min = Math.min(min, val + 1);
                }
                after = deepCopy(board, n);
                swapCol(after, i, j);
                if (!Arrays.deepEquals(board, after)) {
                    val = helper(after, n, dp, visited);
                    if (val != Integer.MAX_VALUE) min = Math.min(min, val + 1);
                }
            }
        }
        dp.put(key, min);
        return min;
    }

    private static int[][] deepCopy(int[][] board, int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = board[i][j];
            }
        }
        return result;
    }

    static boolean isValid(int[][] board) {
        int cur = board[0][0], len = board.length;
        for (int i = 0; i < len; i++) {
            int col = cur;
            for (int j = 0; j < len; j++) {
                if (board[i][j] != col) return false;
                col ^= 1;
            }
            cur ^= 1;
        }
        return true;
    }

    static void swapCol(int[][] board, int a, int b) {
        int n = board.length;
        for (int i = 0; i < board.length; i++) {
            int temp = board[i][a];
            board[i][a] = board[i][b];
            board[i][b] = temp;
        }
    }

    static void swapRow(int[][] board, int a, int b) {
        int[] temp = board[a];
        board[a] = board[b];
        board[b] = temp;
    }
}
