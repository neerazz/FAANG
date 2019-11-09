import java.util.Scanner;

public class Fibonaci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(calculateFastFibonaci(n));
        System.out.println(calculateFibonaci(n));
        scanner.close();
    }

    // Naive approach
    private static long calculateFibonaci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        return calculateFibonaci(n - 1) + calculateFibonaci(n - 2);
    }

    // Fast Approach
    private static long calculateFastFibonaci(int n) {
        long a = 0, b = 1, c = 1;
        if (n <= 0) return 0;
        if (n == 1) return 1;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}