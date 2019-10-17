import java.util.Arrays;

public class Revision {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] num3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, num3, 0, nums1.length);
        System.arraycopy(nums2, 0, num3, nums1.length, nums2.length);
        Arrays.sort(num3);
        if (num3.length % 2 == 0) {
            return (double) (num3[(num3.length - 1) / 2] + num3[num3.length / 2]) / 2;
        } else {
            return num3[num3.length / 2];
        }
    }
}