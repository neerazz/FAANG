# Hash Tables (Hash Maps)

A hash table is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hash table uses a hash function to compute an index, also called a hash code, into an array of buckets or slots, from which the desired value can be found. In Java, `HashMap` and `HashSet` are the primary implementations.

## Key Concepts

*   **Hash Function:** A function that takes a key and computes an index into the array. A good hash function distributes keys uniformly across the buckets.
*   **Collision:** When two different keys hash to the same index.
*   **Collision Resolution:** In Java's `HashMap`, collisions are typically handled by **chaining**, where each bucket stores a linked list (or a balanced tree after a certain threshold) of key-value pairs that hash to that index.

## Complexity Analysis

| Operation | Average Case | Worst Case (with collisions) |
| :--- | :--- | :--- |
| **Search** | O(1) | O(n) |
| **Insertion** | O(1) | O(n) |
| **Deletion** | O(1) | O(n) |

## Problem Identification

Hash tables are extremely useful for problems that require:
*   Fast lookups, insertions, and deletions of key-value pairs.
*   Counting the frequency of elements.
*   Storing a cache of results (memoization).
*   Checking for the existence of an element in a collection.

## Common Patterns and Templates

### Template 1: Frequency Counting

This is one of the most common use cases for a hash table.

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public Map<Integer, Integer> frequencyCountTemplate(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int item : arr) {
            counts.put(item, counts.getOrDefault(item, 0) + 1);
        }
        return counts;
    }
}
```

**Example Problem:** [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
*(Solution file `TopKFrequentElements.java` is in this directory)*

### Template 2: Two Sum Problem

The Two Sum problem and its variations are classic examples of using a hash table for efficient lookups.

```java
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSumTemplate(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
```

**Example Problem:** [Two Sum](https://leetcode.com/problems/two-sum/)
*(Solution file `TwoSum.java` is in this directory)*
