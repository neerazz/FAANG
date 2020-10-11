import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 08, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/7nPmB8mZ6vj
 */

public class RotationCountOfRotatedArray {

    public static int countRotations(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) // if mid is greater than the next element
                return mid + 1;
            if (mid > start && arr[mid - 1] > arr[mid]) // if mid is smaller than the previous element
                return mid;
            if (arr[mid] < arr[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[]{10, 15, 1, 3, 8}));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[]{4, 5, 7, 9, 10, -1, 2}));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[]{1, 3, 8, 10}));
    }
}
