package weekly.weekly249;

/**
 * Created on:  Jul 17, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-249/problems/concatenation-of-array/
 */
public class ConcatenationOfArray {
    public static void main(String[] args) {

    }

    public static int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] result = new int[2 * len];
        for (int i = 0; i < len; i++) {
            result[i] = result[len + i] = nums[i];
        }
        return result;
    }
}
