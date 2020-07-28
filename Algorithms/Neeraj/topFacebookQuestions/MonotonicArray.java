/**
 * Created on:  Jul 27, 2020
 * Questions: https://leetcode.com/problems/monotonic-array/
 */
public class MonotonicArray {
    public static void main(String[] args) {

    }

    public static boolean isMonotonic(int[] A) {
        boolean increasing = true, decreasing = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                if (increasing && decreasing) {
                    decreasing = false;
                } else if (decreasing) {
                    return false;
                }
            } else if (A[i - 1] > A[i]) {
                if (increasing && decreasing) {
                    increasing = false;
                } else if (increasing) {
                    return false;
                }
            }
        }
        return true;
    }
}
