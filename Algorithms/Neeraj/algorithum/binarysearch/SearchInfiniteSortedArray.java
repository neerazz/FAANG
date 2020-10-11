import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 08, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/B1ZW38kXJB2
 */

public class SearchInfiniteSortedArray {

    public static int search(ArrayReader reader, int key) {
        int start = 0, end = 2;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int midval = reader.get(mid);
            if (midval == Integer.MAX_VALUE) {
                end = mid;
            } else if (midval == key) {
                return mid;
            } else if (midval < key) {
                start = mid + 1;
                end *= 2;
            } else {
                end = mid;
            }
        }
        return reader.get(start) == key ? start : -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[]{1, 3, 8, 10, 15});
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }

    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }
}