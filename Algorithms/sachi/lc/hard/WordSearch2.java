import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

    public static List<String> findWords(char[][] board, String[] words) {
        //Set to save found chars
        Set<String> set = new HashSet<>();
        List<String> sol = new ArrayList<>();
        boolean[][] visited;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (String word : words) {
                    if (word.charAt(0) == board[i][j] && !set.contains(word)) {
                        visited = new boolean[board.length][board[0].length];
                        boolean found = dfs(board, visited, i, j, "", 0, word);
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

    public static boolean dfs(char[][] board, boolean[][] visited, int r, int c, String curr, int n, String target) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c]) return false;

        int lastChar = curr.length();
        //if(word.charAt(lastChar) != curr.charAt(lastChar)) return false;
        //Check if I got correct char and add
        if (target.charAt(n) != board[r][c]) return false;
        curr = curr + board[r][c];
        visited[r][c] = true;

        if (curr.equals(target)) return true;

        if (dfs(board, visited, r + 1, c, curr, n + 1, target)) return true;
        if (dfs(board, visited, r - 1, c, curr, n + 1, target)) return true;
        if (dfs(board, visited, r, c + 1, curr, n + 1, target)) return true;
        if (dfs(board, visited, r, c - 1, curr, n + 1, target)) return true;
        visited[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
        String[] words = new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        System.out.println(findWords(board, words));
    }

}
