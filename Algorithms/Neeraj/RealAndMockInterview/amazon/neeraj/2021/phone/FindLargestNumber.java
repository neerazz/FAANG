import java.util.*;
import java.io.*;

/**
 * Created on:  Feb 08, 2021
 * Questions: https://leetcode.com/discuss/interview-question/869530/amazon-phone-largest-common-number-in-2-bsts
 * Write code that given the root of two BSTs of integers, finds the greatest common integer in them.
 * <p>
 * Given:
 * <p>
 * 5
 * /  \
 * 3   7
 * <p>
 * 9
 * / \
 * 5   12
 * \
 * 7
 * Returns:
 * 7
 * <p>
 * <p>
 * set1: 3,5,7,10
 * i
 * set2: 5,7,9,12
 * <p>
 * when nothing in common: -1
 * when one/both trees are empy: -1
 * <p>
 * Option 1:
 * n -> number of elements in bst2, m -> number of elements in bst2
 * Time: O(max(n,m) + n)= O(n+m)
 * Space: O(n+m) + O(log max(n,m))
 * System Stack:
 * Balance tree: O(log max(n,m))
 * Worst case: O(max(n,m))
 * <p>
 * Option 2:
 * Time: O(n log m)
 * Space: O(n)
 */

public class FindLargestNumber {

    static class Node {
        int val;
        Node left;
        Node right;
    }

    public static void main(String[] args) {

    }

    private static int largestInt(Node node1, Node node2) {
        if (node1 == null || node2 == null) return -1;
        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new HashSet<>();
        buildSet(node1, set1);
        buildSet(node2, set2);
        for (int val : set1) {
            if (set2.contains(val)) {
                return val;
            }
        }
        return -1;
    }

    private static void buildSet(Node node, Set<Integer> set) {
        if (node == null) return;
        buildSet(node.right, set);
        set.add(node.val);
        buildSet(node.left, set);
    }
}
