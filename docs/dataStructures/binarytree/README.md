# Binary Trees

A binary tree is a tree data structure in which each node has at most two children, which are referred to as the *left child* and the *right child*.

## Types of Binary Trees

*   **Full Binary Tree:** Every node has either 0 or 2 children.
*   **Complete Binary Tree:** All levels are completely filled except possibly the last, and all nodes in the last level are as far left as possible.
*   **Perfect Binary Tree:** All interior nodes have two children and all leaves are at the same level.
*   **Balanced Binary Tree:** The height of the two subtrees of any node never differs by more than one.
*   **Binary Search Tree (BST):** For each node, all values in its left subtree are less than its own value, and all values in its right subtree are greater.

## Complexity Analysis (for a balanced Binary Search Tree)

| Operation | Time Complexity | Space Complexity (Recursive) |
| :--- | :--- | :--- |
| **Access** | O(log n) | O(log n) |
| **Search** | O(log n) | O(log n) |
| **Insertion** | O(log n) | O(log n) |
| **Deletion** | O(log n) | O(log n) |

*For unbalanced trees, the worst-case time complexity is O(n).*

## Problem Identification

Binary trees are ideal for:
*   Hierarchical data, like file systems or organizational structures.
*   Efficient searching, insertion, and deletion (especially BSTs).
*   Problems that can be solved by recursively dividing the data into two smaller pieces.

## Common Patterns and Templates

### Template 1: Recursive Traversals (DFS)

Recursive traversals are the most common and intuitive way to work with trees.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, result);
        result.add(root.val); // Process node
        inorderTraversal(root.right, result);
    }
}
```

**Example Problem:** [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
*(Solution file `InorderTraversal.java` is in this directory)*

### Template 2: Level Order Traversal (BFS)

This pattern uses a queue to visit nodes level by level. It's useful for finding the shortest path or exploring the tree in a breadth-first manner.

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
        }

        return result;
    }
}
```

**Example Problem:** [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
*(Solution file `LevelOrderTraversal.java` is in this directory)*
