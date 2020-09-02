/**
 * Created on:  Sep 01, 2020
 * Questions: https://leetcode.com/problems/largest-time-for-given-digits/
 */
public class LargestTimeForGivenDigits {
    static String result;

    public static void main(String[] args) {

    }

    public static String largestTimeFromDigits(int[] A) {
        result = "";
        boolean[] taken = new boolean[4];
        helper(A, 0, taken, "");
        return result;
    }

    private static void helper(int[] nums, int idx, boolean[] taken, String soFar) {
        if (idx == 4) {
            // System.out.println(soFar);
            if (soFar.compareTo(result) > 0) result = soFar;
        } else {
//             Loop through the list nums and pick a valid number;
            for (int i = 0; i < 4; i++) {
                if (!taken[i] && isValid(soFar, nums[i], idx)) {
                    taken[i] = true;
                    helper(nums, idx + 1, taken, idx == 1 ? soFar + nums[i] + ":" : soFar + nums[i]);
                    taken[i] = false;
                }
            }
        }
    }

    private static boolean isValid(String soFar, int num, int idx) {
        if (idx == 0) return num <= 2;
        if (idx == 1) {
            if (soFar.charAt(0) == '2') return num <= 3;
            else return num <= 9;
        }
        if (idx == 2) return num <= 5;
        return num <= 9;
    }
}
