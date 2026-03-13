# Heaps and Sorting

This section covers the heap data structure and various sorting algorithms.

## Heaps (Priority Queues)

A heap is a specialized tree-based data structure that satisfies the heap property. In Java, heaps are implemented by the `PriorityQueue` class.
*   By default, `PriorityQueue` is a **min-heap**: the head of the queue is the *smallest* element.
*   To create a **max-heap**, you must provide a custom `Comparator`.

### Complexity Analysis (Heap)

| Operation | Time Complexity |
| :--- | :--- |
| **Insert (offer)** | O(log n) |
| **Delete Min/Max (poll)**| O(log n) |
| **Peek Min/Max (peek)** | O(1) |

### Problem Identification (Heap)

Heaps are useful for:
*   Finding the min/max element in a collection efficiently.
*   Problems involving scheduling or task prioritization.
*   "Top K" problems (e.g., find the k-th largest/smallest element).

### Template: Top K Elements

This pattern uses a min-heap to keep track of the `k` largest elements seen so far.

```java
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Use a min-heap to store the k largest elements.
        // The smallest of these k elements will be at the top of the heap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element if the heap size exceeds k
            }
        }

        return minHeap.peek();
    }
}
```

**Example Problem:** [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
*(Solution file `KthLargestElement.java` is in this directory)*

---

## Sorting Algorithms

Sorting is the process of arranging items in a certain sequence.

| Algorithm | Time Complexity (Best) | Time Complexity (Average) | Time Complexity (Worst) | Space Complexity | Notes |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Bubble Sort** | O(n) | O(n^2) | O(n^2) | O(1) | Simple but inefficient. |
| **Selection Sort**| O(n^2) | O(n^2) | O(n^2) | O(1) | Inefficient, but makes minimal swaps. |
| **Insertion Sort**| O(n) | O(n^2) | O(n^2) | O(1) | Efficient for nearly sorted data. |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | Stable sort, good for external sorting. |
| **Quick Sort** | O(n log n) | O(n log n) | O(n^2) | O(log n) | Fast in practice, but worst case is O(n^2). Not stable. |
| **Heap Sort** | O(n log n) | O(n log n) | O(n log n) | O(1) | In-place, but not stable. |

*Java's `Arrays.sort()` uses a dual-pivot QuickSort for primitive types and MergeSort (or TimSort) for objects.*
