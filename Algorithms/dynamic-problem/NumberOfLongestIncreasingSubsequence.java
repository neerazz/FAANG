import java.util.Arrays;

/**
 * Created on:  Oct 30, 2020
 * Questions: https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3513/
 */

public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }

    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length, maxLen = 0;
        if (len < 2) return len;
        int[] lens = new int[len];
        int[] counts = new int[len];
        Arrays.fill(lens, 1);
        Arrays.fill(counts, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lens[j] + 1 > lens[i]) {
//                        By appending the current element with jth element then length at i is more then, take the new len value.
                        lens[i] = lens[j] + 1;
                        counts[i] = counts[j];
                    } else if (lens[j] + 1 == lens[i]) {
//                        By appending the current element with jth element then length at i is same then, append the counts at that index.
                        counts[i] += counts[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, lens[i]);
        }
        System.out.println("maxLen = " + maxLen);
        System.out.println("lens = " + Arrays.toString(lens));
        System.out.println("counts = " + Arrays.toString(counts));
        int maxLenCount = 0;
        for (int i = 0; i < len; i++)
            if (lens[i] == maxLen) maxLenCount += counts[i];
        return maxLenCount;
    }
}
