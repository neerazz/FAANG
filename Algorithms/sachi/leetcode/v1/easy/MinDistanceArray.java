package leetcode.v1.easy;

import java.util.Arrays;

public class MinDistanceArray {


    public static void main(String[] args) {
        int[] arr1 = {1,4,2,3};
        int[] arr2 = {-4,-3,6,10,20,30};
        int d = 3;
        System.out.println(findTheDistanceValue(arr1, arr2, d));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);
        int sol = 0;
        for (int value : arr1) {
            int min = findSmallestInArray(arr2, value);
            int max = findLargestInArray(arr2, value);
            if (min == max && (min < (value - d) || max > (value + d))) {
                sol++;
            } else if (min < (value - d) && max > (value + d)) {
                sol++;
            }
        }
        return sol;
    }

    public static int findSmallestInArray(int[] arr, int target) {

        int start = 0, end = arr.length - 1;
        int sol = arr[start];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return target;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                sol = arr[mid];
                start = mid + 1;
            }
        }
        return sol;

    }

    public static int findLargestInArray(int[] arr, int target) {

        int start = 0, end = arr.length - 1;
        int sol = arr[end];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return target;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                sol = arr[mid];
                end = mid - 1;
            }
        }
        return sol;

    }
}
