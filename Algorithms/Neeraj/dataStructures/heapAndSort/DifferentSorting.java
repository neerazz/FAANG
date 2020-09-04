/**
 * Created on:  Sep 02, 2020
 * Questions: https://www.algoexpert.io/questions/Bubble%20Sort
 */
public class DifferentSorting {
    public static void main(String[] args) {

    }

    public static int[] bubbleSort(int[] array) {
        boolean swapped = true;
        int end = array.length;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < end; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            end--;
        }
        return array;
    }
}
