import java.util.Arrays;

/**
 * Created on:  Jun 12, 2020
 * Questions:
 */
public class PancakeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pancakeSort(new int[]{1, 5, 4, 3, 2})));
        System.out.println(Arrays.toString(pancakeSort(new int[]{1, 42, -1, 3, 3, 2})));
    }

    static int[] pancakeSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIdx = findMax(arr, arr.length - i);
            flip(arr, maxIdx + 1);
            flip(arr, arr.length - i);
        }
        return arr;
    }

    private static int findMax(int[] arr, int range) {
        int maxVal = Integer.MIN_VALUE, maxIdx = -1;
        for (int i = 0; i < range; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    private static void flip(int[] arr, int k) {
        int start = 0, end = k - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
