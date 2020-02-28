import java.util.HashMap;

/*
https://leetcode.com/explore/learn/card/hash-table/187/conclusion-hash-table/1134
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
Example:
Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
Output:
2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumII {
    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}) + " should be [2].");
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = A[i] + B[j];
                integerHashMap.put(sum, integerHashMap.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = (C[i] + D[j]) * -1;
                count += integerHashMap.getOrDefault(sum, 0);
            }
        }
        return count;
    }
}
