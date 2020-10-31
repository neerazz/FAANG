import java.util.*;
import java.io.*;

/**
 * Created on:  Oct 31, 2020
 * Questions: https://leetcode.com/discuss/interview-question/364618/
 */

public class MinStepsToMakePilesEqualHeight {

    public static void main(String[] args) {
        System.out.println(minSteps(new int[]{5, 2, 1}));
    }

    private static int minSteps(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) count++;
        }
        return count;
    }
}
