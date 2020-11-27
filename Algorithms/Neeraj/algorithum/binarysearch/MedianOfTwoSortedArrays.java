/*
https://leetcode.com/explore/learn/card/binary-search/146/more-practices-ii/1040/
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.
Example 1:
nums1 = [1, 3]
nums2 = [2]
The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]
The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
//        System.out.println("Answer is :" + findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) + " should be [2.0].");
//        System.out.println("Answer is :" + findMedianSortedArrays_revision1(new int[]{1, 3}, new int[]{2}) + " should be [2.0].");
        System.out.println("Answer is :" + findMedianSortedArrays(new int[0], new int[]{1}) + " should be [1.0].");
        System.out.println("Answer is :" + findMedianSortedArrays_revision1(new int[0], new int[]{1}) + " should be [1.0].");
    }

    private static double findMedianSortedArrays_revision1(int[] A, int[] B) {
        int alen = A.length, blen = B.length;
        if (alen > blen) return findMedianSortedArrays_revision1(B, A);
        boolean isODD = (alen + blen) % 2 != 0;
        int apoint = alen / 2;
//        Start form the start of the first array and loop till the end if the first array
//        And try to find the possible intersection point, if there is none then exit.
        while (apoint <= alen && apoint >= 0) {
            int bpoint = ((alen + blen + 1) / 2) - apoint;
            if (apoint > 0 && A[apoint - 1] > B[bpoint]) {
                apoint--;
            } else if (apoint < alen && A[apoint] < B[bpoint - 1]) {
                apoint++;
            } else {
//                Get left max
                int leftMax;
                if (bpoint <= 0) {
                    leftMax = A[apoint - 1];
                } else if (apoint <= 0) {
                    leftMax = B[bpoint - 1];
                } else {
                    leftMax = Math.max(A[apoint - 1], B[bpoint - 1]);
                }
                if(isODD) return leftMax;
//                Get the right side value
                int rightMin;
                if (apoint == alen) {
                    rightMin = B[bpoint];
                } else if (bpoint >= blen) {
                    rightMin = A[apoint];
                } else {
                    rightMin = Math.min(A[apoint], B[bpoint]);
                }
                return (double) (leftMax + rightMin) / 2;
            }
        }
        return 0.0;
    }

    private static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
