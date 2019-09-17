import java.util.Arrays;
import java.util.Scanner;

public class P_PolynomialMul {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        // Set 1
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // Set 2
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        printArray(naivePolyMult(a, b));
        scanner.close();
    }

    /**
     * Naive Imp i < 0 to n, j < 0 to n
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] naivePolyMult(int[] a, int[] b) {
        int n = a.length;
        int[] product = new int[2 * n - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                product[i + j] += a[i] * b[j];
            }
        }
        return product;
    }

    //TODO: Implement Karatsuba

    public static void printArray(int[] a) {
        Arrays.stream(a).forEach(item -> System.out.print(" " + item));
    }

}