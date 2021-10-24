import java.util.ArrayList;
import java.util.List;

class RiverSize {
    public static void main(String[] args) {
        System.out.println(riverSizes(new int[][]{{1, 0, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 0}}));
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        List<Integer> output = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 1) {
                    int size = getRiverSize(matrix, row, col, rows, cols, 0);
                    output.add(size);
                }
            }
        }
        return output;
    }

    private static int getRiverSize(int[][] matrix, int row, int col, int rows, int cols, int size) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || matrix[row][col] == 0) return size;
        matrix[row][col] = 0;
        return size + 1 +
                getRiverSize(matrix, row + 1, col, rows, cols, 0) +
                getRiverSize(matrix, row - 1, col, rows, cols, 0) +
                getRiverSize(matrix, row, col + 1, rows, cols, 0) +
                getRiverSize(matrix, row, col - 1, rows, cols, 0);
    }
}
