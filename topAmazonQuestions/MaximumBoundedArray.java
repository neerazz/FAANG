import java.util.Arrays;

/**
 * Created on:  Jan 14, 2021
 * Questions: https://aonecode.com/aplusplus/interviewctrl/getInterview/8960009977
 */

public class MaximumBoundedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaximumBoundedArray(4, 10, 12)));
        System.out.println(Arrays.toString(getMaximumBoundedArray(6, 1, 3)));
    }

    private static int[] getMaximumBoundedArray(int n, int lower, int upper) {
        int totalNums = upper - lower + 1, peekIdx = 1;
        while (peekIdx < n - 1) {
            int requiredNums = n - peekIdx;
            if (peekIdx < totalNums && requiredNums <= totalNums) break;
            peekIdx++;
        }
        if (peekIdx == n - 1) return null;
        return buildArray(n, peekIdx, lower, upper);
    }

    private static int[] buildArray(int n, int peekIdx, int lower, int upper) {
        int[] array = new int[n];
        int i = peekIdx, curVal = upper;
        while (i < n) array[i++] = curVal--;
        i = peekIdx;
        curVal = upper;
        while (i >= 0) array[i--] = curVal--;
        return array;
    }
}
