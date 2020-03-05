import java.util.*;


class FindClosestValueInBST{
  public static void main(String[] args) {

  }

  int closestValue = Integer.MAX_VALUE;
  public int closestValue(TreeNode tree, double target) {
      if(tree == null) return -1;
      if(tree.val == target) return tree.val;
      closestValue = tree.val;
      search(tree, target, Math.abs(target-tree.val));
      return closestValue;
  }
  private void search(TreeNode tree, double target, double diff){
      if(tree == null){
        return;
      }
      if(tree.val == target){
        closestValue = tree.val;
        return;
      }
      if(Math.abs(target-tree.val) < Math.abs(target-closestValue)){
        closestValue = tree.val;
      }
      if(tree.left != null && target < tree.val){
        search(tree.left, target, Math.abs(target-tree.val));
      }else{
        search(tree.right, target, Math.abs(target-tree.val));
      }
   }
}
