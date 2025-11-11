# Graphs

A graph is a non-linear data structure consisting of **nodes** (or vertices) and **edges** that connect these nodes. Graphs are used to model relationships between objects.

A graph can be **directed** (edges have a direction) or **undirected** (edges are bidirectional). It can also be **weighted** (edges have a cost) or **unweighted**.

## Common Representations

### 1. Adjacency List

An adjacency list is the most common way to represent a graph. For each vertex, we store a list of its adjacent vertices. In Java, this is often implemented as a `Map<Node, List<Node>>` or a similar structure.

*   **Pros:** Space-efficient for sparse graphs (where the number of edges is much less than the number of vertices squared). Easy to iterate over the neighbors of a vertex.
*   **Cons:** Checking for the existence of an edge between two vertices can be slower (O(k), where k is the number of neighbors).

### 2. Adjacency Matrix

An adjacency matrix is a 2D array where `matrix[i][j] = 1` (or some weight) if there is an edge from vertex `i` to vertex `j`, and `0` otherwise.

*   **Pros:** Fast to check for the existence of an edge (O(1)).
*   **Cons:** Uses a lot of space for sparse graphs (O(V^2), where V is the number of vertices).

## Common Algorithms

*   **Traversal:** [Depth-First Search (DFS)](../../Algorithms/dfs-bfs/README.md) and [Breadth-First Search (BFS)](../../Algorithms/dfs-bfs/README.md).
*   **Shortest Path:** Dijkstra's Algorithm, Bellman-Ford Algorithm.
*   **Minimum Spanning Tree:** Prim's Algorithm, Kruskal's Algorithm.
*   **Topological Sort:** For Directed Acyclic Graphs (DAGs).

## Template: Graph Traversal (BFS)

This template shows how to traverse a graph represented by its nodes (common in LeetCode problems) using BFS to avoid getting stuck in cycles.

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Use a map to store the mapping from original nodes to their clones.
        // This map also serves as the 'visited' set.
        Map<Node, Node> visited = new HashMap<>();

        // Use a queue for BFS traversal.
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        // Clone the starting node and put it in the map.
        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node originalNode = queue.poll();

            for (Node neighbor : originalNode.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and add it to the map and queue.
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                // Add the cloned neighbor to the list of neighbors of the cloned current node.
                visited.get(originalNode).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}
```

**Example Problem:** [Clone Graph](https://leetcode.com/problems/clone-graph/)
*(Solution file `CloneGraph.java` is in this directory)*
