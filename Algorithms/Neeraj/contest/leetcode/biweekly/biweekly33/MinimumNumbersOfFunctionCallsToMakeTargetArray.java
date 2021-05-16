package biweekly.biweekly33;

/**
 * Created on:  Aug 22, 2020
 * Questions: https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
 */
public class MinimumNumbersOfFunctionCallsToMakeTargetArray {
    public static void main(String[] args) {

    }

    public static int minOperations(int[] nums) {
//        If the number is odd, then increase the count.
//        if the number is even then divide by two:
//          If there are already divides that can form that number, then keep moving
//          Else, increase the maxdivide count and increase the counter.
        int count = 0, maxDivideCount = -1;
        for (int num : nums) {
            int curDivide = 0;
            while (num > 0) {
                if (num % 2 == 0) {
                    num >>= 1;
                    curDivide++;
                    if (curDivide > maxDivideCount) {
                        maxDivideCount = curDivide;
                        count++;
                    }
                } else {
                    count++;
                    num--;
                }
            }
        }
        return count;
    }
}
