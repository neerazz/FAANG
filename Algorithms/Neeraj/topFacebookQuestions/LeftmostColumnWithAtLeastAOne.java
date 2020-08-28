import java.util.List;

/**
 * Created on:  Jul 26, 2020
 * Questions:
 */
public class LeftmostColumnWithAtLeastAOne {
    public static void main(String[] args) {
        System.out.println(leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0}, {0, 0}})));
        System.out.println(leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0, 0}, {0, 1}})));
        System.out.println(leftMostColumnWithOne(new BinaryMatrix(new int[][]{{1, 1, 1, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 1, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}})));
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0), cols = binaryMatrix.dimensions().get(1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            if (binaryMatrix.get(i, cols - 1) == 1) {
                int curMin = getLowestRow(binaryMatrix, i, cols - 1);
                if (curMin != -1 && curMin < min) min = curMin;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int getLowestRow(BinaryMatrix binaryMatrix, int row, int cols) {
        int start = 0, end = cols;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (binaryMatrix.get(row, mid) == 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (binaryMatrix.get(row, start) == 1) return start;
        if (binaryMatrix.get(row, end) == 1) return end;
        return -1;
    }

    static class BinaryMatrix {
        int[][] matrix;

        public BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        int get(int row, int col) {
            return matrix[row][col];
        }

        List<Integer> dimensions() {
            return List.of(matrix.length, matrix[0].length);
        }
    }
}
