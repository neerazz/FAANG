import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created on:  Jan 16, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-zombie-matrix
 */

public class ZombieMatrix {

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(humanDays(new int[][]{{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}}));
    }

    public static int humanDays(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        if (cols == 0) return -1;
        int days = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    queue.add(new int[]{row, col});
                }
            }
        }
//        If matrix has all humans.
        if (queue.size() == rows * cols) return -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;
            List<int[]> change = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (canBeInfected(matrix, poll[0], poll[1], rows, cols)) {
                    change.add(new int[]{poll[0], poll[1]});
                } else {
                    queue.add(poll);
                }
            }
            for (int[] ele : change) {
                matrix[ele[0]][ele[1]] = 1;
            }
        }
        return days;
    }

    private static boolean canBeInfected(int[][] matrix, int row, int col, int rows, int cols) {
        for (int[] dir : dirs) {
            int nr = row + dir[0], nc = col + dir[1];
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && matrix[nr][nc] == 1) return true;
        }
        return false;
    }
}
