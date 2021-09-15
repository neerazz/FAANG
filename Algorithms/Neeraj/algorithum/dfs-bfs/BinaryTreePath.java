import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Sep 14, 2021
 * Ref: https://leetcode.com/discuss/interview-experience/1461079/google-swe-l3l4-dublin-ireland-reject
 * <p>
 * Given a binary tree, find the path directions to go from node A to node B. For e.g. for the following binary tree path between 5 to 7 is ["up", "up", "right", "right", "left"] (Note: we can only use "up", "right", "left" directions)
 * <p>
 * https://assets.leetcode.com/users/images/93fbd879-69b8-4243-b5b9-b5e722e303b7_1631530503.2039866.png
 */
public class BinaryTreePath {
    static String[] dirs = {"up", "left", "right"};

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n6.left = n7;
        System.out.println(getPath(n1, n5, n7));
    }

    private static List<String> getPath(Node head, Node a, Node b) {
        Map<Node, Node> parents = new HashMap<>();
        buildParent(head, null, parents);
        List<Integer> result = new ArrayList<>();
        dfs(a, b, parents, new LinkedList<>(), new HashSet<>(), result);
        return buildDirections(result);
    }

    private static List<String> buildDirections(List<Integer> path) {
        return path.stream().map(idx -> dirs[idx]).collect(Collectors.toList());
    }

    static void dfs(Node a, Node b, Map<Node, Node> parents, LinkedList<Integer> soFar, Set<Node> visited, List<Integer> result) {
        if (a == null) return;
        if (a == b) {
            result.addAll(soFar);
        } else if (visited.add(a)) {
//            Do a recursive call to parent
            soFar.add(0);
            dfs(parents.get(a), b, parents, soFar, visited, result);
            soFar.removeLast();
//            Recursive call to left child
            soFar.add(1);
            dfs(a.left, b, parents, soFar, visited, result);
            soFar.removeLast();
//            Do a recursive call to right child
            soFar.add(2);
            dfs(a.right, b, parents, soFar, visited, result);
            soFar.removeLast();
        }
    }

    static void buildParent(Node head, Node parent, Map<Node, Node> parents) {
        if (head == null) return;
        parents.put(head, parent);
        buildParent(head.left, head, parents);
        buildParent(head.right, head, parents);
    }

    static class Path {
        Node node;
        List<Integer> dirs = new ArrayList<>();

        public Path(Node node) {
            this.node = node;
        }
    }

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
}
