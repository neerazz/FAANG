import java.util.Arrays;

/**
 * Created on:  Nov 07, 2020
 * Questions: https://leetcode.com/discuss/interview-question/836679/uber-online-assessment-sept-2020/729778 Q1
 */

public class CountNumberWithCondition {

    public static void main(String[] args) {
        System.out.println(countNumber(new int[]{7, 6, 9}, new int[]{13, 1, 4}, 3));
    }

    private static int countNumber(int[] a, int[] b, int d) {
        Arrays.sort(a);
        Arrays.sort(b);
        int count = 0;
        for (int num : a) {
            int min = getIndexAboveN(b, num - d), max = getIndexBelowN(b, num + d);
            if (min == -1 || max == -1) continue;
            count += max - min + 1;
        }
        return count;
    }

    private static int getIndexBelowN(int[] nums, int tar) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= tar) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        if (nums[start] < tar) return start;
        return nums[end] < tar ? end : -1;
    }

    private static int getIndexAboveN(int[] nums, int tar) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= tar) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start] > tar ? start : -1;
    }
}
