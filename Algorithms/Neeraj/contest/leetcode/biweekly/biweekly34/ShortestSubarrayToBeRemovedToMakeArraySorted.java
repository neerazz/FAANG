package biweekly.biweekly34;

/**
 * Created on:  Sep 05, 2020
 * Questions: https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 */
public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 2, 3}) + " = 0");
        System.out.println(findLengthOfShortestSubarray(new int[]{1, 3, 2, 4}) + " = 1");
        System.out.println(findLengthOfShortestSubarray(new int[]{13, 0, 14, 7, 18, 18, 18, 16, 8, 15, 20}) + " = 8");
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int left = 0, len = arr.length, right = len - 1;
        while (right > left && arr[right - 1] <= arr[right]) {
            right--;
        }
//        If reached to start then all values are in proper order.
        if (right == 0) return 0;
//        Start from start by assuming that you are removing all elements in the left (0 to right index)
        int result = right;
//        Start from left loop through the right, and keep calculating the elements to be removed at each level.
        while (left < len) {
//                exit the loop when found the invalid element from left.
            if (left > 0 && arr[left - 1] > arr[left]) break;
            while (right < len && arr[left] > arr[right]) {
//            keep increasing the left boundary (and collapsing the right boundary), till you find the problematic index.
                right++;
            }
//            Recalculate the result by removing the elements between left and right.
            result = Math.min(result, right - left - 1);
            left++;
        }
        return result;
    }
}
