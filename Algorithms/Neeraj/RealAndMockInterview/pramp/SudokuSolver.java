import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  May 19, 2020
 * Questions: https://www.pramp.com/challenge/O5PGrqGEyKtq9wpgw6XP
 */
public class SudokuSolver {
    public static void main(String[] args) {
        System.out.println("************************* Solution 1 *******************************");
        System.out.println(sudokuSolve(new char[][]
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '.', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }));
        System.out.println(sudokuSolve(new char[][]
                {
                        {'.', '.', '.', '7', '.', '.', '3', '.', '1'},
                        {'3', '.', '.', '9', '.', '.', '.', '.', '.'},
                        {'.', '4', '.', '3', '1', '.', '2', '.', '.'},
                        {'.', '6', '.', '4', '.', '.', '5', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '1', '.', '.', '8', '.', '4', '.'},
                        {'.', '.', '6', '.', '2', '1', '.', '5', '.'},
                        {'.', '.', '.', '.', '.', '9', '.', '.', '8'},
                        {'8', '.', '5', '.', '.', '4', '.', '.', '.'}
                }));
        System.out.println(sudokuSolve(new char[][]
                {
                        {'.', '8', '9', '.', '4', '.', '6', '.', '5'},
                        {'.', '7', '.', '.', '.', '8', '.', '4', '1'},
                        {'5', '6', '.', '9', '.', '.', '.', '.', '8'},
                        {'.', '.', '.', '7', '.', '5', '.', '9', '.'},
                        {'.', '9', '.', '4', '.', '1', '.', '5', '.'},
                        {'.', '3', '.', '9', '.', '6', '.', '1', '.'},
                        {'8', '.', '.', '.', '.', '.', '.', '.', '7'},
                        {'.', '2', '.', '8', '.', '.', '.', '6', '.'},
                        {'.', '.', '6', '.', '7', '.', '.', '8', '.'}
                }));
        System.out.println("************************* Solution 2 *******************************");
        System.out.println(sudokuSolve_optimal(new char[][]
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '.', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }));
        System.out.println(sudokuSolve_optimal(new char[][]
                {
                        {'.', '.', '.', '7', '.', '.', '3', '.', '1'},
                        {'3', '.', '.', '9', '.', '.', '.', '.', '.'},
                        {'.', '4', '.', '3', '1', '.', '2', '.', '.'},
                        {'.', '6', '.', '4', '.', '.', '5', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '1', '.', '.', '8', '.', '4', '.'},
                        {'.', '.', '6', '.', '2', '1', '.', '5', '.'},
                        {'.', '.', '.', '.', '.', '9', '.', '.', '8'},
                        {'8', '.', '5', '.', '.', '4', '.', '.', '.'}
                }));
        System.out.println(sudokuSolve_optimal(new char[][]
                {
                        {'1', '2', '.', '4', '5', '6', '7', '8', '9'},
                        {'.', '.', '3', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                }));
        System.out.println(sudokuSolve_optimal(new char[][]
                {
                        {'.', '8', '9', '.', '4', '.', '6', '.', '5'},
                        {'.', '7', '.', '.', '.', '8', '.', '4', '1'},
                        {'5', '6', '.', '9', '.', '.', '.', '.', '8'},
                        {'.', '.', '.', '7', '.', '5', '.', '9', '.'},
                        {'.', '9', '.', '4', '.', '1', '.', '5', '.'},
                        {'.', '3', '.', '9', '.', '6', '.', '1', '.'},
                        {'8', '.', '.', '.', '.', '.', '.', '.', '7'},
                        {'.', '2', '.', '8', '.', '.', '.', '6', '.'},
                        {'.', '.', '6', '.', '7', '.', '.', '8', '.'}
                }));
    }

    static boolean sudokuSolve_optimal(char[][] board) {
        boolean[][] rows = new boolean[9][10], cols = new boolean[9][10], inner = new boolean[9][10];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cur = board[row][col];
                if (cur != '.') {
//                    Then set our flags (boolean matrix) to true, to indicate that it is take.
                    rows[row][cur - '0'] = cols[col][cur - '0'] = inner[getInner(row, col)][cur - '0'] = true;
                }
            }
        }
        return backtrack(board, 0, 0, rows, cols, inner);
    }

    private static boolean backtrack(char[][] board, int row, int col, boolean[][] rows, boolean[][] cols, boolean[][] inner) {
        if (row == 8 && col == 9) {
            return true;
        } else if (col > 8) {
            row++;
            col = 0;
        }
        if (board[row][col] == '.') {
            for (int i = 1; i < 10; i++) {
//                Check if 1 to 9 numbers can be placed on the board.
                if (isPossible(row, col, i, rows, cols, inner)) {
//                    If able to place on the board then set the taken flag to true and make a recursive call.
                    rows[row][i] = cols[col][i] = inner[getInner(row, col)][i] = true;
                    if (backtrack(board, row, col + 1, rows, cols, inner)) {
                        return true;
                    }
//                    If it is not possible then after returning from recursion change taken flag to false.
                    rows[row][i] = cols[col][i] = inner[getInner(row, col)][i] = false;
                }
            }
            return false;
        } else {
            return backtrack(board, row, col + 1, rows, cols, inner);
        }
    }

    private static boolean isPossible(int row, int col, int val, boolean[][] rows, boolean[][] cols, boolean[][] inner) {
        return !rows[row][val] && !cols[col][val] && !inner[getInner(row, col)][val];
    }

    private static int getInner(int row, int col) {
        return ((row / 3) * 3) + (col / 3);
    }

    static boolean sudokuSolve(char[][] board) {
        return backtrack(board, 0, 0);
    }

    static boolean backtrack(char[][] board, int row, int col) {
        if (row == 8 && col == 9) return true;
        if (col > 8) {
            row++;
            col = 0;
        }
        if (board[row][col] == '.') {
            List<Integer> pos = getPosibilities(board, row, col);
            for (int val : pos) {
                board[row][col] = (char) ('0' + val);
                if (backtrack(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
            return false;
        } else {
            return backtrack(board, row, col + 1);
        }
    }

    static List<Integer> getPosibilities(char[][] board, int row, int col) {
        boolean[] taken = new boolean[10];
        // Loop through the row.
        for (int i = 0; i < 9; i++) {
            char cur = board[row][i];
            if (cur != '.') {
                taken[Character.getNumericValue(cur) - 1] = true;
            }
        }
        // Loop through the col.
        for (int i = 0; i < 9; i++) {
            char cur = board[i][col];
            if (cur != '.') {
                taken[Character.getNumericValue(cur) - 1] = true;
            }
        }
        // Loop through the inner box
        // (row - row % 3) + floor(i / 3)
        int iR = (row / 3) * 3, iC = (col / 3) * 3;
        for (int i = iR; i < iR + 3; i++) {
            for (int j = iC; j < iC + 3; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    taken[Character.getNumericValue(cur) - 1] = true;
                }
            }
        }

        List<Integer> op = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!taken[i]) {
                op.add(i);
            }
        }
        return op;
    }
}
