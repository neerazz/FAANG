import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 28, 2020
 * Questions: https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3510/
 */

public class SummaryRanges {

    public static void main(String[] args) {

    }
    public static List<String> summaryRanges(int[] nums) {
        int p1 =0, p2 =1, len = nums.length;
        if(len == 0) return new ArrayList<>();
        if(len == 1) return Arrays.asList(getString(nums, 0,0));
        List<String> op = new ArrayList<>();
        while(p2 < len){
            if(nums[p2-1] +1 == nums[p2]){
                p2++;
            }else{
                op.add(getString(nums, p1, p2-1));
                p1 = p2;
                p2++;
            }
        }
        op.add(getString(nums, p1, p2-1));
        return op;
    }
    private static String getString(int[] nums, int p1, int p2){
        if(p1 == p2) return "" + nums[p1];
        return String.format("%d->%d",nums[p1], nums[p2]);
    }
}
