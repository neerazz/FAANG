import java.util.Arrays;

public class MatrixDiagonalTraverse {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        Arrays.stream(matrix).forEach(e -> System.out.print(e + " "));
    }

    private static int[] findDiagonalOrder(int[][] matrix) {

    }
}