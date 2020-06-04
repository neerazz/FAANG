import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all of the following rules:
Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.
Note:
The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.
 */
public class SudokuSolver {
    static int counter = 0;

    public static void main(String[] args) {
        System.out.println("************************* Solution 1 *******************************");
        System.out.println(Arrays.deepToString(callSudokuSolver(new char[][]
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
                })));

        System.out.println(Arrays.deepToString(callSudokuSolver(new char[][]
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
                })));
        System.out.println("************************* Solution 2 *******************************");
        System.out.println(Arrays.deepToString(callSudokuSolver2(new char[][]
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
                })));

        System.out.println(Arrays.deepToString(callSudokuSolver2(new char[][]
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
                })));
    }

    private static char[][] callSudokuSolver(char[][] board) {
        solveSudoku(board);
        return board;
    }

    private static char[][] callSudokuSolver2(char[][] board) {
        sudokuSolve_rev1(board);
        return board;
    }

    static void sudokuSolve_rev1(char[][] board) {
        boolean[][] rows = new boolean[9][10], cols = new boolean[9][10], inner = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    rows[i][val] = cols[j][val] = inner[getInner(i, j)][val] = true;
                }
            }
        }
        helper(board, 0, 0, rows, cols, inner);
    }

    private static boolean helper(char[][] board, int row, int col, boolean[][] rows, boolean[][] cols, boolean[][] inner) {
        if (row == 8 && col == 9) return true;
        if (col > 8) {
            row++;
            col = 0;
        }
        if (board[row][col] == '.') {
            for (int i = 1; i <= 9; i++) {
//                Check for all possible number that can be placed at a position.
                if (!rows[row][i] && !cols[col][i] && !inner[getInner(row, col)][i]) {
//                    When possible, then block the number to be used further in the recursion.
                    rows[row][i] = cols[col][i] = inner[getInner(row, col)][i] = true;
                    board[row][col] = (char) ('0' + i);
                    if (helper(board, row, col + 1, rows, cols, inner)) {
                        return true;
                    }
                    board[row][col] = '.';
                    rows[row][i] = cols[col][i] = inner[getInner(row, col)][i] = false;
                }
            }
            return false;
        } else {
            return helper(board, row, col + 1, rows, cols, inner);
        }
    }

    private static int getInner(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }

    public static void solveSudoku(char[][] board) {

        List<boolean[]> rowList = new ArrayList<>();
        List<boolean[]> colList = new ArrayList<>();
        List<boolean[]> innerBoxList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rowList.add(new boolean[9]);
            colList.add(new boolean[9]);
            innerBoxList.add(new boolean[9]);
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char current = board[row][col];
                if (Character.isDigit(current)) {
//                    Setting the pre-populated value as consumed in the map list.
                    setValues(row, col, Character.getNumericValue(current), rowList, colList, innerBoxList);
                }
            }
        }
        solveSudoku(board, 0, 0, rowList, colList, innerBoxList);
    }

    private static void setValues(int row, int col, int value, List<boolean[]> rowList, List<boolean[]> colList, List<boolean[]> innerBoxList) {
        rowList.get(row)[value - 1] = true;
        colList.get(col)[value - 1] = true;
        innerBoxList.get(getInnerBoxValue(row, col))[value - 1] = true;
    }

    private static void setValuesBack(int row, int col, int value, List<boolean[]> rowList, List<boolean[]> colList, List<boolean[]> innerBoxList) {
        rowList.get(row)[value - 1] = false;
        colList.get(col)[value - 1] = false;
        innerBoxList.get(getInnerBoxValue(row, col))[value - 1] = false;
    }

    private static int getInnerBoxValue(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) return 0;
        if (row >= 3 && row <= 5 && col >= 0 && col <= 2) return 1;
        if (row >= 6 && row <= 8 && col >= 0 && col <= 2) return 2;
        if (row >= 0 && row <= 2 && col >= 3 && col <= 5) return 3;
        if (row >= 3 && row <= 5 && col >= 3 && col <= 5) return 4;
        if (row >= 6 && row <= 8 && col >= 3 && col <= 5) return 5;
        if (row >= 0 && row <= 2 && col >= 6 && col <= 8) return 6;
        if (row >= 3 && row <= 5 && col >= 6 && col <= 8) return 7;
        else return 8;
    }

    private static boolean solveSudoku(char[][] board, int row, int col, List<boolean[]> rowList, List<boolean[]> colList, List<boolean[]> innerBoxList) {
        counter++;
        if (col == board.length) {
            col = 0;
            row++;
        }
        if (row >= 9) return true;
        if (Character.isDigit(board[row][col])) {
            return solveSudoku(board, row, col + 1, rowList, colList, innerBoxList);
        }
        for (int i = 1; i < 10; i++) {
            if (isValid(i, row, col, rowList, colList, innerBoxList)) {
                board[row][col] = Character.forDigit(i, 10);
                setValues(row, col, i, rowList, colList, innerBoxList);
                if (!solveSudoku(board, row, col + 1, rowList, colList, innerBoxList)) {
                    board[row][col] = '.';
                    setValuesBack(row, col, i, rowList, colList, innerBoxList);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int value, int row, int col, List<boolean[]> rowList, List<boolean[]> colList, List<boolean[]> innerBoxList) {
//        THis method is to check if this value is valid at a given row and column.
        return !rowList.get(row)[value - 1] && !colList.get(col)[value - 1] && !innerBoxList.get(getInnerBoxValue(row, col))[value - 1];
    }
}
