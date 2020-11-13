import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 13, 2020
 * Questions: https://leetcode.com/problems/sliding-puzzle/
 */

public class SlidingPuzzle {

    public static void main(String[] args) {
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}}));
        System.out.println(slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}}));
        System.out.println(slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
        System.out.println(slidingPuzzle(new int[][]{{3, 2, 4}, {1, 5, 0}}));
    }

    /**
     * 0 1 2
     * 3 4 5 --> 0 can go to {1, 3}
     * <p>
     * 1 0 2
     * 3 4 5 --> 0 can go to index of {0,2,4}
     * <p>
     * 1 2 0
     * 3 4 5 --> 0 can go to {1, 5}
     * <p>
     * 1 2 3
     * 0 4 5 --> 0 can go to {0,4}
     * <p>
     * 1 2 3
     * 4 0 5 --> 0 can go to {1, 3, 5}
     * <p>
     * 1 2 3
     * 4 5 0 --> 0 can go to {2, 4}
     */
    public static int slidingPuzzle(int[][] board) {
        int rows = board.length, cols = rows > 0 ? board[0].length : 0, level = 0;
        String target = "123450", cur = "" + board[0][0] + board[0][1] + board[0][2] + board[1][0] + +board[1][1] + board[1][2];
        int[][] dirs = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Queue<String> queue = new LinkedList<>();
        queue.add(cur);
        Set<String> visited = new HashSet<>();
        visited.add(cur);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (poll.equals(target)) {
                    return level;
                }
                int zeroIdx = poll.indexOf('0');
                for (int dir : dirs[zeroIdx]) {
                    String swap = swap(poll, zeroIdx, dir);
                    if (visited.add(swap)) {
                        queue.add(swap);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private static String swap(String str, int a, int b) {
        char[] chars = str.toCharArray();
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
        return String.valueOf(chars);
    }
}
