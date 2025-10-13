# DFS (Depth-First Search) and BFS (Breadth-First Search)

DFS and BFS are two fundamental graph and tree traversal algorithms.

## DFS (Depth-First Search)

DFS explores as far as possible along each branch before backtracking. It can be implemented using a **stack** (either explicitly or implicitly with recursion, which uses the call stack).

### When to use DFS:
*   Finding a path between two nodes.
*   Detecting cycles in a graph.
*   Topological sorting.
*   Solving problems involving paths or connectivity (e.g., mazes).

### Template: DFS (Recursive)

This is the most common way to implement DFS for graph/grid problems.

```java
class Solution {
    public void dfs(int r, int c, boolean[][] visited, char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (r < 0 || r >= ROWS || c < 0 || c >= COLS || visited[r][c] || grid[r][c] == '0') {
            return;
        }

        visited[r][c] = true;
        // Process the node...

        // Explore neighbors
        dfs(r + 1, c, visited, grid);
        dfs(r - 1, c, visited, grid);
        dfs(r, c + 1, visited, grid);
        dfs(r, c - 1, visited, grid);
    }
}
```

---

## BFS (Breadth-First Search)

BFS explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level. It is implemented using a **queue**.

### When to use BFS:
*   Finding the shortest path between two nodes in an **unweighted** graph.
*   Level-order traversal of a tree.
*   Web crawling.
*   Finding all reachable nodes from a starting node.

### Template: BFS

```java
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public void bfs(int startR, int startC, char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        grid[startR][startC] = '0'; // Mark as visited

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            // Process node...

            // Explore neighbors
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR >= 0 && newR < ROWS && newC >= 0 && newC < COLS && grid[newR][newC] == '1') {
                    queue.offer(new int[]{newR, newC});
                    grid[newR][newC] = '0'; // Mark as visited
                }
            }
        }
    }
}
```

**Example Problem for both:** [Number of Islands](https://leetcode.com/problems/number-of-islands/)
*(A Java solution file for this, `NumberOfIslands.java`, is already in the `dataStructures/queue` directory. We can add a DFS version here for completeness.)*
