public class BuildTreeInorder {
    public static void main(String[] args) {
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        int[] postOrder = new int[]{9, 15, 7, 20, 3};
        Util.print(buildTree(inOrder, postOrder));
    }

    public static TreeNode buildTree(int[] inOrder, int[] postOrder) {
        return null;
    }
}