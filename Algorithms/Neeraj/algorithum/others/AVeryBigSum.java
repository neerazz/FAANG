/*
https://www.hackerrank.com/challenges/a-very-big-sum/problem?h_r=next-challenge&h_v=zen
 */
public class AVeryBigSum {
    public static void main(String[] args) {
        System.out.println(aVeryBigSum(new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005}));
    }

    static long aVeryBigSum(long[] ar) {
        long output = 0;
        for (int i = 0; i < ar.length; i++) {
            output += ar[i];
        }
        return output;
    }
}
