import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 23, 2024
 * Ref: In this problem, you have to implement the int findMinimum(int[] arr) method, which will traverse the whole array and find the smallest number in the array.
 */

public class CheckMinimum {

    public static void main(String[] args) {

    }

    public static int findMinimum(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        return Arrays.stream(arr).min().getAsInt();
    }

}
