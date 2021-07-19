

/**
 * Created on:  Oct 08, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/R1B78K9oBEz
 */

public class FindRange {

    public static int[] findRange_rev2(int[] arr, int key) {
        int left = -1, right = -1;
        left = getBoundary(arr, key, true);
        if (left != -1) right = getBoundary(arr, key, false);
        return new int[]{left, right};
    }

    static int getBoundary(int[] nums, int key, boolean leftBoundary) {
        int idx = -1, start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                idx = mid;
                if (leftBoundary) end = mid - 1;
                else start = mid + 1;
            } else if (nums[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }

    public static int[] findRange(int[] arr, int key) {
        int[] result = new int[]{-1, -1};
        int lower = getleftBoundry(arr, key);
        if (lower >= 0) {
            result[0] = lower;
            int start = 0, end = arr.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == key) {
                    if (mid == arr.length - 1 || arr[mid + 1] != key) {
                        result[1] = mid;
                        return result;
                    }
                    start = mid + 1;
                } else if (arr[mid] < key) start = mid + 1;
                else end = mid;
            }
        }
        return result;
    }

    private static int getleftBoundry(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                end = mid;
            } else if (arr[mid] > key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr[start] == key ? start : -1;
    }

    public static void main(String[] args) {
        int[] result = FindRange.findRange(new int[]{4, 6, 6, 6, 9}, 6);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 10);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
        result = FindRange.findRange(new int[]{1, 3, 8, 10, 15}, 12);
        System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    }
}
