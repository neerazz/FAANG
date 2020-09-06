import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Sep 05, 2020
 * Questions: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 */
public class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {

    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getElements(root1), list2 = getElements(root2);
        List<Integer> result = new ArrayList<>();
        int i1 = 0, i2 = 0, l1 = list1.size(), l2 = list2.size();
        while (i1 < l1 && i2 < l2) {
            if (list1.get(i1) < list2.get(i2)) {
                result.add(list1.get(i1++));
            } else {
                result.add(list2.get(i2++));
            }
        }
        while (i1 < l1) result.add(list1.get(i1++));
        while (i2 < l2) result.add(list2.get(i2++));
        return result;
    }

    private static List<Integer> getElements(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> left = getElements(root.left);
        left.add(root.val);
        left.addAll(getElements(root.right));
        return left;
    }
}
