import java.util.Arrays;

/**
 * Created on:  Sep 02, 2020
 * Questions: https://www.algoexpert.io/questions/Bubble%20Sort
 */
public class DifferentSorting {
    public static void main(String[] args) {

    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;
//        Split
        int mid = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));
//        Merge both the array
        int i = 0, j = 0, l1 = left.length, l2 = right.length, idx = 0;
        while (i < l1 && j < l2) {
            if (left[i] <= right[j]) {
                array[idx++] = left[i++];
            } else {
                array[idx++] = right[j++];
            }
        }
        while (i < l1) array[idx++] = left[i++];
        while (j < l2) array[idx++] = right[j++];
        return array;
    }

    /**
     * @implNote Divide the array into two. And starting from one element in left and remaining (un-sorted) in right.
     * Start from first element in right array, keep it in the correct place in the left array.
     * This way loop till the last element in the right list and keep adding in the left list.
     * Always the left array will be sorted. Once all teh elements are in the left array every thing is sorted.
     */
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k = i;
            while (k > 0 && array[k - 1] > array[k]) {
                swap(array, k - 1, k--);
            }
        }
        return array;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * @implNote At each level loop start from first:
     * Compare with the one with right, and if right is smaller, then swap the number and keep moving. (At end reduce the end index)
     */
    public static int[] bubbleSort(int[] array) {
        boolean swapped = true;
        int end = array.length;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < end; i++) {
                if (array[i - 1] > array[i]) {
                    swap(array, i - 1, i);
                    swapped = true;
                }
            }
            end--;
        }
        return array;
    }
}
