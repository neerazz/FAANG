import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Map to store the mapping from original nodes to their clones.
        // This also acts as a 'visited' set.
        Map<Node, Node> visitedMap = new HashMap<>();

        // Queue for BFS traversal
        Queue<Node> queue = new LinkedList<>();

        // Start with the given node
        queue.offer(node);
        // Create a clone for the start node and add it to the map
        visitedMap.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            // Get the original node from the front of the queue
            Node originalNode = queue.poll();

            // Iterate through all its neighbors
            for (Node neighbor : originalNode.neighbors) {
                // If a neighbor has not been cloned yet
                if (!visitedMap.containsKey(neighbor)) {
                    // Create a clone for the neighbor
                    visitedMap.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    // Add the original neighbor to the queue to process its neighbors later
                    queue.offer(neighbor);
                }
                // Add the clone of the neighbor to the neighbors list of the clone of the current node
                visitedMap.get(originalNode).neighbors.add(visitedMap.get(neighbor));
            }
        }

        // Return the clone of the starting node
        return visitedMap.get(node);
    }
}
