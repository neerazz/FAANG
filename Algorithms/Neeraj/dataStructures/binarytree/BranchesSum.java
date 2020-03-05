import java.util.*;

class BranchesSum{
  public static void main(String[] args) {

  }
  // This is the class of the input root. Do not edit it.
  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
    List<Integer> sol = new ArrayList<>();
    pathSum(root,sol,0);
    return sol;
  }

  public static void pathSum(BinaryTree node, List<Integer> sol, int bSum){
    bSum += node.value;
    if(node.left == null && node.right == null){
      sol.add(bSum);
      return;
    }
    if(node.left != null){
      pathSum(node.left, sol, bSum);
    }
    if(node.right != null){
      pathSum(node.right, sol, bSum);
    }
  }
}
