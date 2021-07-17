package leetcode.v1.hard;

import java.util.HashSet;
import java.util.Set;

public class NQueens {

    int sol = 0;

    public int totalNQueens(int n) {
        int row = 0;
        Set<Integer> hills = new HashSet<>();
        Set<Integer> dales = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        backtrack(n, row, cols, hills, dales);
        return sol;
    }

    public void backtrack(int n, int row, Set<Integer> cols, Set<Integer> hills, Set<Integer> dales) {
        for (int currCol = 0; currCol < n; currCol++) {
            boolean canPlaceQueen = canPlaceQueen(row, currCol, cols, hills, dales);
            if (canPlaceQueen) {
                if (n == row + 1) {
                    sol++;
                    return;
                } else {
                    //Update all sets
                    cols.add(currCol);
                    hills.add(row + currCol);
                    dales.add(row - currCol);
                    //Try to place in next row
                    backtrack(n, row + 1, cols, hills, dales);
                    //Always Remove on return journey if it came so far - This only when an operation failed or all are successful
                    cols.remove(currCol);
                    hills.remove(row + currCol);
                    dales.remove(row - currCol);

                }
            }
        }
    }

    public boolean canPlaceQueen(int row, int col, Set<Integer> cols, Set<Integer> hills, Set<Integer> dales) {
        return !hills.contains(row + col) && !dales.contains(row - col) && !cols.contains(col);
    }


    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int sol = nQueens.totalNQueens(5);
        System.out.println(sol);
    }

}
