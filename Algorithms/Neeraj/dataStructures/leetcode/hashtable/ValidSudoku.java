package ds.hashtable;

import java.util.Arrays;
import java.util.HashSet;

/*
https://leetcode.com/explore/learn/card/hash-table/185/hash_table_design_the_key/1126/
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }) + " should be [true]");
        System.out.println(isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }) + " should be [false]");
    }

    private static int getBoxNumber(int i, int j) {
        if (i >= 0 && i <= 2 && j >= 0 && j <= 2) return 0;
        if (i >= 3 && i <= 5 && j >= 0 && j <= 2) return 1;
        if (i >= 6 && i <= 8 && j >= 0 && j <= 2) return 2;
        if (i >= 0 && i <= 2 && j >= 3 && j <= 5) return 3;
        if (i >= 3 && i <= 5 && j >= 3 && j <= 5) return 4;
        if (i >= 6 && i <= 8 && j >= 3 && j <= 5) return 5;
        if (i >= 0 && i <= 2 && j >= 6 && j <= 8) return 6;
        if (i >= 3 && i <= 5 && j >= 6 && j <= 8) return 7;
        else return 8;
    }

    private static boolean isValidSudoku(char[][] board) {
        HashSet[] nums = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
        }

        for (int i = 0; i < 9; i++) {
            HashSet<Character> columnNums = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
            HashSet<Character> rowNums = new HashSet<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9'));
            for (int j = 0; j < 9; j++) {
//                Validate the Rows
                char rowCurrent = board[i][j];
                if (Character.isDigit(rowCurrent)) {
                    if (rowNums.contains(rowCurrent))
                        rowNums.remove(rowCurrent);
                    else return false;
                }
//                Validate The columns
                char columnCurrent = board[j][i];
                if (Character.isDigit(columnCurrent)) {
                    if (columnNums.contains(columnCurrent))
                        columnNums.remove(columnCurrent);
                    else return false;
                }
//                Check the internal-boxes
                char current = board[i][j];
                if (Character.isDigit(current)) {
                    HashSet set = nums[getBoxNumber(i, j)];
                    if (set.contains(current))
                        set.remove(current);
                    else return false;
                }
            }
        }
        return true;
    }
}
