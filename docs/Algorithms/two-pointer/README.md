# Two Pointers

The two-pointers technique is a common pattern used to solve problems involving sorted arrays or linked lists. It involves using two pointers to iterate through the data structure, often from opposite ends or at different speeds.

## When to Use Two Pointers

This pattern is useful for problems that require you to find a pair of elements that satisfy a certain condition, or to process an array in a way that depends on two different indices.

Common scenarios:
*   Finding a pair in a **sorted array** that sums to a target.
*   Reversing an array or string.
*   Problems involving palindromes.
*   Partitioning an array.

## Common Patterns and Templates

### Template 1: Pointers from Opposite Ends

This is used when the array is sorted. The pointers move towards each other.

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1}; // Should not happen based on problem constraints
    }
}
```

**Example Problem:** [Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
*(The solution file `TwoSumII.java` is already in the `dataStructures/arrays` directory)*

### Template 2: Fast and Slow Pointers

This is often used in linked lists to detect cycles or in arrays to remove duplicates. The pointers move in the same direction but at different speeds.

```java
// Template for Array (e.g., remove duplicates)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0; // 'slow' is the index for the next unique element
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1; // The length of the new array
    }
}
```

**Example Problems:**
*   [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) *(Solution in `dataStructures/LinkedList`)*
*   [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) *(Solution file `RemoveDuplicates.java` is in this directory)*
