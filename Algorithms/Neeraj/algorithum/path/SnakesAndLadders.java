import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 04, 2021
 * Questions: https://leetcode.com/problems/snakes-and-ladders/
 */

public class SnakesAndLadders {

    public static void main(String[] args) {

    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length, t = n * n;
        int[] moves = new int[t + 1];
        Arrays.fill(moves, Integer.MAX_VALUE);
        moves[0] = moves[1] = 0;
//         0:num, 1: dist
        Comparator<int[]> sort = (v1, v2) -> v1[1] == v2[1] ? v2[0] - v1[0] : v1[1] - v2[1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(sort);
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int num = poll[0], dist = poll[1];
            if (moves[num] < dist) continue;
//             Make all the possible moves
            for (int i = 1; i <= 6; i++) {
                if (num + i > t) continue;
                int[] next = getnewIdx(board, num + i, dist + 1);
                if (moves[next[0]] > dist + 1) {
                    pq.add(next);
                    moves[next[0]] = dist + 1;
                }
            }
        }
        return moves[t] == Integer.MAX_VALUE ? -1 : moves[t];
    }

    private static int[] getnewIdx(int[][] borad, int next, int dist) {
        int[] idx = getIdx(next, borad.length);
        if (borad[idx[0]][idx[1]] == -1) return new int[]{next, dist};
        return new int[]{borad[idx[0]][idx[1]], dist};
    }

    private static int[] getIdx(int num, int len) {
        int r = (num - 1) / len;
        int row = len - r - 1;
        int c = (num - 1) % len;
        if (r % 2 == 1) c = len - c - 1;
        return new int[]{row, c};
    }
}
