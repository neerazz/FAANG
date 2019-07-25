import java.util.Arrays;
import java.util.Scanner;

public class W4_BInarySearch1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        int p = scanner.nextInt();
        int[] s = new int[p];
        for (int i = 0; i < p; i++) {
            s[i] = scanner.nextInt();
        }
        printArray(findElements(input, s));
        scanner.close();
    }

    private static int[] findElements(int[] input, int[] s) {
        int[] sol = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            // Check base conditions
            if (s[i] < input[0] || s[i] > input[input.length - 1]) {
                sol[i] = -1;
            } else {
                sol[i] = binarySearch(input, 0, input.length - 1, s[i]);
            }
        }
        return sol;
    }

    // Binary Search
    private static int binarySearch(int[] array, int l, int r, int p) {
        if (r >= l) {
            int m = (l + r) / 2;
            if (p == array[m]) {
                return m;
            } else if (p < array[m]) {
                return binarySearch(array, l, m - 1, p);
            } else if (p > array[m]) {
                return binarySearch(array, m + 1, r, p);
            }
        }
        return -1;
    }

    public static void printArray(int[] a) {
        Arrays.stream(a).forEach(item -> System.out.print(" " + item));
    }
}