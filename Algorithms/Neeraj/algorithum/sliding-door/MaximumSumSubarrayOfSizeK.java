import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 05, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP
 */

public class MaximumSumSubarrayOfSizeK {

    public static void main(String[] args) {

    }
    public static int findMaxSumSubArray(int k, int[] arr) {
        int sum =0, max = Integer.MIN_VALUE;
        for(int i=0; i<k-1; i++) sum+= arr[i];
        for(int i=k-1; i<arr.length; i++){
            sum += arr[i];
            max = Math.max(max, sum);
            sum -= arr[i-k+1];
        }
        return max;
    }
}
