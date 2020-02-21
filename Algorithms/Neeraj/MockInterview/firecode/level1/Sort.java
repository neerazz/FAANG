package firecode.level1;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSortArray(new int[]{5, 4, 3})));
        System.out.println(Arrays.toString(bubbleSortArray(new int[]{5, 1, 4, 2, 8, 9})));
        System.out.println(Arrays.toString(bubbleSortArray(new int[]{6, 5, 3, 1, 8, 7, 2, 4})));
    }

    public static int[] bubbleSortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
