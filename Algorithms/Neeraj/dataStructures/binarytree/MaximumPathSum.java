import java.util.*;

class MaximumPathSum{
  public static void main(String[] args) {
    BinaryTree one = new BinaryTree(1);
    one.left = new BinaryTree(2);
    one.right = new BinaryTree(3);
    one.left.left  = new BinaryTree(4);
    one.left.right  = new BinaryTree(5);
    one.right.left  = new BinaryTree(6);
    one.right.right = new BinaryTree(7);
    System.out.println(maxPathSum(one));
  }

  public static int maxPathSum(BinaryTree tree) {
    if(tree == null) return 0;
    int left = maxPathSum(tree.left);
    int right = maxPathSum(tree.right);
    int childMax = Math.max(left,right);
    return Math.max(childMax+tree.value , tree.value);
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
