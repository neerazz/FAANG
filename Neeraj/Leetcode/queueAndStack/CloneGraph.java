package queueAndStack;

import java.util.*;

/*
https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1392/
Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
Example:
Input:
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
Explanation:
Node 1's value is 1, and it has two neighbors: Node 2 and 4.
Node 2's value is 2, and it has two neighbors: Node 1 and 3.
Node 3's value is 3, and it has two neighbors: Node 2 and 4.
Node 4's value is 4, and it has two neighbors: Node 1 and 3.
Note:
The number of nodes will be between 1 and 100.
The undirected graph is a simple graph, which means no repeated edges and no self-loops in the graph.
Since the graph is undirected, if node p has node q as neighbor, then node q must have node p as neighbor too.
You must return the copy of the given node as a reference to the cloned graph.
 */
public class CloneGraph {
    static Stack<Node> createdNodes = new Stack<>();

    public static void main(String[] args) {
        Node one = new Node();
        Node two = new Node();
        Node three = new Node();
        Node four = new Node();
        one.val = 1;
        two.val = 2;
        three.val = 3;
        four.val = 4;
        one.neighbors = new ArrayList<>(Arrays.asList(two, four));
        two.neighbors = new ArrayList<>(Arrays.asList(one, three));
        three.neighbors = new ArrayList<>(Arrays.asList(two, four));
        four.neighbors = new ArrayList<>(Arrays.asList(one, three));
        System.out.println(cloneGraph(one));
    }

    public static Node cloneGraph(Node node) {
        return clone(node, new HashMap());
    }

    static Node clone(Node node, Map<Node, Node> map) {
        Node copy = map.get(node);
        if (copy != null) return copy;
        copy = new Node(node.val, new ArrayList());
        map.put(node, copy);
        for (Node neib : node.neighbors) {
            copy.neighbors.add(clone(neib, map));
        }
        return copy;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}