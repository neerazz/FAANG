package util;

import java.util.*;
import java.util.stream.Collectors;

public class Util {

    static Random random = new Random();
    static String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * Generate a random string of specified length
     *
     * @param length length of string
     * @return random string
     */
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rand = random.nextInt(ALPHABETS.length());
            sb.append(ALPHABETS.charAt(rand));
        }
        return sb.toString();
    }

    /**
     * Generate a random string of random length - Less than 100
     *
     * @return random string
     */
    public static String generateRandomString() {
        return generateRandomString(random.nextInt(100));
    }

    /**
     * Generate Random Array between 0 and 100
     *
     * @return Random Array
     */
    public static int[] generateRandomArray() {
        Random rand = new Random();
        int size = rand.nextInt(100);
        return generateRandomArray(size);
    }

    public static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public static int generateRandomNumber(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound - 1);
    }


    /**
     * Generate Random Array of Size
     *
     * @param size size
     * @return Return array of size
     */
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }
        //print(arr);
        return arr;
    }

    /**
     * Print an Array
     *
     * @param array array
     */
    public static void print(int[] array) {
        System.out.println("\n---------- PRINTING Array-------------");
        System.out.print("[");
        Arrays.stream(array).forEach(e -> System.out.print(e + ","));
        System.out.print("]");
        System.out.println("\n--------------------------------------");
    }

    /**
     * Print an Array
     *
     * @param array array
     */
    public static void print(int[] array, String message) {
        System.out.println("\n----------" + message + "-------------");
        System.out.print("[");
        Arrays.stream(array).forEach(e -> System.out.print(e + ","));
        System.out.print("]");
        System.out.println("\n--------------------------------------");
    }

    /**
     * Print an Array
     *
     * @param array array
     */
    public static void print(double[] array) {
        System.out.println("\n---------- PRINTING Array-------------");
        System.out.print("[");
        Arrays.stream(array).forEach(e -> System.out.print(e + ","));
        System.out.print("]");
        System.out.println("\n--------------------------------------");
    }

    public static void print(double[] array, String message) {
        System.out.println("\n----------" + message + "-------------");
        System.out.print("[");
        Arrays.stream(array).forEach(e -> System.out.print(e + ","));
        System.out.print("]");
        System.out.println("\n-------------------------------------");
    }

    /**
     * Print 2d matrix
     *
     * @param matrix Matrix
     */
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

    /**
     * Print Linked List
     *
     * @param head Head
     */
    public static void print(ListNode head) {
        System.out.println("\n---------- PRINTING problems.LinkedList-------------");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("\n---------- END problems.LinkedList-------------");
    }

    /**
     * Print Linked List
     *
     * @param head head
     */
    public static void print(Node head) {
        System.out.println("\n---------- PRINTING problems.LinkedList-------------");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("\n---------- END problems.LinkedList-------------");
    }

    /**
     * Print Linkedlist when cyclic
     *
     * @param head     head
     * @param isCyclic isLinkedList cyclic
     */
    public static void print(Node head, boolean isCyclic) {
        System.out.println("\n---------- PRINTING problems.LinkedList-------------");
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
        System.out.println("\n---------- END problems.LinkedList-------------");
    }

    /**
     * @param integers
     * @return
     */
    public static TreeNode createTree(Integer[] integers) {
        if (integers.length == 0) return null;
        int index = 0;
        TreeNode treeNode = new TreeNode(integers[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (index < integers.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
//                Create left and right child.
                TreeNode currentHead = queue.poll();
//                Create left Child.
                Integer left = integers[index++];
                if (left != null) {
                    TreeNode currentTree = new TreeNode(left);
                    currentHead.left = currentTree;
                    queue.add(currentTree);
                }
                if (index == integers.length) break;
//                Create Right Child.
                Integer right = integers[index++];
                if (right != null) {
                    TreeNode currentTree = new TreeNode(right);
                    currentHead.right = currentTree;
                    queue.add(currentTree);
                }
            }
        }
        return treeNode;
    }

    /**
     * Convert an Array into Tree
     *
     * @param arr Input array
     * @return TreeNode
     */
    public static TreeNode createTreeFromArray(Integer[] arr) {
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

    /**
     * Print Tree
     *
     * @param root tree
     */
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

   /* public static TreeNode arrayToTreeBFS(int[] array) {
        if (array == null || array.length == 0) return null;
        TreeNode root = new TreeNode(array[0]);

    }*/

    /**
     * Create LinkedList From Array
     *
     * @param array array
     * @return array
     */
    public static ListNode createLinkedListFromArray(List<Integer> array) {
        ListNode dummy = new ListNode(-1);
        ListNode sol = dummy;
        for (Integer i : array) {
            sol.next = new ListNode(i);
            sol = sol.next;
        }
        return dummy.next;
    }

    /**
     * Create LinkedList From Array
     *
     * @param array array
     * @return ListNode
     */
    public static ListNode createLinkedListFromArray(int[] array) {
        return createLinkedListFromArray(Arrays.stream(array).boxed().collect(Collectors.toList()));
    }

    /**
     * Create LinkedList From Array
     *
     * @param array array
     * @return ListNode
     */
    public static ListNode createLinkedListFromArray(Integer[] array) {
        return createLinkedListFromArray(Arrays.asList(array));
    }

    public static void main(String[] args) {
    }

    public static TreeNode generateRandomTree(int length) {
        TreeNode tree = generateRandomTreeLength(length);
        System.out.println("Generated tree of length: " + length);
        Util.print(tree);
        return tree;
    }

    private static TreeNode generateRandomTreeLength(int length) {
        if (length == 0) return null;
        TreeNode node = new TreeNode(random.nextInt(50));
        node.left = generateRandomTreeLength(length - 1);
        node.right = generateRandomTreeLength(length - 1);
        return node;
    }


}
