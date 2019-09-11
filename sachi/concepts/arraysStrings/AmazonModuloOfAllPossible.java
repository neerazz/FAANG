import java.util.Scanner;

public class AmazonModuloOfAllPossible {
    public static void main(String[] args) {
        /*
         * Scanner scanner = new Scanner(System.in); int n = scanner.nextInt(); int[]
         * input = new int[n]; for (int i = 0; i < n; i++) { input[i] =
         * scanner.nextInt(); } scanner.close();
         */
        int[] arr = Util.generateRandomArray();
        System.out.println(moduloBruteForce(arr));
    }

    private static int moduloArrayElegant(int[] input) {
        int len = input.length - 1;
        int sum = 0, i = 0, j = len;
        while (i == len && j == len) {

        }
        return 0;
    }

    private static int moduloBruteForce(int[] input) {
        int sum = 0;
        if (input == null || input.length == 0)
            return 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                sum = sum + (input[i] % input[j]);
            }
        }
        return sum;
    }

}