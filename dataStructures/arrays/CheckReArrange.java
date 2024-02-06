import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 24, 2024
 * Ref:
 * In this problem, you have to implement the void reArrange(int[] arr) method, which will sort the elements, such that all the negative elements appear at the left and positive elements appear at the right.
 *
 * Note: Consider 0 as a positive number.
 *
 * Method Prototype
 * void reArrange(int[] arr)
 * Output
 * A sorted array with negative elements at the left and positive elements at the right.
 *
 * Sample Input
 * arr = {10, -1, 20, 4, 5, -9, -6}
 * Sample Output
 * arr = {-1, -9, -6, 10, 20, 4, 5}
 * Note: Order of the numbers doesn’t matter.
 *
 * {-1, -9, -6, 10, 20, 4, 5} = {-9, -1, -6, 10, 4, 20, 5}
 *
 */

public class CheckReArrange {

    public static void main(String[] args) {
        maxMin_optimal(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    public static void reArrange(int[] arr) {
        int len = arr.length;
        int p1 = 0, p2 = len-1;
        while(p2 >= 0){
            while(arr[p2] < 0 && p2 > p1){
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
                p1++;
            }
            p2--;
        }
    }

    public static void maxMin(int[] arr) {
        int start =0, end = arr.length-1, p =0;
        int[] temp = Arrays.copyOf(arr, arr.length);
        while(start < end){
            arr[p++] = temp[end];
            arr[p++] = temp[start];
            start++;
            end--;
        }
        if(start == end){
            arr[p++] = temp[start];
        }
    }

    public static void maxMin_optimal(int[] arr) {
        int start =0, end = arr.length-1, p =0;
        int maxElement = arr[end] + 1;
        for(int i=0; i<arr.length; i++){
            if (i % 2 == 0){
                arr[i] += (arr[end] % maxElement) * maxElement;
                end--;
            }else{
                arr[i] += (arr[start] % maxElement) * maxElement;
                start++;
            }
        }
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i] / maxElement;
        }
    }

}
