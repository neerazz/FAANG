package leetcode.v1.medium;

public class WordSearch {

    public static void main(String[] args) {
        char[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(matrix, word));
    }

    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                boolean[][] visited = new boolean[board.length][board[0].length];
                boolean found = backTrack(board, visited, i, j, "", word);
                if (found) return true;
            }
        }
        return false;
    }

    public boolean backTrack(char[][] board, boolean[][] visited, int i, int j, String str, String word) {
        //Base Case
        if (!isValid(board, visited, i, j, str, word)) {
            return false;
        }
        visited[i][j] = true;
        String newStr = str + board[i][j];
        if (newStr.equals(word)) return true;
        if (backTrack(board, visited, i - 1, j, newStr, word)) return true;
        if (backTrack(board, visited, i + 1, j, newStr, word)) return true;
        if (backTrack(board, visited, i, j + 1, newStr, word)) return true;
        if (backTrack(board, visited, i, j - 1, newStr, word)) return true;
        return visited[i][j] = false;
    }

    public boolean isValid(char[][] board, boolean[][] visited, int r, int c, String s, String word) {
        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
            if (visited[r][c]) return false;
            return word.charAt(s.length()) == board[r][c];
        } else {
            return false;
        }
    }


}
