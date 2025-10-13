# Arrays

An array is a data structure that stores a collection of elements of the same type in contiguous memory locations. Each element is identified by an index or a key.

## Complexity Analysis

| Operation | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| Access | O(1) | O(1) |
| Search | O(n) | O(1) |
| Insertion | O(n) | O(n) (if resizing) |
| Deletion | O(n) | O(1) |

## Problem Identification

Look for problems that involve:
* Storing and accessing a sequence of elements.
* Requiring frequent access to elements by their index.
* Fixed-size collections (or collections that don't change size frequently).

## Common Patterns and Templates

### Template 1: Two Pointers

This template is useful for problems where you need to iterate through a **sorted** array from both ends.

```java
class Solution {
    public int[] twoPointerTemplate(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == target) {
                return new int[]{left + 1, right + 1}; // Example for Two Sum II
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // No solution found
    }
}
```

**Example Problem:** [Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
*(Solution file `TwoSumII.java` is in this directory)*

### Template 2: Sliding Window

This template is useful for problems that involve finding a contiguous subarray that satisfies a certain condition.

```java
class Solution {
    public int slidingWindowTemplate(int[] arr, int s) {
        int windowStart = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= s) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
```

**Example Problem:** [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
*(Solution file `MinimumSizeSubarraySum.java` is in this directory)*
