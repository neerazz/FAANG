package narraytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/explore/learn/card/n-ary-tree/131/recursion/919/
Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
For example, given a 3-ary tree:
We should return its max depth, which is 3.
Note:
The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
 */
public class MaximumDepthOfNaryTree {
    public static void main(String[] args) {
        Node node = new Node();
        Node node3 = new Node(), node2 = new Node(), node4 = new Node(), node5 = new Node(), node6 = new Node();
        node.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node6.val = 6;
        node3.children = Arrays.asList(node5, node6);
        node.children = Arrays.asList(node3, node2, node4);
        System.out.println("Answer is:" + maxDepth_Iterative(node));
        System.out.println("Answer is:" + maxDepth_Recursive(node));
    }

    public static int maxDepth_Recursive(Node root) {
        if (root == null)
            return 0;
        root.val = 0;
        for (Node n : root.children)
            root.val = Math.max(maxDepth_Recursive(n), root.val);
        return root.val + 1;
    }

    public static int maxDepth_Iterative(Node root) {
        int height = 0;
        if (root == null) return height;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.children != null) {
                    queue.addAll(poll.children);
                }
            }
        }
        return height;
    }
}
