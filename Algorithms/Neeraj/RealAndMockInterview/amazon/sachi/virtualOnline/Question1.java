package virtualOnline;

/*
    Created on:  Apr 30, 2020
 */

/**
 * Questions: Given a 8*8 grid chess board with a starting and ending point.
 *  Write a function that return's number of steps needed for an horse reach from start and endpoint.
 */

import java.util.LinkedList;
import java.util.Queue;

public class Question1 {
    public static void main(String[] args) {

    }

    // All possible moves
    int[][] possibleMoves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

    public int findShortest(int[] source, int[] dest) {
        if (source[0] == dest[0] && source[1] == dest[1]) return 0;
        Queue<int[]> queue = new LinkedList<>();
        // Initially I am adding the source.
        queue.add(source);

//        Set a moves to 0;
        int moves = 0;
        boolean[][] visited = new boolean[8][8];
//        Setting the start point as visited.
        visited[source[0]][source[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
//            Increase the moves
            moves++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int[] move : possibleMoves) {
                    int newR = poll[0] + move[0], newC = poll[1] + move[1];

                    // Reached the destination return the moves.
                    if (newR == dest[0] && newC == dest[1]) return moves;

                    if (newR >= 0 && newR < 8 && newC >= 0 && newC < 8 && !visited[newR][newC]) {
                        queue.add(new int[]{newR, newC});
                        visited[newR][newC] = true;
                    }
                }
            }
        }
        return -1;
    }
}