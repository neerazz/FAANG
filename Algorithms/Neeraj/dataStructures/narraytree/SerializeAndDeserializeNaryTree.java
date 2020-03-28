import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/explore/learn/card/n-ary-tree/132/conclusion/924/
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
For example, you may serialize the following 3-ary tree

as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note:
N is in the range of [1, 1000]
Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeNaryTree {
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
//        Your Codec object will be instantiated and called as such:
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        System.out.println(codec.deserialize(codec.serialize(root)));
        Codec codec1 = new Codec();
        Node node44 = new Node(44, null);
        System.out.println(codec1.serialize(node44));
        System.out.println(codec1.deserialize(codec1.serialize(node44)));
    }

    static class Codec {

        int deserializeIndex = 0;

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            String s = serializeHelper(root);
            return "[" + s + "]";
        }

        private String serializeHelper(Node root) {
            if (root == null) return "";
            if (root.children == null || root.children.isEmpty()) return String.valueOf(root.val);
            StringBuilder sb = new StringBuilder();
            sb.append(root.val).append(",");
            sb.append('[');
            root.children.forEach(node -> sb.append(serializeHelper(node)).append(","));
            sb.append(']');
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data.length() <= 2) return null;
            return deserializeHelper(data.substring(1, data.length() - 1)).get(0);
        }

        private List<Node> deserializeHelper(String data) {
            if (data.isEmpty()) return null;
            Stack<Node> nodes = new Stack<>();
            while (deserializeIndex < data.length()) {
                char current = data.charAt(deserializeIndex);
                Node node = new Node();
                node.children = new ArrayList<>();
                if (current == ']') {
                    deserializeIndex++;
                    break;
                } else if (current == '[') {
                    deserializeIndex++;
                    nodes.peek().children.addAll(deserializeHelper(data));
                } else if (current == ',') {
                    deserializeIndex++;
                } else {
                    int comma = data.substring(deserializeIndex).indexOf(',');
                    String value = null;
                    if (comma != -1) value = data.substring(deserializeIndex, deserializeIndex + comma);
                    else value = data.substring(deserializeIndex);
                    deserializeIndex += value.length();
                    node.val = Integer.parseInt(value);
                    nodes.add(node);
                }
            }
            return nodes;
        }
    }
    static class Node {
        Integer val;
        List<Node> children;

        public Node() {
        }

        public Node(int value) {
            this.val = value;
        }

        public Node(Integer val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
