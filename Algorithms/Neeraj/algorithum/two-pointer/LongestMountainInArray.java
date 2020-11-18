import java.util.*;
import java.io.*;

/**
 * Created on:  Nov 16, 2020
 * Questions: https://leetcode.com/problems/longest-mountain-in-array/
 */

public class LongestMountainInArray {

    public static void main(String[] args) {

    }

    public int longestMountain(int[] a) {
        int max = 0, len = a.length, p1 = 0, p2 = 1;
        while (p2 < len) {
            boolean foundIncreasing = false, foundDecreasing = false;
//             Keep increasing the till the array increases.
            while (p2 < len && a[p2 - 1] < a[p2]) {
                p2++;
                foundIncreasing = true;
            }

//             Keep reducing the till the array is descending.
            while (foundIncreasing && p2 < len && a[p2 - 1] > a[p2]) {
                p2++;
                foundDecreasing = true;
            }
            int curLen = p2 - p1;
            if (foundIncreasing && foundDecreasing) {
                if (curLen >= 3) max = Math.max(max, curLen);
                p1 = p2 - 1;
            } else {
                p1 = p2++;
            }
        }
        return max;
    }
}
