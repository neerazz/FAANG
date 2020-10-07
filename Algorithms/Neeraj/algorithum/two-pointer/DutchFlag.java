import java.util.Arrays;

/**
 * Created on:  Oct 06, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/RMBxV6jz6Q0
 */

public class DutchFlag {

    public static void main(final String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
        arr = new int[]{2, 2, 0, 1, 2, 0};
        DutchFlag.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(final int[] arr) {
        int zero = 0, two = arr.length - 1, i = 0;
        while (i <= two) {
            final int cur = arr[i];
            if (cur == 1) {
                i++;
            } else if (cur == 0) {
                DutchFlag.swap(arr, i++, zero++);
            } else {
                DutchFlag.swap(arr, i, two--);
            }
//            System.out.println(Arrays.toString(arr));
        }
    }

    private static void swap(final int[] arr, final int a, final int b) {
        final int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
