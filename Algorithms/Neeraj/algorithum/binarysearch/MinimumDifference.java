/**
 * Created on:  Oct 08, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/mymvP915LY9
 */

public class MinimumDifference {

    public static int searchMinDiffElement_rev1(int[] arr, int key) {
        int start = 0, end = arr.length - 1, min = 0, max = end;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) return arr[mid];
            if (key < arr[mid]) {
                min = mid;
                end = mid - 1;
            } else {
                max = mid;
                start = mid + 1;
            }
        }
        int minIdx = 0, minDiff = Integer.MAX_VALUE;
        if (Math.abs(arr[start] - key) < minDiff) {
            minDiff = Math.abs(arr[start] - key);
            minIdx = start;
        }
        if (Math.abs(arr[min] - key) < minDiff) {
            minDiff = Math.abs(arr[min] - key);
            minIdx = min;
        }
        if (Math.abs(arr[max] - key) < minDiff) {
            minDiff = Math.abs(arr[max] - key);
            minIdx = max;
        }
        return arr[minIdx];
    }

    public static int searchMinDiffElement(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        Integer closest = null;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) return arr[mid];
            if (closest == null || Math.abs(closest - key) > Math.abs(arr[mid] - key)) {
                closest = arr[mid];
            }
            if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (Math.abs(closest - key) > Math.abs(arr[start] - key)) {
            closest = arr[start];
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println("*************************** Solution 1 ***********************************");
        System.out.println(searchMinDiffElement(new int[]{4, 6, 10}, 7));
        System.out.println(searchMinDiffElement(new int[]{4, 6, 10}, 4));
        System.out.println(searchMinDiffElement(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(searchMinDiffElement(new int[]{4, 6, 10}, 17));

        System.out.println("*************************** Solution 2 ***********************************");
        System.out.println(searchMinDiffElement_rev1(new int[]{4, 6, 10}, 7));
        System.out.println(searchMinDiffElement_rev1(new int[]{4, 6, 10}, 4));
        System.out.println(searchMinDiffElement_rev1(new int[]{1, 3, 8, 10, 15}, 12));
        System.out.println(searchMinDiffElement_rev1(new int[]{4, 6, 10}, 17));
    }
}
