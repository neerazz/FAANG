import java.util.Arrays;
import java.util.Scanner;

public class W4_ImprovingQuickSort3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        quickSort(input, 0, input.length - 1);
        printArray(input);
        scanner.close();
    }

    // Video here - https://www.youtube.com/watch?v=IN6FotfaihQ
    // Three groups - For repeated elements
    // l-i -> less
    // i+1 - j-1 -> equal
    // j - r -> Greater
    private static void quickSort(int[] input, int l, int r) {
        if (input == null || input.length <= 1) {
            return;
        }
        if (r <= l) {
            return;
        }
        int i = l, lb = l, ub = r;
        while (i <= ub) {
            if (input[i] < input[lb]) {
                swap(input, i++, lb++);
            } else if (input[i] > input[lb]) {
                swap(input, i, ub--);
            } else if (input[i] == input[lb]) {
                i++;
            }
            quickSort(input, l, lb - 1);
            quickSort(input, ub + 1, r);
        }
    }

    private static void swap(int[] input, int a, int b) {
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    private static void printArray(int[] input) {
        Arrays.stream(input).forEach(i -> System.out.print(i + " "));
    }
}