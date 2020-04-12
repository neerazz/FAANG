import java.util.List;

/**
 * Questions: Let A be a 2D array whose entries are either W or B.
 * Write a program that takes A, and replaces all Ws that cannot reach the boundary with a B.
 */
public class FillSurroundedRegions {
    public static void main(String[] args) {

    }

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void fillSurroundedRegions(List<List<Character>> board) {
        int rows = board.size(), cols = rows > 0 ? board.get(0).size() : 0;
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (board.get(row).get(col) == 'W') {
                    dfs(board, row, col, rows, cols);
                }
            }
        }
    }

    private static boolean dfs(List<List<Character>> board, int row, int col, int rows, int cols) {
//        Return true when a boundary is reached.
        if (row <= 0 || row >= rows-1 || col <= 0 || col >= cols-1) return true;
//        If the value is already B then return false
        if (board.get(row).get(col) == 'B') return false;
//        Set the current value to B.
        board.get(row).set(col, 'B');
//        Travel to all the four sides, to convert it to B
        for (int[] dir : dirs) {
            if (dfs(board, row + dir[0], col + dir[1], rows, cols)) {
//                If any of the paths reaches out of bound. Then set it back to 'W'
                board.get(row).set(col, 'W');
                return true;
            }
        }
        return false;
    }
}
