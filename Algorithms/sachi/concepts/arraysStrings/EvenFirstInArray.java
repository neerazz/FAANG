package concepts.arraysStrings;

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
        System.out.println("Even first array second attempt is " + Arrays.toString(evenNaive1(arr)));
        System.out.println("Even first array second attempt optimized is " + Arrays.toString(evenOptimized2(arr)));
    }

    private static int[] evenNaive1(int[] arr) {
        int[] sol = new int[arr.length];
        int i = 0, j = arr.length - 1;
        for (int value : arr) {
            if (value % 2 == 0) {
                sol[i++] = value;
            } else {
                sol[j--] = value;
            }
        }
        return sol;
    }

    private static int[] evenOptimized2(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] % 2 == 0) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        return arr;
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
