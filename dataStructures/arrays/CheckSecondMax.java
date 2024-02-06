import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 24, 2024
 * Ref:
 * In this problem, you have to implement the int findSecondMaximum(int[] arr) method, which will traverse the whole array and return the second largest element present in the array.
 * <p>
 * Assumption: Array should contain at least two unique elements.
 * <p>
 * Method Prototype
 * int findSecondMaximum(int[] arr)
 * Output
 * Second-largest element present in the array.
 * <p>
 * Sample Input
 * arr = {9,2,3,6}
 * Sample Output
 * 6
 */

public class CheckSecondMax {

    public static void main(String[] args) {

    }

    public int findSecondMaximum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        return secondMax;
    }

    public static void rotateArray(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }
        int len = arr.length;
        int pre = arr[len - 1];
        for (int i = 0; i < len; i++) {
            int temp = arr[i];
            arr[i] = pre;
            pre = temp;
        }
    }

}
