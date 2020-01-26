package problems.recursion2;

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
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '.', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        Arrays.stream(board).forEach(i -> System.out.println(Arrays.toString(i)));
        System.out.println("counter = " + counter);
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
