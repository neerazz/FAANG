package weekly.weekly196;

/**
 * Created on:  Jul 04, 2020
 * Questions: https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits
 */
public class MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits {
    public static void main(String[] args) {
        System.out.println(minInteger("4321", 4) + " should be [1342]");
        System.out.println(minInteger("100", 1) + " should be [010]");
        System.out.println(minInteger("36789", 1000) + " should be [36789]");
        System.out.println(minInteger("22", 22) + " should be [22]");
        System.out.println(minInteger("9438957234785635408", 23) + " should be [0345989723478563548]");
        System.out.println(minInteger("294984148179", 11) + " should be [124498948179]");
    }

    public static String minInteger(String num, int k) {
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length && k > 0; i++) {
//            First value is lowest and next is its index.
            int[] lowest = getLowest(chars, i, k);
            k -= lowest[1] - i;
//            Move all the higher elements to the right.
            if (lowest[1] - i >= 0) System.arraycopy(chars, i, chars, i + 1, lowest[1] - i);
            chars[i] = (char) (lowest[0]);
        }
        return String.valueOf(chars);
    }

    private static int[] getLowest(char[] nums, int start, int k) {
        int lowest = nums[start], idx = start;
        for (int i = start + 1; i < nums.length && i <= start + k; i++) {
            if (nums[i] < lowest) {
                lowest = nums[i];
                idx = i;
            }
        }
        return new int[]{lowest, idx};
    }
}