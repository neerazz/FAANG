/**
 * Created on:  Dec 10, 2020
 * Questions: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/570/week-2-december-8th-december-14th/3561/
 */

public class ValidMountainArray {

    public static void main(String[] args) {

    }

    public static boolean validMountainArray(int[] arr) {
        int maxVal = Integer.MIN_VALUE, maxIdx = 0, len = arr.length;
        if (len < 3) return false;
        for (int i = 0; i < len; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
                maxIdx = i;
            }
        }
        int left = maxIdx - 1, right = maxIdx + 1;
        if (left < 0 || right >= len) return false;
        int leftVal = maxVal, rightVal = maxVal;
        while (left >= 0) {
            int cur = arr[left--];
            if (cur >= leftVal) return false;
            leftVal = cur;
        }
        while (right < len) {
            int cur = arr[right++];
            if (cur >= rightVal) return false;
            rightVal = cur;
        }
        return true;
    }
}
