import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 01, 2021
 * Questions: https://www.algoexpert.io/questions/Boggle%20Board
 */

public class BoggleBoard {

    public static void main(String[] args) {
        System.out.println(boggleBoard(
                new char[][]{{'t', 'h', 'i', 's', 'i', 's', 'a'}, {'s', 'i', 'm', 'p', 'l', 'e', 'x'}, {'b', 'x', 'x', 'x', 'x', 'e', 'b'}, {'x', 'o', 'g', 'g', 'l', 'x', 'o'}, {'x', 'x', 'x', 'D', 'T', 'r', 'a'}, {'R', 'E', 'P', 'E', 'A', 'd', 'x'}, {'x', 'x', 'x', 'x', 'x', 'x', 'x'}, {'N', 'O', 'T', 'R', 'E', '-', 'P'}, {'x', 'x', 'D', 'E', 'T', 'A', 'E'}},
                new String[]{"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"})
                + "\n = \n[a, boggle, this, is, simple, board, NOTRE-PEATED]");
        System.out.println(boggleBoard(
                new char[][]{{'y', 'g', 'f', 'y', 'e', 'i'}, {'c', 'o', 'r', 'p', 'o', 'u'}, {'j', 'u', 'z', 's', 'e', 'l'}, {'s', 'y', 'u', 'r', 'h', 'p'}, {'e', 'a', 'e', 'g', 'n', 'd'}, {'h', 'e', 'l', 's', 'a', 't'}},
                new String[]{"san", "sana", "at", "vomit", "yours", "help", "end", "been", "bed", "danger", "calm", "ok", "chaos", "complete", "rear", "going", "storm", "face", "epual", "dangerous"})
                + "\n = \n[help, san, at, danger, yours]");
    }

    public static List<String> boggleBoard(char[][] board, String[] words) {
        Map<Character, Trie> map = new HashMap<>();
        for (String word : words) {
            int len = word.length(), i = 0;
            char c = word.charAt(i++);
            Trie cur = map.getOrDefault(c, new Trie(c));
            map.put(c, cur);
            while (i < len) {
                c = word.charAt(i++);
                Trie next = cur.map.getOrDefault(c, new Trie(c));
                cur.map.put(c, next);
                cur = next;
            }
            cur.isEnd = true;
            cur.word = word;
        }
        Set<String> result = new HashSet<>();
        int rows = board.length, cols = rows > 0 ? board[0].length : 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cur = board[row][col];
                if (map.containsKey(cur)) {
                    dfs(board, row, col, rows, cols, map.get(cur), visited, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    static int[][] dirs = {{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};

    private static void dfs(char[][] board, int row, int col, int rows, int cols, Trie trie, boolean[][] visited, Set<String> result) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || trie.cur != board[row][col])
            return;
        visited[row][col] = true;
        if (trie.isEnd) {
            result.add(trie.word);
        }
//        Loop through the chars in trie map.
        for (Trie dep : trie.map.values()) {
            for (int[] dir : dirs) {
                dfs(board, row + dir[0], col + dir[1], rows, cols, dep, visited, result);
            }
        }
        visited[row][col] = false;
    }

    static class Trie {
        Map<Character, Trie> map = new HashMap<>();
        boolean isEnd = false;
        String word = "";
        char cur;

        public Trie(char cur) {
            this.cur = cur;
        }
    }
}
