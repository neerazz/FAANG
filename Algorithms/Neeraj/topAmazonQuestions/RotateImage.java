class RotateImage {
    public static void main(String[] args) {

    }

    public void rotate(int[][] m) {
        int rows = m.length;
        int cols = rows > 0 ? m[0].length : 0;
        if (cols == 0) return;
//         Reverse the columns.
        for (int row = 0; row < rows / 2; row++) {
            int[] temp = m[row];
            m[row] = m[rows - row - 1];
            m[rows - row - 1] = temp;
        }

//         Transpose the row. Convert rows to column and colum to rows.
        for (int row = 0; row < rows; row++) {
            for (int col = row; col < cols; col++) {
                int temp = m[row][col];
                m[row][col] = m[col][row];
                m[col][row] = temp;
            }
        }
    }
}
