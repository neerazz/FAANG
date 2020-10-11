import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 08, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/mEGORlpZYJE
 */

public class SearchBitonicArray {

    public static int search(int[] arr, int key) {
        int idx = getMaxIdx(arr, key);
        int lowerIdx = getIdx(arr, 0, idx, true, key);
        if(lowerIdx >=0 ) return lowerIdx;
        return getIdx(arr, idx, arr.length-1, false, key);
    }

    private static int getIdx(int[] arr, int start, int end, boolean isAsending, int key){
        while(start < end){
            int mid = start + (end- start)/2;
            if(arr[mid] == key) return mid;
            if(arr[mid] < key){
                if(isAsending){
                    start = mid+1;
                }else{
                    end = mid;
                }
            } else{
                if(isAsending){
                    end = mid;
                }else{
                    start = mid+1;
                }
            }
        }
        return arr[start] == key ? start : -1;
    }

    private static int getMaxIdx(int[] arr, int key){
        int start = 0, end = arr.length-1;
        while(start < end){
            int mid = start + (end - start) /2;
            if(arr[mid] < arr[mid+1]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 4, 3 }, 4));
        System.out.println(SearchBitonicArray.search(new int[] { 3, 8, 3, 1 }, 8));
        System.out.println(SearchBitonicArray.search(new int[] { 1, 3, 8, 12 }, 12));
        System.out.println(SearchBitonicArray.search(new int[] { 10, 9, 8 }, 10));
    }
}
