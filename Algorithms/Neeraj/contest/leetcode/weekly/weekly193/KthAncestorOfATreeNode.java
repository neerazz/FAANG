package weekly.weekly193;

import java.util.*;

/**
 * Created on:  Jun 13, 2020
 * Questions: https://leetcode.com/problems/kth-ancestor-of-a-tree-node/
 */
public class KthAncestorOfATreeNode {
    public static void main(String[] args) {
        System.out.println("***************************** Solution 1 *******************************");
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1));  // returns 1 which is the parent of 3
        System.out.println(treeAncestor.getKthAncestor(5, 2));  // returns 0 which is the grandparent of 5
        System.out.println(treeAncestor.getKthAncestor(6, 3));  // returns -1 because there is no such ancestor

        System.out.println("***************************** Solution 2 *******************************");
        TreeAncestor_Optimal treeAncestor_optimal = new TreeAncestor_Optimal(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor_optimal.getKthAncestor(3, 1));  // returns 1 which is the parent of 3
        System.out.println(treeAncestor_optimal.getKthAncestor(5, 2));  // returns 0 which is the grandparent of 5
        System.out.println(treeAncestor_optimal.getKthAncestor(6, 3));  // returns -1 because there is no such ancestor
    }
}

class TreeAncestor_Optimal {

    int[] parent;
    int[] height;

    public TreeAncestor_Optimal(int n, int[] parent) {
        this.parent = parent;
        this.height = new int[n];
//        At each element find the height of it and store it into a height array.
        for (int i = 1; i < parent.length; ++i) {
            fillHeight(i);
        }
    }

    public int getKthAncestor(int node, int k) {
//        If k is greater then the current height then its an invalid query, return -1.
        if (height[node] < k) return -1;
//        Else traverse K steps up the ladder.
        int ans = node;
        while (k > 0) {
            ans = parent[ans];
            --k;
        }
        return ans;
    }

    private int fillHeight(int node) {
//        If the node is zero then it is leaf, or
//        the height of node is already know
//        then return the height.
        if (node == 0 || height[node] != 0) return height[node];
        height[node] = fillHeight(parent[node]) + 1;
        return height[node];
    }
}

class TreeAncestor {

    Map<Integer, LinkedList<Integer>> map = new HashMap<>();

    public TreeAncestor(int n, int[] parent) {
        map.put(0, new LinkedList<>());
        for (int i = 1; i < n; i++) {
//            At each node all its parents to the node.
            LinkedList<Integer> parents = new LinkedList<>(map.get(parent[i]));
            parents.addFirst(parent[i]);
            map.put(i, parents);
        }
    }

    public int getKthAncestor(int val, int k) {
        List<Integer> parents = map.get(val);
        return parents.size() < k ? -1 : parents.get(k - 1);
    }
}