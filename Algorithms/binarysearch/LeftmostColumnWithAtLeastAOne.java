import java.util.List;

/**
 * Created on:  Aug 16, 2021
 * Ref : https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 */
public class LeftmostColumnWithAtLeastAOne {
    public static void main(String[] args) {

    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        int rows = dims.get(0), cols = dims.get(1);
        int min = Integer.MAX_VALUE;
        for (int r = 0; r < rows; r++) {
            if (binaryMatrix.get(r, cols - 1) == 1) {
                int leftMost = getLeft(binaryMatrix, r, 0, cols - 1);
                min = Math.min(min, leftMost);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int getLeft(BinaryMatrix matrix, int row, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            int midVal = matrix.get(row, mid);
            if (midVal == 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return matrix.get(row, start) != 1 ? Integer.MAX_VALUE : start;
    }

    interface BinaryMatrix {
        int get(int row, int col);

        List<Integer> dimensions();
    }
}
