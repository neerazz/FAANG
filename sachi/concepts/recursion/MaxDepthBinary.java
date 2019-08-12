public class MaxDepthBinary{
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(7);
        TreeNode t4 = new TreeNode(15); 
        TreeNode t3 = new TreeNode(20);
        t3.left = t4;
        t3.right = t5;
        TreeNode t2 = new TreeNode(9);
        TreeNode t1 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(maxDepth(t1));
    }
    public static int maxDepth(TreeNode root) {
        if(root == null){    
            return 0;
        }else{
            return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        }        
    }
}