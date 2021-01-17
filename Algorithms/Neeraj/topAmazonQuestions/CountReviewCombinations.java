import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/55879348999
 */

public class CountReviewCombinations {

    public static void main(String[] args) {
        System.out.println(getCount(8, new int[]{6, 13, 5, 10, 12, 4, 2, 15}, 3, 4, 10));
    }

    private static int getCount(int n, int[] nums, int reviews, int min, int max) {
        int count = 0, result = 0;
        for (int num : nums) {
            if (min <= num && num <= max) {
                count++;
            }
        }
        for (int i = reviews; i <= count; i++) {
            result += ncr(count, i);
        }
        return result;
    }

    private static int ncr(int n, int r) {
        if (n == r) return 1;
        int top = fact(n, r + 1);
        int bottom = fact(n-r, 1);
        return top / bottom;
    }

    private static int fact(int from, int end) {
        int result = 1;
        for (int i = from; i >= end; i--) {
            result *= i;
        }
        return result;
    }
}
