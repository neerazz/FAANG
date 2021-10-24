/**
 * Created on:  Aug 10, 2021
 * Ref : https://leetcode.com/problems/student-attendance-record-ii/
 */
public class StudentAttendanceRecordII {
    static int mod = 1_000_000_007;

    public static void main(String[] args) {

    }

    public static int checkRecord(int n) {
        Long[][][] dp = new Long[n + 1][2][3];
        long result = helper(n, 0, 0, dp);
        return (int) result;
    }

    private static long helper(int n, int totalA, int continuesL, Long[][][] dp) {
        if (n == 0) return 1;
        if (dp[n][totalA][continuesL] != null) return dp[n][totalA][continuesL];
        long cur = 0;
        if (totalA == 0) {
//            If this number can be marked as absent, then mark it as absent.
            cur += helper(n - 1, totalA + 1, 0, dp);
            cur %= mod;
        }
        if (continuesL < 2) {
//            If you have less than two continues absents, then there is a chance that it can be absent.
            cur += helper(n - 1, totalA, continuesL + 1, dp);
            cur %= mod;
        }
//        YOu can place a present at every possible place.
        cur += helper(n - 1, totalA, 0, dp);
        cur %= mod;
        return dp[n][totalA][continuesL] = cur;
    }
}
