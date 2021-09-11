import java.util.Arrays;

/**
 * Created on:  Feb 02, 2021
 * Questions: https://www.algoexpert.io/questions/Subarray%20Sort
 */

public class SubArraySort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
        System.out.println(Arrays.toString(subarraySort_rev1(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
        System.out.println(Arrays.toString(subarraySort_rev1(new int[]{2, 1})));
        System.out.println(Arrays.toString(subarraySort_rev1(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 7, 7, 16, 18, 19})));
        System.out.println(Arrays.toString(subarraySort_rev1(new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89})));
    }

    public static int[] subarraySort_rev1(int[] nums) {
        int len = nums.length, i = 0, j = len - 1;
        while (i < len - 1 && nums[i] <= nums[i + 1]) {
            i++;
        }
        while (j > 0 && nums[j - 1] <= nums[j]) {
            j--;
        }
        if (j == 0 || i == len) return new int[]{-1, -1};
        if (i == 0 && j == len - 1) return new int[]{i, j};
//        Take max and min between i and j.
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int k = Math.min(i, j); k <= Math.max(i, j); k++) {
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }
//        Push i, so that val at i is less then or equal to min.
        while (i >= 0 && nums[i] > min) i--;
//        Push j, so that val at j is greater then or equal to max.
        while (j < len && nums[j] < max) j++;
//        Since i and j are both advanced bring them back.
        return new int[]{i + 1, j - 1};
    }

    public static int[] subarraySort(int[] array) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // 		Find the lowest and highest incorrect ordered value in the array.
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int cur = array[i];
            if (i == 0) {
                // Then check only with right side value.
                if (cur > array[i + 1]) {
                    min = Math.min(cur, min);
                    max = Math.max(cur, max);
                }
            } else if (i == len - 1) {
                // Then check only with left side value.
                if (cur < array[i - 1]) {
                    min = Math.min(cur, min);
                    max = Math.max(cur, max);
                }
            } else {
                // Check with both the sides of values, and see if cur value is start or the end of un-sorted sub-array
                if (cur > array[i + 1] || cur < array[i - 1]) {
                    min = Math.min(cur, min);
                    max = Math.max(cur, max);
                }
            }
        }
        if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
            return new int[]{-1, -1};
        }
        int[] op = new int[2];
        op[0] = findIndex(min, array);
        op[1] = findIndex(max, array);
        return op;
    }

    private static int findIndex(int val, int[] arr) {
//        System.out.println("val =" + val + " array=" + Arrays.toString(arr));
        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
            if (val < arr[i]) {
                return pre;
            } else {
                pre = i;
            }
        }
        return -1;
    }
}
