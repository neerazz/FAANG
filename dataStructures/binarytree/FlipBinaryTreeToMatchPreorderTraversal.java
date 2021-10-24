import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Mar 29, 2021
 * Questions: https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 */

public class FlipBinaryTreeToMatchPreorderTraversal {

    int index;

    public static void main(String[] args) {

    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> flipped = new ArrayList<>();
        index = 0;
        dfs(root, flipped, voyage);
        if (!flipped.isEmpty() && flipped.contains(-1)) {
            flipped.clear();
            flipped.add(-1);
        }
        return flipped;
    }

    public void dfs(TreeNode node, List<Integer> flipped, int[] voyage) {
        if (node != null) {
//            Match the current node value with pre-order traversal.
            if (node.val != voyage[index++]) {
                flipped.clear();
                flipped.add(-1);
                return;
            }

//            Now set close the next node, If the next node value is same as left, then make a recursive call, else flip the nodes.
            if (index < voyage.length && node.left != null &&
                    node.left.val != voyage[index]) {
                flipped.add(node.val);
                dfs(node.right, flipped, voyage);
                dfs(node.left, flipped, voyage);
            } else {
                dfs(node.left, flipped, voyage);
                dfs(node.right, flipped, voyage);
            }
        }
    }
}
