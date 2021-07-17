import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeNaryTreeToBinaryTree {
    public static void main(String[] args) {
        Node root = new Node();
        Node node3 = new Node(), node2 = new Node(), node4 = new Node(), node5 = new Node(), node6 = new Node();
        root.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node6.val = 6;
        node3.children = Arrays.asList(node5, node6);
        root.children = Arrays.asList(node3, node2, node4);
        Codec codec = new Codec();
//        codec.decodeHelper(codec.encode(root));
    }

    static class Node {
        Integer val;
        List<Node> children;

        public Node(Integer val, List<Node> children) {
            this.val = val;
            this.children = children;
        }

        public Node() {
        }
    }

    static class Codec {

        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null)
                return null;
            TreeNode treeNode = new TreeNode(root.val);
            if (root.children == null || root.children.isEmpty())
                return treeNode;
            TreeNode node = encode(root.children.get(0));
            treeNode.right = node;
            for (int i = 1; i < root.children.size(); i++) {
                node.left = encode(root.children.get(i));
                node = node.left;
            }
            return treeNode;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decodeHelper(TreeNode root) {
            return root == null ? null : decodeHelper(root, new ArrayList<Node>());
        }

        private Node decodeHelper(TreeNode root, List<Node> children) {
            Node node = new Node(root.val, new ArrayList<Node>());
            children.add(node);
            if (root.right != null)
                decodeHelper(root.right, node.children);
            if (root.left != null)
                decodeHelper(root.left, children);
            return node;
        }
    }
}