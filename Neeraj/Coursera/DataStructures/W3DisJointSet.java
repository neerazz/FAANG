import java.util.HashMap;
import java.util.Map;

/*
Create a DisJoint set.
Solution: https://www.youtube.com/watch?v=ID00PMy0-vE
 */
public class W3DisJointSet {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        DisJointSet disJointSet = new DisJointSet();
        for (int i = 0; i < numbers.length; i++) {
            disJointSet.makeSet(numbers[i]);
        }
        disJointSet.union(2, 10);
        disJointSet.union(7, 5);
        disJointSet.union(6, 1);
        disJointSet.union(3, 4);
        disJointSet.union(5, 11);
        disJointSet.union(7, 8);
        disJointSet.union(7, 3);
        disJointSet.union(12, 2);
        disJointSet.union(9, 6);
        disJointSet.map.values().forEach(n -> System.out.println(n + "\t:" + disJointSet.findSet(n).data));
    }

    static class DisJointSet {

        Map<Integer, Node> map = new HashMap<>();

        void makeSet(int data) {
            Node node = new Node(data, 0, null);
            node.parent = node;
            map.put(data, node);
        }

        Node findSet(Node node) {
            Node parent = node.parent;
            return parent == node ? parent : findSet(parent);
        }

        void union(int data1, int data2) {
            Node node1 = map.get(data1);
            Node node2 = map.get(data2);

            Node parent1 = findSet(node1);
            Node parent2 = findSet(node2);

            if (parent1.data == parent2.data) {
                return;
            }

//            Performing Union by Rank
            int maxRank = Math.max(parent1.rank, parent2.rank);
            if (parent1.rank == parent2.rank) maxRank += 1;
            if (parent1.rank >= parent2.rank) {
                parent1.rank = maxRank;
//                Doing Path Compression.
                parent2.parent = parent1;
            } else {
                parent1.parent = parent2;
            }
        }

        class Node {
            int data;
            int rank;
            Node parent;

            public Node(int data, int rank, Node parent) {
                this.data = data;
                this.rank = rank;
                if (parent != null) {
                    this.parent = parent;
                } else parent = this;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "data=" + data +
                        ", rank=" + rank +
                        ", parent data=" + parent.data +
                        "}";
            }
        }
    }
}
