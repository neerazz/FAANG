import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 06, 2021
 * Questions: https://leetcode.com/problems/sliding-window-median/
 */

public class SlidingWindowMedian {

    public static void main(String[] args) {

    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length, j = 0;
        boolean isEven = k % 2 == 0;
        double[] result = new double[len - k + 1];
        for (int i = 0; i < len && j < result.length; i++) {
            int[] sub = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(sub);
            double sum = sub[k / 2];
            if (isEven) {
                sum += sub[(k - 1) / 2];
                sum /= 2;
            }
            result[j++] = sum;
        }
        return result;
    }
}
