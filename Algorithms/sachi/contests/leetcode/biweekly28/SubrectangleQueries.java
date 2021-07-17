package contests.leetcode.biweekly28;

import util.Util;

class SubrectangleQueries {

    int[][] matrix;

    public SubrectangleQueries(int[][] rectangle) {
        matrix = rectangle;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5,2,5,9,4},
                {10,7,1,4,1},
                {7,3,1,3,8},
                {9,7,9,4,9}
        };
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(matrix);
        Util.print(matrix);

        subrectangleQueries.updateSubrectangle(1, 0, 3, 3, 10);
        Util.print(matrix);

        subrectangleQueries.updateSubrectangle(3, 2, 3, 2, 4);
        Util.print(matrix);

        System.out.println(subrectangleQueries.getValue(2, 0)); // return 10
        System.out.println(subrectangleQueries.getValue(2, 2)); // return 5
        System.out.println(subrectangleQueries.getValue(3, 4)); // return 5

        subrectangleQueries.updateSubrectangle(1, 4, 1, 4, 10);
        Util.print(matrix);

    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        int r = row1, c = col1;
        while (r < matrix.length && r <= row2) {
            c = col1;
            while (c < matrix[r].length && c <= col2) {
                matrix[r][c] = newValue;
                c++;
            }
            r++;
        }
    }

    public int getValue(int row, int col) {
        return matrix[row][col];
    }
}


/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */