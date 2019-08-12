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
        return max_depth(root,0);        
    }

    public static int max_depth(TreeNode root, int i){
        if(root == null){
            return i;
        }else{
            i += max(max_depth(root.left,i),max_depth(root.right,i));
            return i;
        }
    }

    private static int max(int a, int b){
        return a>b ? a : b;
    }

}