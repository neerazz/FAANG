import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoggleBoard {

    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        List<String> sol = new ArrayList<>();
        boolean[][] visited;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (String word : words) {
                    if (word.charAt(0) == board[i][j] && !set.contains(word)) {
                        visited = new boolean[board.length][board[0].length];
                        boolean found = backtrack(board, visited, word, "", i, j);
                        if (found) {
                            sol.add(word);
                            set.add(word);
                        }
                    }
                }
            }
        }
        return sol;
    }

    public static boolean backtrack(char[][] board, boolean[][] visited, String target, String curr, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }
        //Word found
        int len = curr.length();
        char c = board[i][j];
        //The char dosent match
        if (c != target.charAt(len)) return false;

        curr = curr + c;
        visited[i][j] = true;
        if (curr.equals(target)) return true;

        if (backtrack(board, visited, target, curr, i + 1, j)) return true;
        if (backtrack(board, visited, target, curr, i - 1, j)) return true;
        if (backtrack(board, visited, target, curr, i, j + 1)) return true;
        if (backtrack(board, visited, target, curr, i, j - 1)) return true;

        if (backtrack(board, visited, target, curr, i - 1, j + 1)) return true;
        if (backtrack(board, visited, target, curr, i + 1, j - 1)) return true;
        if (backtrack(board, visited, target, curr, i + 1, j + 1)) return true;
        if (backtrack(board, visited, target, curr, i - 1, j - 1)) return true;

        visited[i][j] = false;
        return false;
    }

    //0

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'t', 'h', 'i', 's', 'i', 's', 'a'},
                {'s', 'i', 'm', 'p', 'l', 'e', 'x'},
                {'b', 'x', 'x', 'x', 'x', 'e', 'b'},
                {'x', 'o', 'g', 'g', 'l', 'x', 'o'},
                {'x', 'x', 'x', 'D', 'T', 'r', 'a'},
                {'R', 'E', 'P', 'E', 'A', 'd', 'x'},
                {'x', 'x', 'x', 'x', 'x', 'x', 'x'},
                {'N', 'O', 'T', 'R', 'E', '-', 'P'},
                {'x', 'x', 'D', 'E', 'T', 'A', 'E'}
        };
        //char[][] board = new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
        //String[] words = new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        String[] words = new String[]
                {"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"};
        System.out.println(boggleBoard(board, words));
    }
}
