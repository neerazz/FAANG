import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{-4, 0, 7, 4, 9, -5, -1, 0, -7, -1})));
    }

    public static int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        //Base Case
        if (start == end) {
            return new int[]{arr[start]};
        }
        int mid = (start + end) / 2;
        if (mid == start) mid = end;
        int[] left = mergeSort(arr, start, mid - 1);
        int[] right = mergeSort(arr, mid, end);
        return merge(left, right);
    }

    public static int[] merge(int[] a1, int[] a2) {
        int p1 = 0, p2 = 0, i = 0;
        int[] sorted = new int[a1.length + a2.length];

        while (p1 < a1.length && p2 < a2.length) {
            if (a1[p1] < a2[p2]) {
                sorted[i++] = a1[p1];
                p1++;
            } else {
                sorted[i++] = a2[p2];
                p2++;
            }
        }

        //Check if P1 is not null
        for (int j = p1; j < a1.length; j++) {
            sorted[i++] = a1[j];
        }

        //Check if P1 is not null
        for (int j = p2; j < a2.length; j++) {
            sorted[i++] = a2[j];
        }

        return sorted;
    }
}
