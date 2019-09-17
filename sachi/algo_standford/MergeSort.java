import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        printArray("Unsorted", input);
        sort(input);
        printArray("Sorted", input);
        scanner.close();
    }

    private static void sort(int[] input) {
        mergeSort(input, 0, input.length - 1);
    }

    private static void mergeSort(int[] n, int l, int r) {
        // Base Case
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(n, l, m);
            mergeSort(n, m + 1, r);
            merge(n, l, m, r);
        }
    }

    private static void merge(int[] n, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy to intermediate arrays
        for (int i = 0; i < n1; i++) {
            L[i] = n[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = n[m + 1 + j];
        }
        // Merge them
        int i = 0, j = 0, k = l;
        while (i < L.length && j < R.length) {
            if (L[i] > R[j]) {
                n[k] = L[i];
                i++;
            } else {
                n[k] = R[j];
                j++;
            }
            k++;
        }

        // Add remaining elements
        while (i < n1) {
            n[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            n[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Print Array
     *
     * @param input
     */
    private static void printArray(String message, int input[]) {
        System.out.println(message);
        Arrays.stream(input).forEach(i -> System.out.print(i + " "));
        System.out.println("\n");
    }
}