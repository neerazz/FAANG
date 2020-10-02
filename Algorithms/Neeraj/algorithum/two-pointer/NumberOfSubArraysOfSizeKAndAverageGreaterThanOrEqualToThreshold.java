/**
 * Created on:  Sep 30, 2020
 * Questions: https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
 */
public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public static void main(String[] args) {

    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        double sum = 0;
        int idx = 0, count = 0, p1 = 0;
        while (idx < k - 1) {
            sum += arr[idx++];
        }
        for (int i = idx; i < arr.length; i++) {
            sum += arr[i];
            if (sum / k >= threshold) count++;
            sum -= arr[p1++];
        }
        return count;
    }
}
