package vivek.OA;

import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 03, 2021
 * Questions:
 */

public class Q1 {

    public static void main(String[] args) {
        System.out.println(minimumAdjacentSwapsToSortArray(Arrays.asList(7, 1, 2)));
        System.out.println(minimumAdjacentSwapsToSortArray(Arrays.asList(10, 3, 4, 2, 5, 7, 9, 11)));
    }

    private static long minimumAdjacentSwapsToSortArray(List<Integer> arr) {
        return divide(arr, 0, arr.size() - 1);
    }

    private static long divide(List<Integer> array, int s, int e) {
        Collections.swap(array, s, e);
        if (s >= e) return 0;
        int mid = s + (e - s) / 2;
        long left = divide(array, s, mid);
        long right = divide(array, mid + 1, e);
        long swaps = mergeAndCount(array, s, mid, e);
        return left + right + swaps;
    }

    private static long mergeAndCount(List<Integer> array, int s, int m, int e) {
        List<Integer> left = array.subList(s, m + 1);
        List<Integer> right = array.subList(m + 1, e + 1);
        int i = 0, j = 0, k = s, swaps = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
//                Then a swap is not needed
                array.set(k++, left.get(i++));
            } else {
//                Swap the element from right to the ith index.
                array.set(k++, right.get(j++));
                swaps += (m + 1) - (s + i);
            }
        }
//        fill rest of the elements, if any
        while (i < left.size())
            array.set(k++, left.get(i++));

        while (j < right.size())
            array.set(k++, right.get(j++));
        return swaps;
    }
}
