/**
 * Created on:  Jul 19, 2020
 * Questions: https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, last = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[last--] = nums1[p1--];
            } else {
                nums1[last--] = nums2[p2--];
            }
        }
        while (p1 >= 0) nums1[last--] = nums1[p1--];
        while (p2 >= 0) nums1[last--] = nums2[p2--];
    }
}
