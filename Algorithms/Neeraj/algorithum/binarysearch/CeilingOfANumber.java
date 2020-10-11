import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 08, 2020
 * Questions:
 */

public class CeilingOfANumber {

    public static int searchCeilingOfANumber(int[] arr, int key) {
        int start =0, end = arr.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] == key) return mid;
            if(arr[mid] < key) start = mid+1;
            else end = mid;
        }
        return arr[start] >= key ? start : -1;
    }

    public static void main(String[] args) {
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(CeilingOfANumber.searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
