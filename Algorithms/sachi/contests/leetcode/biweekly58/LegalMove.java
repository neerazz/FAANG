package contests.leetcode.biweekly58;

public class LegalMove {

    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'.', '.', 'W', '.', 'B', 'W', 'W', 'B'},
                {'B', 'W', '.', 'W', '.', 'W', 'B', 'B'},
                {'.', 'W', 'B', 'W', 'W', '.', 'W', 'W'},
                {'W', 'W', '.', 'W', '.', '.', 'B', 'B'},
                {'B', 'W', 'B', 'B', 'W', 'W', 'B', '.'},
                {'W', '.', 'W', '.', 'X', 'B', 'W', 'W'},
                {'B', '.', 'B', 'B', '.', '.', 'B', 'B'},
                {'.', 'W', '.', 'W', '.', 'W', '.', 'W'}
        };
        int rMove = 5, cMove = 4;
        char color = 'W';
        System.out.println(checkMove(board, rMove, cMove, color));


        char[][] board1 = new char[][]
                {
                        {'W', 'W', '.', 'B', '.', 'B', 'B', '.'},
                        {'W', 'B', '.', '.', 'W', 'B', '.', '.'},
                        {'B', 'B', 'B', 'B', 'W', 'W', 'B', '.'},
                        {'W', 'B', '.', '.', 'B', 'B', 'B', '.'},
                        {'W', 'W', 'B', '.', 'W', '.', 'B', 'B'},
                        {'B', '.', 'B', 'W', '.', 'B', '.', '.'},
                        {'.', 'B', 'B', 'W', 'B', 'B', '.', '.'},
                        {'B', 'B', 'W', '.', 'X', 'B', '.', '.'}
                };
        rMove = 7;
        cMove = 4;
        color = 'B';
        System.out.println(checkMove(board, rMove, cMove, color));

        char[][] board2 = new char[][]
                {
                        {'W', 'B', 'B', 'W', 'W', 'B', '.', 'B'},
                        {'W', '.', '.', 'W', 'B', '.', '.', 'B'},
                        {'.', 'B', 'B', 'B', 'W', '.', 'W', '.'},
                        {'B', 'W', 'B', '.', 'B', 'W', '.', '.'},
                        {'W', 'W', '.', 'W', 'B', 'B', 'B', '.'},
                        {'.', '.', '.', '.', 'W', '.', 'B', '.'},
                        {'.', '.', 'B', 'W', 'W', 'B', 'B', '.'},
                        {'B', 'B', '.', 'W', 'B', '.', 'B', '.'}

                };
        rMove = 3;
        cMove = 7;
        color = 'W';
        System.out.println(checkMove(board, rMove, cMove, color));

    }

    public static boolean isInBound(char[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    public static boolean move(char[][] board, int rMove, int cMove, char color, int[] dir) {
        int row = rMove + dir[0], col = cMove + dir[1], steps = 0;
        while (isInBound(board, row, col) && board[row][col] != color && board[row][col] != '.') {
            row = row + dir[0];
            col = col + dir[1];
            steps++;
        }
        return isInBound(board, row, col) && board[row][col] == color && steps >= 1;
    }

    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] dir : dirs) {
            if (move(board, rMove, cMove, color, dir)) return true;
        }
        return false;
    }

}


