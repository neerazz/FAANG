class InOrderTraversal{

	public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> sol = new ArrayList<>();
    	inorderTraversalRecur(root, sol);
    	return sol;	    
    }

    public void inorderTraversalRecur(TreeNode root, List<Integer> sol) {
    	if(root == null) return;
    	inorderTraversalRecur(root.left, sol);
    	sol.add(root.val);
    	inorderTraversalRecur(root.right, sol);  
    }
}