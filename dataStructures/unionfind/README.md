# Union-Find (Disjoint Set Union)

The Union-Find data structure, also known as Disjoint Set Union (DSU), is used to keep track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. It provides two main operations:

1.  **`find(i)`**: Determines which subset an element `i` is in. It returns an identifier (or "representative") for that subset. A common implementation has this be the root of the tree that element `i` is in.
2.  **`union(i, j)`**: Merges the two subsets containing elements `i` and `j` into a single subset.

## Optimizations

To make the operations nearly constant time on average, two main optimizations are used:

*   **Path Compression**: During a `find` operation, we make every node on the path from the element to the root point directly to the root. This flattens the tree structure.
*   **Union by Rank/Size**: During a `union` operation, we attach the smaller tree to the root of the larger tree. This helps to keep the trees from becoming too deep.

## Complexity Analysis

With both Path Compression and Union by Rank/Size optimizations:

| Operation | Time Complexity (Amortized) |
| :--- | :--- |
| **Find** | O(α(n)) |
| **Union** | O(α(n)) |

Where `α(n)` is the inverse Ackermann function, which is a very slowly growing function. For all practical purposes, it is considered to be a constant (not more than 5 for any imaginable input size `n`).

## Problem Identification

Union-Find is very effective for:
*   Graph problems involving connectivity, such as finding the number of connected components.
*   Detecting cycles in an **undirected** graph.
*   Problems that involve partitioning a set into disjoint subsets.

## Template: Union-Find Implementation

```java
class UnionFind {
    private int[] root;
    // Use a rank array to keep track of the depth of each tree
    private int[] rank;
    private int count; // Number of disjoint sets

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1; // Each node is its own tree of rank 1
        }
    }

    // Find the root of the set containing x, with path compression
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    // Union the sets containing x and y, with union by rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
```

**Example Problem:** [Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)
*(Solution file `NumberOfConnectedComponents.java` is in this directory)*
