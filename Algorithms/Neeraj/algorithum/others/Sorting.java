import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  Jun 09, 2020
 * Questions: Implement below type of sorting.
 * 1. Merge Sort
 * 2. Quick Sort
 * 3. Insertion Sort
 * 4. Heap Sort
 */
public class Sorting {
    public static void main(String[] args) {
        printAllSortResults(new int[]{12, -2, 10, -15});
        printAllSortResults(new int[]{60, 0, 60, 40, 20});
        printAllSortResults(new int[]{25, 17, 31, 13, 2});
    }

    private static void printAllSortResults(int[] nums) {
        System.out.println("*****************************************************");
        System.out.println("Input           \t" + Arrays.toString(nums));
        System.out.println("Merge Sort:     \t" + Arrays.toString(mergeSort(Arrays.copyOf(nums, nums.length))));
        System.out.println("Quick Sort:     \t" + Arrays.toString(quickSort(Arrays.copyOf(nums, nums.length))));
        System.out.println("Insertion Sort: \t" + Arrays.toString(insertionSort(Arrays.copyOf(nums, nums.length))));
        System.out.println("Heap Sort:      \t" + Arrays.toString(heapSort(Arrays.copyOf(nums, nums.length))));
    }

    /**
     * @param arr Input array that will be splitted.
     * @return The sorted array.
     * @implNote Splits the array into two parts, and merger the two parts.
     */
    private static int[] mergeSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return arr;
        int mid = len / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int l1 = left.length, l2 = right.length;
        int[] op = new int[l1 + l2];
        int p1 = 0, p2 = 0, index = 0;
        while (p1 < l1 && p2 < l2) {
            if (left[p1] <= right[p2]) {
                op[index++] = left[p1++];
            } else {
                op[index++] = right[p2++];
            }
        }
        while (p1 < l1) op[index++] = left[p1++];
        while (p2 < l2) op[index++] = right[p2++];
        return op;
    }

    /**
     * @implNote Pick a Pivot point (int this case the last element).
     */
    private static int[] quickSort(int[] arr) {
        pickPivot(arr, 0, arr.length - 1);
        return arr;
    }

    private static void pickPivot(int[] arr, int start, int end) {
        if (start < 0 || start >= end) return;
        int pivot = partition(arr, start, end);
        pickPivot(arr, start, pivot - 1);
        pickPivot(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pVal = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pVal) {
                int temp = arr[start];
                arr[start++] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[start];
        arr[start] = pVal;
        arr[end] = temp;
        return start;
    }

    /**
     * @implNote Pick an element from 1st index to n-1 th index. And keep swapping with left if the left is greater.
     */
    private static int[] insertionSort(int[] arr) {
        int len = arr.length;
        if (len == 1) return arr;
        for (int i = 1; i < len; i++) {
            int cur = arr[i], preIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > cur) {
//                    Then swap i and j and keep moving
                    int temp = arr[j];
                    arr[j] = arr[preIndex];
                    arr[preIndex] = temp;
                    preIndex = j;
                } else {
                    break;
                }
            }
        }
        return arr;
    }

    private static int[] heapSort(int[] arr) {
        return new int[0];
    }
}