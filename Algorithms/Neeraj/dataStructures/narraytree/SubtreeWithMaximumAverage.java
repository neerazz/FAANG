import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jan 12, 2021
 * Questions: https://leetcode.com/discuss/interview-question/349617
 */

public class SubtreeWithMaximumAverage {

    static double max;
    static Node result;

    public static void main(String[] args) {
        Node n20 = new Node(20);
        Node n12 = new Node(12);
        Node n18 = new Node(18);
        Node n11 = new Node(11);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n15 = new Node(15);
        Node n8 = new Node(8);
        n20.dep.add(n12);
        n20.dep.add(n18);
        n12.dep.add(n11);
        n12.dep.add(n2);
        n12.dep.add(n3);
        n18.dep.add(n15);
        n18.dep.add(n8);
        System.out.println(getMaxAverageSubTree(n20));
    }

    private static Node getMaxAverageSubTree(Node root) {
        max = 0;
        result = null;
        helper(root);
        System.out.println("max = " + max);
        return result;
    }

    private static double[] helper(Node root) {
        if (root == null) return new double[2];
//        0: sum, 1: count
        double sum = root.val, count = 1;
        for (Node dep : root.dep) {
            double[] next = helper(dep);
            sum += next[0];
            count += next[1];
        }
        double cur = sum / count;
        if (count > 1 && cur > max) {
//            Check if this node is the max sub array node, only if there is more than one children.
            max = cur;
            result = root;
        }
        return new double[]{sum, count};
    }

    static class Node {
        int val;
        List<Node> dep;

        public Node(int val) {
            this.val = val;
            dep = new ArrayList<>();
        }

        public Node(int val, List<Node> dep) {
            this.val = val;
            this.dep = dep;
        }

        @Override
        public String toString() {
            return "val=" + val +
                    ", dep=" + dep;
        }
    }
}
