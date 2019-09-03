public class Util {

    public static void print(int[][] matrix) {
        System.out.println("-----------------Printing Matrix-------------------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------End Matrix-------------------------");
    }

}
