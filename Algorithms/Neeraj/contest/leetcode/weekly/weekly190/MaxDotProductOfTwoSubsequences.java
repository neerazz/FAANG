package weekly.weekly190;

import java.util.Arrays;

/**
 * Created on:  May 23, 2020
 * Questions: https://leetcode.com/problems/max-dot-product-of-two-subsequences
 */
public class MaxDotProductOfTwoSubsequences {
    public static void main(String[] args) {
        System.out.println("************************* Method 1 ********************************");
        System.out.println(maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}) + " should be [18]");
        System.out.println(maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}) + " should be [21]");
        System.out.println(maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}) + " should be [-1]");
        System.out.println(maxDotProduct(
                new int[]{-896, 151, -900, -765, -232, 494, -903, 876, -66, 827, -692, -79, 550, -764, 168, 403, 11, 14, -887, 507, 755, 656, 678, -588, -93, -649, -809, 728, -567, 729, 370, -518, 162, 886, 255, 121, -222, 161, 403, 467, 184, 948, 955, 342, 198, -282, 833, 693, 515, -206, 989, 687, 464, -391, 553, -902, -46, 904, 599, -87, 312, 528, -273, 993, 960, -460, 842, -929, -939, -185, -145, -380, -216, 812, 579, 608, 255, -22, -736, -37, -959, 535, 593, -165, -210, 699, 523, 711, 232, -258, 319, -298, -166, 376, 872, -622, 96, 6, 827, -245, -893, -454, 219, -202, -592, 48, 861, -691, -731, -639, 869, -524, -382, 443, 787, 30, -279, -597, 794, -926, 983, -772, -901, 643, 523, -713, -393, -170, -5, 560, 720, -992, -635, -411, -376, 92, 439, -360, -721, 886, 558, 712, -719, 649, 91, 503, -570, -690, -792, -217, 7, 137, 880, -284},
                new int[]{645, -556, -989, 479, 877, -619, -862, 538, -129, 192, -389, 124, 532, -976, -199, 20, -413, 644, 920, -809, 37, 710, 339, 57, -485, -160, 497, -24, -803, -902, 37, -503, -37, -22, -693, -315, -117, -348, -893, -16, 781, 144, 287, 340, -789, 78, 468, 507, -79, -588, -523, -278, 973, -858, 889, 519, 575, 652, -497, -260, -963, 802, 816, -856, -229, 7, 710, -745, -87, -593, 472, -327, -347, -310, -974, 19, -285, 827, -882, 212, 265, 882, 183, 919, -885, 564, 956, 993, -797, -116, 324, -255, 206, -614, 293, -605, 814, 349, 199, -609, -507, 852, 375, -34, -490, 440, 240})
                + " should be [32871962]");
        System.out.println("************************* Method 2 ********************************");
        System.out.println(maxDotProduct_rev1(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}) + " should be [18]");
        System.out.println(maxDotProduct_rev1(new int[]{3, -2}, new int[]{2, -6, 7}) + " should be [21]");
        System.out.println(maxDotProduct_rev1(new int[]{-1, -1}, new int[]{1, 1}) + " should be [-1]");
        System.out.println(maxDotProduct_rev1(
                new int[]{-896, 151, -900, -765, -232, 494, -903, 876, -66, 827, -692, -79, 550, -764, 168, 403, 11, 14, -887, 507, 755, 656, 678, -588, -93, -649, -809, 728, -567, 729, 370, -518, 162, 886, 255, 121, -222, 161, 403, 467, 184, 948, 955, 342, 198, -282, 833, 693, 515, -206, 989, 687, 464, -391, 553, -902, -46, 904, 599, -87, 312, 528, -273, 993, 960, -460, 842, -929, -939, -185, -145, -380, -216, 812, 579, 608, 255, -22, -736, -37, -959, 535, 593, -165, -210, 699, 523, 711, 232, -258, 319, -298, -166, 376, 872, -622, 96, 6, 827, -245, -893, -454, 219, -202, -592, 48, 861, -691, -731, -639, 869, -524, -382, 443, 787, 30, -279, -597, 794, -926, 983, -772, -901, 643, 523, -713, -393, -170, -5, 560, 720, -992, -635, -411, -376, 92, 439, -360, -721, 886, 558, 712, -719, 649, 91, 503, -570, -690, -792, -217, 7, 137, 880, -284},
                new int[]{645, -556, -989, 479, 877, -619, -862, 538, -129, 192, -389, 124, 532, -976, -199, 20, -413, 644, 920, -809, 37, 710, 339, 57, -485, -160, 497, -24, -803, -902, 37, -503, -37, -22, -693, -315, -117, -348, -893, -16, 781, 144, 287, 340, -789, 78, 468, 507, -79, -588, -523, -278, 973, -858, 889, 519, 575, 652, -497, -260, -963, 802, 816, -856, -229, 7, 710, -745, -87, -593, 472, -327, -347, -310, -974, 19, -285, 827, -882, 212, 265, 882, 183, 919, -885, 564, 956, 993, -797, -116, 324, -255, 206, -614, 293, -605, 814, 349, 199, -609, -507, 852, 375, -34, -490, 440, 240})
                + " should be [32871962]");
    }

    public static int maxDotProduct_rev1(int[] nums1, int[] nums2) {
        int rows = nums1.length, cols = nums2.length;
        int[][] dp = new int[2][cols + 1];
//        Fill the first row and first col with -Inf+1000. Adding 1000 so that when added a value it doesnot become possitive.
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        Arrays.fill(dp[1], Integer.MIN_VALUE);
        int max = Integer.MIN_VALUE;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
//                Take the product of the two numbers
                int curProduct = (nums2[col - 1] * nums1[row - 1]);
                if (dp[0][col - 1] != Integer.MIN_VALUE) {
                    curProduct = Math.max(curProduct, curProduct + dp[0][col - 1]);
                }
                dp[1][col] = Math.max(curProduct, Math.max(dp[0][col], dp[1][col - 1]));
                max = Math.max(max, dp[1][col]);
            }
            System.arraycopy(dp[1], 0, dp[0], 0, cols);
            Arrays.fill(dp[1], Integer.MIN_VALUE);
        }
        return max;
    }

    public static int maxDotProduct(int[] A, int[] B) {
        int rows = A.length, cols = B.length;
        int[][] dp = new int[rows + 1][cols + 1];
//        Fill the first row and first col with -Inf
        Arrays.fill(dp[0], Integer.MIN_VALUE);
        for (int i = 1; i <= rows; i++) {
            dp[i][0] = Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= cols; col++) {
//                Take the product of the two numbers
                int curProduct = (B[col - 1] * A[row - 1]);
//                Check if the current product increases by adding the left top number.
                if (dp[row - 1][col - 1] != Integer.MIN_VALUE) {
                    curProduct = Math.max(dp[row - 1][col - 1] + curProduct, curProduct);
                }
//                Take the maximum of top left and the currentProduct
                dp[row][col] = Math.max(curProduct, Math.max(dp[row - 1][col], dp[row][col - 1]));
                max = Math.max(max, dp[row][col]);
            }
        }
        return max;
    }
}
