/**
 * Created on:  Oct 08, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/R8LzZQlj8lO
 */

public class OrderAgnosticBinarySearch {

    public static int search(int[] arr, int key) {
        int len = arr.length;
        if (arr[0] == arr[len - 1]) return arr[0] == key ? 0 : -1;
        if (arr[0] < arr[len - 1]) {
            int start = 0, end = len - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == key) return mid;
                if (arr[mid] < key) start = mid + 1;
                else end = mid;
            }
            return arr[start] == key ? start : -1;
        } else {
            int start = 0, end = len - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == key) return mid;
                if (arr[mid] > key) start = mid + 1;
                else end = mid;
            }
            return arr[start] == key ? start : -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[]{4, 6, 10}, 10));
        System.out.println(BinarySearch.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        System.out.println(BinarySearch.search(new int[]{10, 6, 4}, 10));
        System.out.println(BinarySearch.search(new int[]{10, 6, 4}, 4));
    }
}
