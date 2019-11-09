import java.util.Arrays;
import java.util.Scanner;

/*Selection Sort - O(n2)
FInd least in the remaining array
Move that to front
Keep doing this for all records until you finish*/

public class P_SortSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        printArray(selectionSort(a));
        scanner.close();
    }

    private static int[] selectionSort(int[] a) {
        int n = a.length;
        if (n == 1)
            return a;
        int minIndex;
        boolean swap;
        for (int i = 0; i < n; i++) {
            minIndex = i;
            swap = false;
            for (int j = i; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                    swap = true;
                }
            }
            // Swap
            if (swap) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        return a;
    }

    private static void printArray(int[] a) {
        Arrays.stream(a).forEach(el -> System.out.print(el + " "));
    }
}