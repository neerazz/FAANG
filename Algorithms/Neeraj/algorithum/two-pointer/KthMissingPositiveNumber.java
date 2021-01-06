import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 06, 2021
 * Questions: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3594/
 */

public class KthMissingPositiveNumber {

    public static void main(String[] args) {

    }
    public static int findKthPositive(int[] arr, int k) {
        int pre = 0, count =0;
        for(int num: arr){
            int cur = num - pre -1;
            if(cur + count >= k) break;
            count += cur;
            pre = num;
        }
        while(count < k){
            pre++;
            count++;
        }
        return pre;
    }
}
