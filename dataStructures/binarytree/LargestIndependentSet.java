/*
Given a binary tree of size N, find the size of Largest Independent Set.
A subset of all tree nodes is an independent set if there is no edge between any two nodes of the subset.
Example:
INPUT: 10 20 30 40 50 N 60 N N 70 80
OUTPUT: 5
        LIS : [10,40,60,70,80]
*/

/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}


class LargestIndependentSet {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Node root = buildTree(s);

        Solution ob = new Solution();
        System.out.println(ob.LISS(root));
    }

    static class Solution {
        public int LISS(Node node) {
            if (node == null) {
                return 0;
            }
            int se = LISS(node.left) + LISS(node.right);

            int si = 1;
            if (node.left != null) {
                si += LISS(node.left.left) + LISS(node.left.right);
            }
            if (node.right != null) {
                si += LISS(node.right.left) + LISS(node.right.right);
            }
            return Math.max(se, si);
        }
    }
}


