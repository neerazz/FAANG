class InvertBinaryTree{
  public static void invertBinaryTree(BinaryTree tree) {
    if(tree == null) return;
    swap(tree);
    invertBinaryTree(tree.left);
    invertBinaryTree(tree.right);
  }
  private static void swap(BinaryTree tree){
    BinaryTree t = tree.left;
    tree.left = tree.right;
    tree.right = t;
  }
  private static void helper(BinaryTree tree, BinaryTree left, BinaryTree right){
    if(tree == null) return;
    if(left != null && right != null){
      tree.right.value = left.value;
      tree.left.value = right.value;
      helper(tree.left,right.right,right.left);
      helper(tree.right,left.right,left.left);
    }else if(left != null){
      tree.right = new BinaryTree(left.value);
      tree.left = null;
      helper(tree.right,left.right,left.left);
    }else if(right != null){
      tree.left = new BinaryTree(left.value);
      tree.right = null;
      helper(tree.left,right.right,right.left);
    }
    return;
  }
  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}
