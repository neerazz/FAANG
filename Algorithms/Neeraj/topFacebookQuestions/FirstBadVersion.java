/**
 * Created on:  Jul 22, 2020
 * Questions: https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion {
    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n) {
        int start = 0, end = n;
        while (start < end) {
            int mid = (start + end) >>> 1;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean isBadVersion(int mid) {
        return false;
    }
}
