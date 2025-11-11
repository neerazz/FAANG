# Binary Search

Binary search is a highly efficient searching algorithm that works on **sorted** arrays. It repeatedly divides the search interval in half. If the value of the search key is less than the item in the middle of the interval, it narrows the interval to the lower half. Otherwise, it narrows it to the upper half.

## Complexity Analysis

| Operation | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **Search** | O(log n) | O(1) (iterative) / O(log n) (recursive) |

## Problem Identification

Binary search is applicable when:
*   The input data is **sorted** (or can be sorted).
*   You need to find a specific element, a range, or a value that satisfies a certain condition.
*   The problem has a **monotonic property**: if a condition is true for a value `x`, it's also true for all values greater than (or less than) `x`. This allows you to "search" for the boundary where the condition changes from false to true.

## Common Patterns and Templates

### Template 1: Basic Binary Search

This is the standard template for finding a specific target value in a sorted array.

```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }
}
```

**Example Problem:** [Binary Search](https://leetcode.com/problems/binary-search/)
*(Solution file `BinarySearch.java` is in this directory)*

### Template 2: Finding the Boundary

This template is useful for finding the first or last occurrence of an element, or for problems where you're searching for a "boundary" in the data (like the first `true` value in a boolean array `[F, F, T, T, T]`).

```java
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int boundary = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                boundary = mid;
                right = mid - 1; // Try to find an earlier bad version
            } else {
                left = mid + 1;
            }
        }
        return boundary;
    }
}
```

**Example Problem:** [First Bad Version](https://leetcode.com/problems/first-bad-version/)
*(Solution file `FirstBadVersion.java` is in this directory)*
