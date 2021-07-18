package epi.czero;

import util.Util;

/**
 * Your input is an array of integers, and you have to reorder its entries so that the even entries appear first.
 */

public class EvenOdd {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 2, 11, 15, 12};
        Util.print(evenOddNaive(arr));
        Util.print(evenOdd(arr));
        Util.print(evenOddSolution(arr));
    }

    //Move even entries to first
    //[7, 8, 2, 11, 15, 12]
    private static int[] evenOddNaive(int[] arr) {
        int[] odd = new int[arr.length];
        int[] even = new int[arr.length];
        int o = 0, e = 0;
        for (int a : arr) {
            if (a % 2 == 0) {
                even[e++] = a;
            } else {
                odd[o++] = a;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i < e) {
                arr[i] = even[i];
            } else {
                arr[i] = odd[i - e];
            }
        }
        return arr;
    }

    private static int[] evenOdd(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] % 2 != 0) {
                //Swap
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                end--;
            } else {
                start++;
            }
        }
        return arr;
    }

    /**
     * Text book solution
     *
     * @param A
     * @return
     */
    private static int[] evenOddSolution(int[] A) {
        int nextEven = 0, nextOdd = A.length - 1;
        while (nextEven < nextOdd) {
            if (A[nextEven] % 2 == 0) {
                nextEven++;
            } else {
                int temp = A[nextEven];
                A[nextEven] = A[nextOdd];
                A[nextOdd--] = temp;
            }
        }
        return A;
    }
}
