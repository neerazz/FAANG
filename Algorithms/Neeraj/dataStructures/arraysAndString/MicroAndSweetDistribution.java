/*
    Created on:  May 08, 2020
 */

import java.util.*;

/**
 * Questions: https://www.hackerearth.com/practice/data-structures/arrays/multi-dimensional/practice-problems/algorithm/micro-and-sweet-distribution/
 */
public class MicroAndSweetDistribution {
    static Map<String, int[]> dirs = new LinkedHashMap<>();
    static String ans = "";

    public static void main(String[] args) {
        FastReader fr = new FastReader("C:\\Users\\bnira\\Downloads\\fc4a8c78fe-input-fc4a244.txt.clean.txt");
        dirs.put("Right", new int[]{0, 1});
        dirs.put("Left", new int[]{0, -1});
        dirs.put("Front", new int[]{-1, 0});
        dirs.put("Back", new int[]{1, 0});
        int t = fr.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int rows = fr.nextInt(), cols = fr.nextInt();
            int row = fr.nextInt(), col = fr.nextInt();
            int targetRow = fr.nextInt(), targetCol = fr.nextInt();
//            Set<Integer> visited = new HashSet<>();
//            dfs(rows, cols, row, col, targetRow, targetCol, visited);
//            bfs(rows, cols, row, col, targetRow, targetCol);
//            sb.append(ans).append("\n");
//            ans = "";
            sb.append(solution_elegent(rows, cols, row, col, targetRow, targetCol)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String solution_elegent(int rows, int cols, int startRow, int startCol, int targetRow, int targetCol) {
        StringBuilder sb = new StringBuilder();
        if (startRow == 1 && startCol == 1) {
            if ((targetRow % 2) == 1) {
                if (targetCol == cols && targetRow == rows)
                    sb.append("Over");
                else if (targetCol == cols && targetRow != rows)
                    sb.append("Back");
                else
                    sb.append("Right");
            } else if ((targetRow % 2) == 0) {
                if (targetCol == 1 && targetRow == rows)
                    sb.append("Over");
                else if (targetCol == 1 && targetRow != rows)
                    sb.append("Back");
                else
                    sb.append("Left");
            }
        } else if (startRow == 1 && startCol == cols) {
            if ((targetRow % 2) == 1) {
                if (targetCol == 1 && targetRow == rows)
                    sb.append("Over");
                else if (targetCol == 1 && targetRow != rows)
                    sb.append("Back");
                else
                    sb.append("Left");
            } else if ((targetRow % 2) == 0) {
                if (targetCol == cols && targetRow == rows)
                    sb.append("Over");
                else if (targetCol == cols && targetRow != rows)
                    sb.append("Back");
                else
                    sb.append("Right");
            }
        } else if (startRow == rows && startCol == 1) {
            if ((rows % 2) == 0) {
                if (targetCol == 1 && targetRow == 1)
                    sb.append("Over");
                else if (targetCol == cols && targetRow % 2 == 0 || targetCol == 1 && targetRow % 2 == 1)
                    sb.append("Front");
                else if (targetRow % 2 == 0)
                    sb.append("Right");
                else if (targetRow % 2 == 1)
                    sb.append("Left");
            } else if ((rows % 2) == 1) {
                if (targetCol == cols && targetRow == 1)
                    sb.append("Over");
                else if (targetCol == cols && targetRow % 2 == 1 || targetCol == 1 && targetRow % 2 == 0)
                    sb.append("Front");
                else if (targetRow % 2 == 1)
                    sb.append("Right");
                else if (targetRow % 2 == 0)
                    sb.append("Left");
            }
        } else if (startRow == rows && startCol == cols) {
            if ((rows % 2) == 1) {
                if (targetCol == 1 && targetRow == 1)
                    sb.append("Over");
                else if (targetCol == cols && targetRow % 2 == 0 || targetCol == 1 && targetRow % 2 == 1)
                    sb.append("Front");
                else if (targetRow % 2 == 1)
                    sb.append("Left");
                else if (targetRow % 2 == 0)
                    sb.append("Right");
            } else if ((rows % 2) == 0) {
                if (targetCol == cols && targetRow == 1)
                    sb.append("Over");
                else if (targetCol == cols && targetRow % 2 == 1 || targetCol == 1 && targetRow % 2 == 0)
                    sb.append("Front");
                else if (targetRow % 2 == 1)
                    sb.append("Right");
                else if (targetRow % 2 == 0)
                    sb.append("Left");
            }
        }
        return sb.toString();
    }

    private static void bfs(int rows, int cols, int row, int col, int targetRow, int targetCol) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty() && ans.length() == 0) {
            int[] poll = queue.poll();
            row = poll[0];
            col = poll[1];
            visited.add(poll[0] * 10000 + poll[1]);
            for (Map.Entry<String, int[]> entry : dirs.entrySet()) {
                int[] entryValue = entry.getValue();
                int newRow = poll[0] + entryValue[0], newCol = poll[1] + entryValue[1];
                if (!visited.contains(newRow * 10000 + newCol) && isInBoundary(rows, cols, newRow, newCol)) {
                    if (row == targetRow && col == targetCol) {
                        ans = entry.getKey();
                    } else {
                        queue.add(new int[]{newRow, newCol});
                    }
                    break;
                }
            }
        }
        if (ans.length() == 0 && row == targetRow && col == targetCol) ans = "Over";
    }

    private static void dfs(int rows, int cols, int row, int col, int targetRow, int targetCol, Set<Integer> visited) {
        if (ans.length() != 0) return;
        visited.add(row * 10000 + col);
        for (Map.Entry<String, int[]> entry : dirs.entrySet()) {
            int newRow = row + entry.getValue()[0], newCol = col + entry.getValue()[1];
            if (!visited.contains(newRow * 10000 + newCol) && isInBoundary(rows, cols, newRow, newCol)) {
                if (row == targetRow && col == targetCol) {
                    ans = entry.getKey();
                    break;
                } else {
                    dfs(rows, cols, newRow, newCol, targetRow, targetCol, visited);
                }
            }
        }
        if (ans.length() == 0 && row == targetRow && col == targetCol) ans = "Over";
    }

    private static boolean isInBoundary(int rows, int cols, int row, int col) {
        return row > 0 && row <= rows && col > 0 && col <= cols;
    }
}
