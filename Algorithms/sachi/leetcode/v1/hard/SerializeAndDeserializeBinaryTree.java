package leetcode.v1.hard;

import util.TreeNode;
import util.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode randomTree = Util.generateRandomTree(4);
        SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
        //Serialize
        String serializedTree = serializeAndDeserializeBinaryTree.serialize(randomTree);
        TreeNode deSerializedTree = serializeAndDeserializeBinaryTree.deserialize(serializedTree);
        //Print solutions
        System.out.println(serializedTree);
        Util.print(deSerializedTree);
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }
        String leftString = serialize(root.left);
        String rightString = serialize(root.right);
        return root.val + "," + leftString + rightString;
    }

    public TreeNode deserialize(String data) {
        String[] input = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(input));
        return deserializeHelper(q);
    }

    public TreeNode deserializeHelper(Queue<String> q) {
        String str = q.poll();
        if ("X".equals(str)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = deserializeHelper(q);
        node.right = deserializeHelper(q);
        return node;
    }

}
