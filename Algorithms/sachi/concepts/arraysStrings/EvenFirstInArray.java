import java.util.Arrays;
import java.util.Scanner;

/**
 * Move all the even number to front in array
 * {1,4,2,9,5} -> {4,2,1,9,5}
 */

public class EvenFirstInArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Even first array optimized is " + Arrays.toString(evenFirst(arr)));
        System.out.println("Even first array naive is " + Arrays.toString(evenFirstNaive(arr)));
    }

    private static int[] evenFirst(int[] arr) {
        int a = 0, b = arr.length - 1;
        while (a < b) {
            if (arr[a] % 2 == 0) {
                a++;
            } else {
                int temp = arr[a];
                arr[a] = arr[b];
                arr[b] = temp;
                b--;
            }
        }
        return arr;
    }

    //Use O(n) space
    private static int[] evenFirstNaive(int[] arr) {
        //Use O(n) space
        int[] sol = new int[arr.length];
        int a = 0, b = arr.length - 1;
        for (int elem : arr) {
            if (elem % 2 == 0) {
                sol[a++] = elem;
            } else {
                sol[b--] = elem;
            }
        }
        return sol;
    }
}
