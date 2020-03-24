import java.util.Arrays;

class PanCakeSort {


    static void flip(int[] arr, int k) {
        for (int i = 0; i < k / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[k - 1 - i];
            arr[k - 1 - i] = temp;
        }
    }

    static int[] pancakeSort(int[] arr) {
        int endIndex = arr.length;
        while (endIndex > 0) {
            int index = findLargestIndex(arr, endIndex);
            flip(arr, index + 1);
            flip(arr, endIndex);
            endIndex--;
        }
        return arr;
    }

    static int findLargestIndex(int[] arr, int bound) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < bound; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(pancakeSort(new int[]{1, 2, 3, 4, 5})));
    }
}