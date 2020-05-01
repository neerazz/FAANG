import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] boxSet = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                //That row
                Set<Character> row = rowSet[i];
                if (row == null) row = new HashSet<>();
                //That col
                Set<Character> col = colSet[j];
                if (col == null) col = new HashSet<>();

                //Get the correct box
                int boxNum = getBox(i, j);
                Set<Character> box = boxSet[boxNum];
                if (box == null) box = new HashSet<>();

                char val = board[i][j];
                if (row.contains(val) || col.contains(val) || box.contains(val)) return false;

                row.add(val);
                col.add(val);
                box.add(val);

                rowSet[i] = row;
                colSet[j] = col;
                boxSet[boxNum] = box;

            }
        }
        return true;
    }

    public int getBox(int i, int j) {
        if (i < 3 && j < 3) {
            return 0;
        } else if (i < 3 && j < 6) {
            return 1;
        } else if (i < 3 && j < 9) {
            return 2;
        } else if (i < 6 && j < 3) {
            return 3;
        } else if (i < 6 && j < 6) {
            return 4;
        } else if (i < 6 && j < 9) {
            return 5;
        } else if (i < 9 && j < 3) {
            return 6;
        } else if (i < 9 && j < 6) {
            return 7;
        } else {
            return 8;
        }
    }
}
