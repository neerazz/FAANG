/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // This could be the first bad version, or there might be one before it.
                // So, we check the left side.
                right = mid;
            } else {
                // This version is good, so the first bad version must be after it.
                left = mid + 1;
            }
        }

        // When the loop terminates, left and right will be pointing to the same element,
        // which is the first bad version.
        return left;
    }
}

// Note: The VersionControl class and isBadVersion API are provided by LeetCode.
// To run this locally, you would need a mock implementation.
/*
class VersionControl {
    boolean isBadVersion(int version) {
        // Mock implementation
        return version >= 4; // Assuming 4 is the first bad version
    }
}
*/
