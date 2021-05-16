package weekly.weekly202;

/**
 * Created on:  Aug 15, 2020
 * Questions: https://leetcode.com/problems/minimum-operations-to-make-array-equal/
 */
public class MinimumOperationsToMakeArrayEqual {
    public static void main(String[] args) {
        System.out.println(minOperations(3) + " = 2");
        System.out.println(minOperations(6) + " = 9");
    }

    public static int minOperations(int n) {
        int start = 0, end = n - 1, op = 0;
        while (start < end) {
            op += end-- - start++;
        }
        return op;
    }
}
