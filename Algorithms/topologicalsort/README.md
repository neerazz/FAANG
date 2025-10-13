# Topological Sort

Topological Sort is a linear ordering of vertices in a **Directed Acyclic Graph (DAG)**. For every directed edge from vertex `u` to vertex `v`, vertex `u` comes before vertex `v` in the ordering.

Topological sorting is not possible if the graph has a cycle.

## Key Concepts

*   **In-degree:** The in-degree of a vertex is the number of incoming edges.
*   **Out-degree:** The out-degree of a vertex is the number of outgoing edges.

## Kahn's Algorithm (BFS-based)

The most common algorithm for topological sorting is Kahn's algorithm, which uses a BFS-like approach.

1.  **Compute In-degrees:** Calculate the in-degree for every vertex in the graph.
2.  **Initialize Queue:** Add all vertices with an in-degree of `0` to a queue. These are the starting points with no prerequisites.
3.  **Process Queue:**
    *   Dequeue a vertex. Add it to the sorted list.
    *   For each of its neighbors, decrement their in-degree by 1 (since we have "completed" the prerequisite).
    *   If a neighbor's in-degree becomes `0`, enqueue it.
4.  **Check for Cycle:** If the number of vertices in the sorted list is not equal to the total number of vertices in the graph, there must be a cycle.

## Problem Identification

Look for problems that involve:
*   Dependencies or prerequisites (e.g., course schedules, build systems, task scheduling).
*   An ordering of items where some items must come before others.
*   The problem statement explicitly mentions a **Directed Acyclic Graph (DAG)**.

## Template: Kahn's Algorithm

```java
import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build the graph and the in-degree array
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];
            graph.computeIfAbsent(prerequisite, k -> new ArrayList<>()).add(course);
            inDegree[course]++;
        }

        // Step 2: Initialize the queue with courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int coursesTaken = 0;
        // Step 3: Process the queue
        while (!queue.isEmpty()) {
            int course = queue.poll();
            coursesTaken++;

            if (graph.containsKey(course)) {
                for (int nextCourse : graph.get(course)) {
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        // Step 4: Check for cycle
        return coursesTaken == numCourses;
    }
}
```

**Example Problem:** [Course Schedule](https://leetcode.com/problems/course-schedule/)
*(Solution file `CourseSchedule.java` is in this directory)*
