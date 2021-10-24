/**
 * Created on:  Sep 20, 2021
 * Ref: https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class FindWinnerOnATicTacToeGame {
    public static void main(String[] args) {

    }

    public static String tictactoe(int[][] moves) {
        TicTacToe game = new TicTacToe();
        int count = 0;
        for (int[] move : moves) {
            game.move(move[0], move[1]);
            count++;
        }
        Integer winner = game.winner;
        if (winner == null) return count == 9 ? "Draw" : "Pending";
        return winner == -1 ? "A" : "B";
    }

    static class TicTacToe {
        int[] rows = new int[3], cols = new int[3];
        int d1 = 0, d2 = 0;
        int player = -1;
        Integer winner = null;

        void move(int row, int col) {
            rows[row] += player;
            cols[col] += player;
            if (row == col) d1 += player;
            if (row + col == 2) d2 += player;
            checkWinner();
            player *= -1;
        }

        void checkWinner() {
            if (winner != null) return;
            if (Math.abs(d1) == 3 || Math.abs(d2) == 3) {
                winner = player;
            } else {
                for (int i = 0; i < 3; i++) {
                    if (Math.abs(rows[i]) == 3 || Math.abs(cols[i]) == 3) {
                        winner = player;
                        return;
                    }
                }
            }
        }
    }
}
