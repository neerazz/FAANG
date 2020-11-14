import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 13, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/xog6q15W9GP
 * Problem Statement #
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 *
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 *
 * Example 1:
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 */

public class PairWithTargetSum {

    public static void main(String[] args) {

    }
    public static int[] search(int[] arr, int target) {
        int start =0, end = arr.length-1;
        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == target){
                return new int[]{start, end};
            }else if(sum < target){
                start++;
            }else{
                end--;
            }
        }
        return new int[] { -1, -1 };
    }
}
