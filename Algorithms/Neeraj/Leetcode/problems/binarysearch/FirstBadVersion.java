package problems.binarysearch;

/*
https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:
Given n = 5, and version = 4 is the first bad version.
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
 */
public class FirstBadVersion {
    static int badVersion;

    public static void main(String[] args) {
        badVersion = 4;
        System.out.println("Answer is:" + firstBadVersion(5) + " should be " + badVersion);
        badVersion = 1;
        System.out.println("Answer is:" + firstBadVersion(1) + " should be " + badVersion);
        badVersion = 1;
        System.out.println("Answer is:" + firstBadVersion(2) + " should be " + badVersion);
        badVersion = 1702766719;
        System.out.println("Answer is:" + firstBadVersion(2126753390) + " should be " + badVersion);
    }

    public static int firstBadVersion(int n) {
        if (n == 1) return n;
        return firstBadVersionHelper(1, n);
    }

    private static int firstBadVersionHelper(int start, int end) {
        if (end - start == 1) {
            if (isBadVersion(start)) return start;
            return end;
        }
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            return firstBadVersionHelper(start, mid);
        } else {
            return firstBadVersionHelper(mid, end);
        }
    }

    private static boolean isBadVersion(int mid) {
        return mid >= badVersion;
    }
}
