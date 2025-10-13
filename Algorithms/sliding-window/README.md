# Sliding Window

The sliding window is a technique used to efficiently solve problems that involve a contiguous subarray or substring. A "window" of a certain size slides over the data, and we perform some computation on the elements within that window.

## When to Use Sliding Window

This pattern is useful for problems that ask for something related to a **contiguous subarray** of a given size, or the **longest/shortest subarray** that satisfies a certain condition.

Common problem types:
*   Finding the max/min sum of a subarray of size `k`.
*   Finding the longest substring with no more than `k` distinct characters.
*   Finding the smallest subarray whose sum is greater than or equal to a target value.

## Common Patterns and Templates

### Template 1: Fixed-Size Sliding Window

This template is used when the size of the window `k` is fixed.

```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;
        // Calculate sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        double maxSum = windowSum;

        // Slide the window from left to right
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k]; // Add the new element and remove the old one
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k;
    }
}
```

**Example Problem:** [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)
*(Solution file `MaximumAverageSubarrayI.java` is in this directory)*

### Template 2: Variable-Size Sliding Window

This template is used when the size of the window can grow or shrink based on a condition.

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];

            // Shrink the window from the left as long as the condition is met
            while (windowSum >= target) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
```

**Example Problem:** [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
*(The solution file `MinimumSizeSubarraySum.java` is already in the `dataStructures/arrays` directory)*
