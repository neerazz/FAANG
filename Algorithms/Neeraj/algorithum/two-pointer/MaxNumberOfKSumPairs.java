import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 18, 2021
 * Questions: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3608/
 */

public class MaxNumberOfKSumPairs {

    public static void main(String[] args) {

    }
    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start =0, end = nums.length-1;
        int count =0;
        while(start < end){
            int sum = nums[start] + nums[end];
            if(sum == k){
                start++;
                end--;
                count++;
            }else if(sum < k){
                start++;
            }else{
                end--;
            }
        }
        return count;
    }
}
