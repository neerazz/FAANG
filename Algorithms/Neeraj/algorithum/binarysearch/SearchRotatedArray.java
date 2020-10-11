import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 08, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/N8XZQ1q1O46
 */

public class SearchRotatedArray {

    /*
        0  1  2  3  4  5
        4, 5, 7, 9, 10, -1, 2 t=10
                    s
                        m
                            e

        if start value == key: return start
        if mid value == key : return mid
        if end vlaue == key: return end
        if mid value < end value:
          if target > mid value && target < end value: go right
              start = mid+1
          else : go left
            end = mid;
        else:
          if target < mid value && target > start value: got left
            end = mid;
          else: go right
            start = mid +1;

    */
    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length-1;
        while(start < end){
            int mid = start + (end - start) /2;
            if(arr[start] == key) return start;
            if(arr[end] == key) return end;
            if(arr[mid] == key) return mid;
            if(arr[mid] < arr[end]){
                if(arr[mid] < key && key < arr[end]){
                    start = mid+1;
                }else{
                    end = mid;
                }
            }else{
                if(arr[start] < key && arr[mid] > key) end = mid;
                else start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
        System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
    }
}
