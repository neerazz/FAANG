# Queues

A queue is a linear data structure that follows the First-In, First-Out (FIFO) principle. This means the first element added to the queue will be the first one to be removed.

## Operations

*   **enqueue (or add/offer):** Adds an element to the back of the queue.
*   **dequeue (or remove/poll):** Removes the element from the front of the queue.
*   **peek / front:** Returns the front element of the queue without removing it.
*   **isEmpty:** Checks if the queue is empty.

## Complexity Analysis

| Operation | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **Enqueue** | O(1) | O(1) |
| **Dequeue** | O(1) | O(1) |
| **Peek** | O(1) | O(1) |
| **Search** | O(n) | O(1) |

## Problem Identification

Queues are ideal for problems that involve:
*   Processing items in the order they were received.
*   Level-order traversal of a tree (Breadth-First Search).
*   Implementing a cache or a buffer.
*   Problems involving a waiting line or a sequential processing flow.

## Common Patterns and Templates

### Template 1: Breadth-First Search (BFS)

BFS is a common graph and tree traversal algorithm that uses a queue to explore nodes level by level.

```java
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public void bfsTemplate(char[][] grid) {
        // Example for a grid-based problem
        if (grid == null || grid.length == 0) {
            return;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Find the starting point (e.g., '1' for Number of Islands)
        // For this template, let's assume a starting point
        // queue.offer(new int[]{startRow, startCol});
        // visited.add(startRow + "," + startCol);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            // Process the current node...

            // Explore neighbors
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                String id = newR + "," + newC;

                if (newR >= 0 && newC >= 0 && newR < rows && newC < cols &&
                    !visited.contains(id) /* && other conditions */) {

                    queue.offer(new int[]{newR, newC});
                    visited.add(id);
                }
            }
        }
    }
}
```

**Example Problem:** [Number of Islands](https://leetcode.com/problems/number-of-islands/)
*(Solution file `NumberOfIslands.java` is in this directory)*
