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

  /*
            1
          /  \
        2     3
      /  \   / \
     4    5 6   7

  */
  public static int maxPathSum(BinaryTree tree) {
    if(tree == null) return 0;
    return helper(tree)[1];
  }
  
  private static int[] helper(BinaryTree tree){
    if(tree == null) return new int[]{0,0};
    // First element in array is the maximum value as sum, second is maximum value as path.
    int[] left = helper(tree.left);
    int[] right = helper(tree.right);
    int childMaxValue = Math.max(left[0],right[0]);
    // Maximum path at current would be maximum of (child value + nod val & just node val)
    int maxSumAtCurrent = Math.max(childMaxValue+tree.value , tree.value);
    // Maximum sum at current would be maximum of (left sum max+ right sum max + cur node & maxPathAtCurrent)
    int maxPathAtCurrent  = Math.max(left[0]+right[0]+tree.value , maxSumAtCurrent);
    // max would be maximum of (left path, right path, maximum at Current)
    int finalMaxPathAtCurrent = Math.max(Math.max(left[1],right[1]),maxPathAtCurrent);
    return new int[]{maxSumAtCurrent,finalMaxPathAtCurrent};
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
