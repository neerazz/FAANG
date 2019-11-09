import java.util.Arrays;

public class P_QuickSort {
    public static void main(String[] args) {
        int max = 1000;
        int min = 1;
        for (int c = 0; c < 3; c++) {
            int n = (int) (Math.random() * (max - min + 1));
            int[] input = new int[n];
            int[] input1 = new int[n];
            for (int i = 0; i < n; i++) {
                int rand = (int) (Math.random() * 10);
                input[i] = rand;
                input1[i] = rand;
            }
            Arrays.sort(input1);
            quickSort(input, 0, input.length - 1);
            if (!Arrays.equals(input, input1)) {
                System.out.print("Expected - ");
                printArray(input1);
                System.out.print("\nActual - ");
                printArray(input);
                break;
            }
        }
    }

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