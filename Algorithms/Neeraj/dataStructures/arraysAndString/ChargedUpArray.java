/*
    Created on:  May 07, 2020
 */

/**
 * Questions: https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/charged-up-array-f35a5e23/
 */
public class ChargedUpArray {
    public static void main(String[] args) {
        FastReader fr = new FastReader("C:\\Users\\bnira\\Downloads\\70ceffee1fb311e9.txt.clean.txt");
        int tests = fr.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = fr.nextInt();
            long[] nums = new long[n];
            for (int j = 0; j < n; j++) {
                nums[j] = fr.nextLong();
            }
            System.out.println(solve(nums, n));
        }
    }

    static int solve(long[] A, int N) {
//        long pos = ((N - 1) * (N) / 2) + 1;
        long pos = (long) Math.pow(2, N-1);
        long op = 0;
        for (long val : A) {
            if (val >= pos) {
                op = (op + (val % 1_000_000_007)) % 1_000_000_007;
            }
        }
        return (int) op;
    }
}
