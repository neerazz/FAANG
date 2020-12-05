# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class IncreasingOrderSearchTree:

    def increasingBST(self, root: TreeNode) -> TreeNode:
        def helper(node):
            if node:
                yield from helper(node.left)
                yield node.val
                yield from helper(node.right)

        res = ref = TreeNode(-1)
        if root:
            for rec in helper(root):
                ref.next = TreeNode(rec.val)
                ref = ref.right
        return res.right

    increasingBST(TreeNode(0, TreeNode(1), TreeNode(2)))