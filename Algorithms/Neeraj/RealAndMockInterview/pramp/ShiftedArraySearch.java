/**
 * Created on:  May 21, 2020
 * Questions: https://www.pramp.com/challenge/N5LYMbYzyOtbpovQoYPX
 * A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and you don’t have a pre-shifted copy of it.
 * For instance, the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after shifting it twice to the left.
 * <p>
 * Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the index of num in shiftArr.
 * If num isn’t in shiftArr, return -1. Assume that the offset can be any value between 0 and arr.length - 1.
 * Explain your solution and analyze its time and space complexities.
 * Example:
 * input:  shiftArr = [9, 12, 17, 2, 4, 5], num = 2 # shiftArr is the
 * # outcome of shifting
 * # [2, 4, 5, 9, 12, 17]
 * # three times to the left
 * output: 3 # since it’s the index of 2 in arr
 */
public class ShiftedArraySearch {

    static int shiftedArrSearch(int[] arr, int num) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[start] == num) return start;
            if (arr[mid] == num) return mid;
            if (arr[end] == num) return end;
            if (arr[start] < arr[mid]) {
                // Left is valid
                if (arr[start] < num && num < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // Right is valid
                if (arr[mid] < num && num < arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 2, 4, 5}, 2));
        System.out.println(shiftedArrSearch(new int[]{9, 12, 17, 2, 4, 5}, 4));
    }
}
