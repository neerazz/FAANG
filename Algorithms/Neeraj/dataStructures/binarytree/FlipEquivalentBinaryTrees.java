/**
 * Created on:  Aug 11, 2021
 * Ref : https://leetcode.com/problems/flip-equivalent-binary-trees/
 */
public class FlipEquivalentBinaryTrees {
    public static void main(String[] args) {

    }
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
//         Same without flip.
        if(flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) return true;
//         With flip
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}
