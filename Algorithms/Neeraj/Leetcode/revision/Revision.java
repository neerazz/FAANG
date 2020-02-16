package revision;

import java.util.*;

public class Revision {
    static int rootIndex = 0;

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        System.out.println(postorderTraversal(one));
        System.out.println(levelOrder(one));
        System.out.println(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode l1ref = l1, l2ref = l2;
        ListNode output = new ListNode(0), outputRef = output;

        while (l1ref != null || l2ref != null) {
//            If both the nodes have values. Then pick the smallest and set it to output.
            if (l1ref != null && l2ref != null) {
                if (l1ref.val < l2ref.val) {
                    outputRef.next = l1ref;
                    l1ref = l1ref.next;
                } else {
                    outputRef.next = l2ref;
                    l2ref = l2ref.next;
                }
            } else if (l1ref != null) {
                outputRef.next = l1ref;
                l1ref = l1ref.next;
            } else {
                outputRef.next = l2ref;
                l2ref = l2ref.next;
            }
            outputRef = outputRef.next;
        }
        return output.next;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        List<Integer> pathToP = new ArrayList<>();
        List<Integer> pathToQ = new ArrayList<>();
        if (findPath(root, p, pathToP) && findPath(root, q, pathToQ)) return findLowestCommonAncestor(pathToP, pathToQ);
        return null;
    }

    private static TreeNode findLowestCommonAncestor(List<Integer> pathToP, List<Integer> pathToQ) {
        for (int i = 0; i < pathToP.size(); i++) {
            if (pathToQ.contains(pathToP.get(i))) return new TreeNode(pathToP.get(i));
        }
        return null;
    }

    private static boolean findPath(TreeNode root, TreeNode p, List<Integer> pathList) {
        if (root == null) return false;
        if (root.val == p.val) {
            pathList.add(root.val);
            return true;
        }
        if (findPath(root.left, p, pathList)) {
            pathList.add(root.val);
            return true;
        }
        if (findPath(root.right, p, pathList)) {
            pathList.add(root.val);
            return true;
        }
        return false;
    }

    public static Node connect(Node root) {
        if (root == null) return null;
        Node head = root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node peek = queue.peek();
                if (peek.left != null) queue.add(peek.left);
                if (peek.right != null) queue.add(peek.right);
            }
//            Iterate through the level values and link the first value with second and so on.
            if (queue.size() > 0) {
                Node pre = queue.get(0);
                for (int i = 1; i < queue.size(); i++) {
                    pre.next = queue.get(i);
                    pre = pre.next;
                }
            }
        }
        return head;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIndex = postorder.length - 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree_inorder_and_postOrder(inorder, postorder, hashMap, 0, postorder.length - 1);
    }

    private static TreeNode buildTree_inorder_and_preOrder(int[] inorder, int[] postorder, HashMap<Integer, Integer> hashMap, int left, int right) {
        if (left > right) return null;
        int rootValue = postorder[rootIndex++];
        TreeNode treeNode = new TreeNode(rootValue);
        int inOrderIndex = hashMap.get(rootValue);
        treeNode.left = buildTree_inorder_and_postOrder(inorder, postorder, hashMap, left, inOrderIndex - 1);
        treeNode.right = buildTree_inorder_and_postOrder(inorder, postorder, hashMap, inOrderIndex + 1, right);
        return treeNode;
    }

    private static TreeNode buildTree_inorder_and_postOrder(int[] inorder, int[] postorder, HashMap<Integer, Integer> hashMap, int left, int right) {
        if (left > right) return null;
        int rootValue = postorder[rootIndex--];
        TreeNode treeNode = new TreeNode(rootValue);
        int inOrderIndex = hashMap.get(rootValue);
        treeNode.right = buildTree_inorder_and_postOrder(inorder, postorder, hashMap, inOrderIndex + 1, right);
        treeNode.left = buildTree_inorder_and_postOrder(inorder, postorder, hashMap, left, inOrderIndex - 1);
        return treeNode;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum_helper(root, sum, 0);
    }

    private boolean hasPathSum_helper(TreeNode root, int sum, int current) {
        if (root == null) return false;
        current += root.val;
        if (root.left == null && root.right == null) return sum == current;
        return hasPathSum_helper(root.left, sum, current) || hasPathSum_helper(root.right, sum, current);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        else if (tree1 == null || tree2 == null) return false;
        return tree1.val == tree2.val && isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
    }

    public static int maxDepth(TreeNode root) {
        return findMaxDepth(root, 0);
    }

    private static int findMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int left = findMaxDepth(root.left, depth);
        int right = findMaxDepth(root.right, depth);
        return Math.max(left, right);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode peek = queue.peek();
                    if (peek.left != null) {
                        queue.add(peek.left);
                    }
                    if (peek.right != null) {
                        queue.add(peek.right);
                    }
                    level.add(peek.val);
                    queue.poll();
                }
                output.add(level);
            }
        }
        return output;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
//         Take the left side first.
        if (root != null) {
            stack.add(root);
            visited.add(root);
            if (root.right != null) {
                stack.add(root.right);
                visited.add(root.right);
            }
            if (root.left != null) {
                stack.add(root.left);
                visited.add(root.left);
            }
        }
        while (!stack.isEmpty()) {
            TreeNode pop = stack.peek();
            if (pop.left != null && !visited.contains(pop.left)) {
                stack.add(pop.left);
                visited.add(pop.left);
            } else if (pop.right != null && !visited.contains(pop.right)) {
                stack.add(pop.right);
                visited.add(pop.right);
            } else {
                output.add(pop.val);
                stack.pop();
            }
        }
        return output;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "{ val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}