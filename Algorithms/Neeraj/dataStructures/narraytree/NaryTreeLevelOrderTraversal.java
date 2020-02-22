import java.util.*;
import java.util.stream.Collectors;

/*
https://leetcode.com/explore/learn/card/n-ary-tree/130/traversal/915/
Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example, given a 3-ary tree:
We should return its level order traversal:
[    [1],
     [3,2,4],
     [5,6]  ]
Note:
The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
 */
public class NaryTreeLevelOrderTraversal {
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
        System.out.println("Answer is:" + levelOrder(node));
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            output.add(queue.stream().map(node -> node.val).collect(Collectors.toList()));
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.children != null) {
                    queue.addAll(poll.children);
                }
            }
        }
        return output;
    }
}
