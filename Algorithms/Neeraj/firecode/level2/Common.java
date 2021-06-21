package level2;

import java.util.*;

public class Common {
    static ArrayList<Integer> preorderedList = new ArrayList<Integer>();

    public static void main(String[] args) {
        System.out.println(sum(createTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7})));
        System.out.println(insertPairStar("cac") + " should be [cac].");
        System.out.println(insertPairStar("cc") + " should be [c*c].");
        System.out.println(deleteAtHead_elegent(createListNode(new int[]{1, 2, 3, 4}, 'c')));
        System.out.println(deleteAtHead_elegent(createListNode(new int[]{1, 2, 3, 4, 5}, 'c')));
        System.out.println(deleteAtHead(createListNode(new int[]{4}, 'c')));
        System.out.println(numberOfLeaves(createTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9})) + " should be [5].");
        System.out.println(isIsomorphic("css", "dll") + " should be [true]");
        System.out.println(isIsomorphic("abcabc", "xyzxyz") + " should be [true]");
        System.out.println(isIsomorphic("css", "dle") + " should be [false]");
        System.out.println(isIsomorphic("abcabc", "xbexyz") + " should be [false]");
        System.out.println(isIsomorphic("abcd", "aabb") + " should be [false]");
        preorder(createTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(preorderedList);
        System.out.println(removeDuplicates(Arrays.asList("Hi", "Hello", "Hey", "Hi", "Hello", "Hey")) + " should be [Hello, Hey, Hi].");
        System.out.println(validateBST(createTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7})) + " should be [true]");
        System.out.println(findNode(createTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7}), 5) + " should be [5]");
        System.out.println(size(createTreeNode(new Integer[]{1, 2, 3, 4, 5, 6, 7})) + " should be [7]");
        System.out.println(reverseInt(-123) + " should be -321");
        System.out.println(reverseInt(123) + " should be 321");
        System.out.println(reverseInt(1) + " should be 1");
        System.out.println(reverseInt(12) + " should be 21");
        System.out.println(pow(2, 3) + " should be [8.0].");
        System.out.println(pow(2, 10) + " should be " + Math.pow(2, 10));
        System.out.println(deleteAtTail(createListNode(new int[]{1, 2, 3, 4, 5}, 'c')));
        System.out.println(deleteAtMiddle(createListNode(new int[]{1, 2, 3}, 'x'), 4));
        System.out.println(deleteAtMiddle(createListNode(new int[]{1, 2, 3, 4}, 'x'), 3));
        System.out.println(isAnagram("abc", "cba") + " should be [true]");
        System.out.println(isAnagram("b", "b") + " should be [true]");
        System.out.println(isAnagram("bd", "cb") + " should be [false]");
        System.out.println(isAnagram("abcde", "acdbe") + " should be [true]");
        System.out.println(isAnagram("yellow", "llowey") + " should be [true]");
    }

    public static boolean isAnagram(String input1, String input2) {
        if (input1 == null || input2 == null || input1.length() != input2.length()) return false;
        Map<Character, Character> characterMap = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            char first = input1.charAt(i);
            char second = input2.charAt(i);
            if ((characterMap.containsKey(first) && characterMap.get(first) != second) ||
                    (characterMap.containsValue(second) && !characterMap.containsKey(first))) {
                return false;
            }
            characterMap.put(first, second);
        }
        return true;
    }

    public static boolean isAnagram_elegent(String input1, String input2) {
        if (input1 == null || input2 == null || (input1.length() != input2.length())) {
            return false;
        }
        int[] buffer = new int[26];
        for (int i = 0; i < input1.length(); i++) {
            buffer[input1.charAt(i) - 'a']++;
            buffer[input2.charAt(i) - 'a']--;
        }
        return !Arrays.stream(buffer).anyMatch(i -> i != 0);
    }

    public static double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (x == 0) return x;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 > 0) { //n is odd
            return x * pow(x * x, n / 2);
        } else { //n is even
            return pow(x * x, n / 2);
        }
    }

    public static int reverseInt(int x) {
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev;
    }

    public static int size(TreeNode root) {
        if (root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null || root.data == val) return root;
        TreeNode left = findNode(root.left, val);
        if (left == null) {
            return findNode(root.right, val);
        } else {
            return left;
        }
    }

    public static boolean validateBST(TreeNode root) {
        if (root == null) return true;
        return isValidBSTWithMinAndMax(root, null, null);
    }

    public static boolean isValidBSTWithMinAndMax(TreeNode root, Integer minvalue, Integer maxValue) {
        if (root == null) return true;
        if (minvalue != null && root.data <= minvalue) return false;
        if (maxValue != null && root.data >= maxValue) return false;
        return isValidBSTWithMinAndMax(root.left, minvalue, root.data) && isValidBSTWithMinAndMax(root.right, root.data, maxValue);
    }

    public static ArrayList<String> removeDuplicates(List<String> input) {
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String curr = input.get(i);
            if (!output.contains(curr)) {
                output.add(curr);
            }
        }
        Collections.sort(output);
        return output;
    }

    public static ArrayList<String> removeDuplicates_elegent(List<String> input) {
        return new ArrayList<>(new TreeSet<>(input));
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;
        preorderedList.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int[] nums = new int[arrLeft.length + arrRight.length];
        int left = 0, right = 0, index = 0;
        while (left < arrLeft.length && right < arrRight.length) {
            nums[index++] = arrLeft[left] < arrRight[right] ? arrLeft[left++] : arrRight[right++];
        }
        while (left < arrLeft.length) {
            nums[index++] = arrLeft[left++];
        }
        while (right < arrRight.length) {
            nums[index++] = arrRight[right++];
        }
        return nums;
    }

    public static Boolean isIntPalindrome(int x) {
        if (x == 0) return true;
        return isPalindrome(String.valueOf(x));
    }

    private static boolean isPalindrome(String value) {
        int start = 0, end = value.length() - 1;
        while (start < end) {
            if (value.charAt(start++) != value.charAt(end--))
                return false;
        }
        return true;
    }

    public static boolean isPowOfTwo(int num) {
        return Integer.bitCount(num) == 1;
    }

    public static int betterFibonacci(int n) {
        int resultForN = 0;
        if (n == 0) return resultForN;
        if (n < 3) return 1;
        int first = 1, second = 1;
        for (int i = 3; i <= n; i++) {
            resultForN = first + second;
            second = first;
            first = resultForN;
        }
        return resultForN;
    }

    public static int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(findMax(root.left), findMax(root.right)));
    }

    public static boolean isIsomorphic(String input1, String input2) {
        if (input1.length() != input2.length()) return false;
        Map<Character, Character> characterMap = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            char first = input1.charAt(i);
            char second = input2.charAt(i);
            if (characterMap.containsKey(first)) {
                if (characterMap.get(first) != second)
                    return false;
            } else {
                if (characterMap.containsValue(second))
                    return false;
                else
                    characterMap.put(first, second);
            }
        }
        return true;
    }

    public static int numberOfLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) return 1;
        return numberOfLeaves(root.left) + numberOfLeaves(root.right);
    }

    public static ListNode deleteAtHead(ListNode head) {
        if (head == null || head.next == head) return null;
        ListNode slow = head, fast = head, pre = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            } else {
                pre = pre.next;
            }
        }
//        Slow will have the lst node.
        head = head.next;
        pre.next = head;
        return head;
    }

    public static ListNode deleteAtHead_elegent(ListNode head) {
        if (head == null || head.next == head) {
            return null;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }

    public static ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == head) {
            return null;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        hashSet.add(head);
        hashSet.add(head.next);
        ListNode next = head.next.next, prev = head;
        while (!hashSet.contains(next)) {
            hashSet.add(next);
            next = next.next;
            prev = prev.next;
        }
        prev.next = next;
        return head;
    }

    public static ListNode deleteAtMiddle(ListNode head, int position) {
        if (head == null) return head;
        if (position == 1) return head.next;
        int currentIndex = 2;
        ListNode current = head.next, pre = head;
        while (current != null && currentIndex < position) {
            current = current.next;
            pre = pre.next;
            currentIndex++;
        }
        pre.next = current != null ? current.next : null;
        return head;
    }

    public static String insertPairStar(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        char prev = ' ', curr = ' ';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            curr = s.charAt(i);
            if (curr == prev) {
                sb.append('*');
            }
            sb.append(curr);
            prev = curr;
        }
        return sb.toString();
    }

    public static int sum(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        return root.data + sum(root.left) + sum(root.right);
    }

    private static ListNode createListNode(int[] nums, char c) {
        if (nums == null || nums.length == 0) return null;
        ListNode listNode = new ListNode(0), listRef = listNode;
        for (int i = 0; i < nums.length; i++) {
            listRef.next = new ListNode(nums[i]);
            listRef = listRef.next;
        }
        if (c == 'c') {
            listRef.next = listNode.next;
        }
        return listNode.next;
    }

    private static TreeNode createTreeNode(Integer[] integers) {
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode head = null;
        int index = 0;
        while (index < integers.length) {
            if (nodes.isEmpty()) {
                Integer current = integers[index++];
                if (current != null) {
                    TreeNode treeNode = new TreeNode(current);
                    nodes.add(treeNode);
                    head = treeNode;
                }
            } else {
//                Create left and right child.
                TreeNode currentHead = nodes.poll();
//                Create left Child.
                Integer left = integers[index++];
                if (left != null) {
                    TreeNode treeNode = new TreeNode(left);
                    currentHead.left = treeNode;
                    nodes.add(treeNode);
                }
//                Create Right Child.
                Integer right = integers[index++];
                if (right != null) {
                    TreeNode treeNode = new TreeNode(right);
                    currentHead.right = treeNode;
                    nodes.add(treeNode);
                }
            }
        }
        return head;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        data = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}