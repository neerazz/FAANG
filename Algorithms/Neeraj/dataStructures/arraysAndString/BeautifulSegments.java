/*
    Created on:  May 07, 2020
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Questions: https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/beautiful-segments/
 */
public class BeautifulSegments {
    public static void main(String[] args) {
        FastReader fr = new FastReader("C:\\Users\\bnira\\Downloads\\3430bd1ed5-in.txt.clean.txt");
        int t = fr.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = fr.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = fr.nextInt();
            }
            sb.append(getBeautifulSegmentsCount(nums, n)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int getBeautifulSegmentsCount(int[] nums, int n) {
        List<Integer> list = new ArrayList<>();
        int odd = 3;
        while (odd <= n) {
            list.add(odd);
            odd += 2;
        }
//        Loop through all the possible ods and expand from center.
        int count = 0;
        for (int num : list) {
            int start = 0;
            while (start + num <= n) {
                if (isBeautiful(Arrays.copyOfRange(nums, start, start + num), num)) {
                    count++;
                }
                start++;
            }
        }
        return count;
    }

    private static boolean isBeautiful(int[] nums, int len) {
        int mid1 = len / 2, mid2 = len / 2, diff = 1;
        while (mid1 - diff >= 0) {
            if (nums[mid1 - 1] <= nums[mid1] && nums[mid2] > nums[mid2 + 1]) {
                mid1--;
                mid2++;
            } else {
                return false;
            }
        }
        return true;
    }
}
