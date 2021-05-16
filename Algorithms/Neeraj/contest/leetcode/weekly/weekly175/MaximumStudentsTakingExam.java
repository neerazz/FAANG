package weekly.weekly175;

public class MaximumStudentsTakingExam {
    public static void main(String[] args) {
        System.out.println(maxStudents(new char[][]{{'#','.','#','#','.','#'},
                {'.','#','#','#','#','.'},
                {'#','.','#','#','.','#'}}));
        System.out.println(maxStudents(new char[][]{{'#','.','.','.','#'},
                {'.','#','.','#','.'},
                {'.','.','#','.','.'},
                {'.','#','.','#','.'},
                {'#','.','.','.','#'}}));
    }

    public static int maxStudents(char[][] seats) {
        int count = 0, rows = seats.length, cols = seats[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char cur = seats[row][col];
                if (cur == '.'){
                    if (canCheat(seats,row,col,rows,cols)){
                        seats[row][col] = '#';
                    }else {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean canCheat(char[][] seats, int row, int col, int rows, int cols) {
//        Check if candidate exists at left.
        if (col-1 >= 0 && seats[row][col-1] == '.'){
            return true;
        }
//        Check if candidate is sitting at right
        if (col+1 < cols && seats[row][col+1] == '.'){
            return true;
        }
//        Check if candidate is sitting at left cross.
        if (col-1 >= 0 && row-1 >= 0 && seats[row-1][col-1] == '.'){
            return true;
        }
//        Check if candidate is sitting at right cross.
        return col + 1 < cols && row - 1 >= 0 && seats[row - 1][col + 1] == '.';
    }
}
