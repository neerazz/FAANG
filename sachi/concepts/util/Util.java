import java.util.*;

public class Util {

    /**
     * Generate array of size less than 100
     *
     * @return
     */
    public static int[] generateRandomArray() {
        Random rand = new Random();
        int size = rand.nextInt(100);
        return generateRandomArray(size);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000);
        }
        print(arr);
        return arr;
    }

    public static void print(int[] array) {
        System.out.println("\n---------- PRINTING Array-------------");
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
        System.out.println("\n---------- FInished Printing Array-------------");
    }

    public static void print(int[][] matrix) {
        System.out.println("\n---------- PRINTING MATRIX-------------");
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println("\n---------- END MATRIX-------------");
    }

    public static void print(ListNode head) {
        System.out.println("\n---------- PRINTING LinkedList-------------");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("\n---------- END LinkedList-------------");
    }

    public static void print(Node head) {
        System.out.println("\n---------- PRINTING LinkedList-------------");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("\n---------- END LinkedList-------------");
    }

    public static void print(Node head, boolean isCyclic) {
        System.out.println("\n---------- PRINTING LinkedList-------------");
        if (!isCyclic) {
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
        } else {
            Set<Node> cache = new HashSet<>();
            while (true) {
                if (cache.contains(head))
                    return;
                System.out.print(head.val + " ");
                cache.add(head);
                head = head.next;
            }

        }
        System.out.println("\n---------- END LinkedList-------------");
    }

    public static TreeNode convertArrayToTreeNode(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        TreeNode[] nodes = new TreeNode[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int parentIndex = (i - 1) / 2;
            int leftIndex = (2 * parentIndex) + 1;
            int rightIndex = (2 * parentIndex) + 2;
            TreeNode parent = nodes[parentIndex] == null ? new TreeNode(arr[parentIndex]) : nodes[parentIndex];
            //Set Left index
            if (nodes[leftIndex] == null) {
                if (arr[leftIndex] != null) {
                    parent.left = null;
                } else {
                    parent.left = new TreeNode(arr[leftIndex]);
                }
            }
            //Set Right index
            if (nodes[rightIndex] == null) {
                if (arr[rightIndex] != null) {
                    parent.right = null;
                } else {
                    parent.right = new TreeNode(arr[rightIndex]);
                }
            }
            nodes[parentIndex] = parent;
            i--;
        }
        return nodes[0];
    }

    public static void print(TreeNode root) {
        System.out.println("---------- Printing TreeNode-------------");
        //Print using BFS
        if (root == null) return;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            System.out.print(node.val + " ");
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
        }
        System.out.println("\n---------- END TreeNode-------------");
    }
}
