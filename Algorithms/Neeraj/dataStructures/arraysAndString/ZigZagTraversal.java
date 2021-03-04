import java.util.*;

class ZigZagTraversal {
    public static void main(String[] args) {
        System.out.println(zigzagTraverse(Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16)
        )));
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> op = new ArrayList<>();
        int rows = array.size(), cols = rows > 0 ? array.get(0).size() : 0;
        if (cols == 0) {
            return op;
        }
        int row = 0, col = 0;
        boolean goingDownTowardsLeft = true;
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            op.add(array.get(row).get(col));
            if (goingDownTowardsLeft) {
                if (row == rows - 1) {
                    // Reached the last row, so move right and go up.
                    goingDownTowardsLeft = false;
                    col++;
                } else if (col == 0) {
                    // Reached the first col, so move down and go up.
                    goingDownTowardsLeft = false;
                    row++;
                } else {
                    col--;
                    row++;
                }
            } else {
                if (col == cols - 1) {
                    // Reached last col, so move down and go down
                    goingDownTowardsLeft = true;
                    row++;
                } else if (row == 0) {
                    // Reached first row, so move right and go down.
                    goingDownTowardsLeft = true;
                    col++;
                } else {
                    row--;
                    col++;
                }
            }
        }
        return op;
    }
}
