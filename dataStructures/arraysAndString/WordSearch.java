import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class WordSearch {
    static int rows, cols;

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(exist(new char[][]{
                {'a', 'b'},
                {'c', 'd'}
        }, "cdba"));
    }

    public static boolean exist_rev1(char[][] board, String word) {
        int rows = board.length, cols = rows > 0 ? board[0].length : 0;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0) &&
                        hasWord(board, row, col, rows, cols, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static boolean hasWord(char[][] board, int row, int col, int rows, int cols, String word, int idx, boolean[][] visited) {
        System.out.println("row = " + row + ", col = " + col + ", idx = " + idx + ", visited = " + Arrays.deepToString(visited));
        if (idx >= word.length()) return true;
        if (!inRange(row, col, rows, cols) || board[row][col] != word.charAt(idx) || visited[row][col]) return false;
        visited[row][col] = true;
        for (int[] dir : dirs) {
            int nr = row + dir[0], nc = col + dir[1];
            if (hasWord(board, nr, nc, rows, cols, word, idx + 1, visited)) return true;
        }
        visited[row][col] = false;
        return false;
    }

    static boolean inRange(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0) &&
                        helper(board, word, new HashSet<>(), row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, String word, Set<Integer> set, int row, int col) {
        System.out.println("word = " + word + ", set = " + set + ", row = " + row + ", col = " + col);
        if (row < 0 || row >= rows || col < 0 || col >= cols) return false;
        char cur = board[row][col];
        int hash = row * 1000 + col;
        if (set.contains(hash)) return false;
        if (word.charAt(0) == cur) {
            if (word.length() == 1) {
                return true;
            }
            word = word.substring(1);
            Set<Integer> temp = new HashSet<>(set);
            temp.add(hash);
            return helper(board, word, temp, row + 1, col) ||
                    helper(board, word, temp, row - 1, col) ||
                    helper(board, word, temp, row, col + 1) ||
                    helper(board, word, temp, row, col - 1);
        }
        return false;
    }
}
