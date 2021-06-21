import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Oct 07, 2020
 * Questions: https://www.educative.io/courses/grokking-the-coding-interview/3j9V2QL3Ky9
 */

public class UniqueTrees {

    public static List<TreeNode> findUniqueTrees(int n) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        return helper(1, n, map);
    }

    private static List<TreeNode> helper(int s, int e, Map<String, List<TreeNode>> map) {
        String key = String.format("%d - %d", s, e);
        if (map.containsKey(key)) return map.get(key);
        List<TreeNode> cur = new ArrayList<>();
        if (s == e) {
            cur.add(new TreeNode(s));
        } else {
            for (int i = s; i <= e; i++) {
                List<TreeNode> left = helper(s, i - 1, map);
                List<TreeNode> right = helper(i + 1, e, map);
                if (left.isEmpty() && right.isEmpty()) {
                    cur.add(new TreeNode(s));
                } else if (left.isEmpty()) {
                    for (TreeNode r : right) {
                        TreeNode temp = new TreeNode(i);
                        temp.right = r;
                        cur.add(temp);
                    }
                } else if (right.isEmpty()) {
                    for (TreeNode l : left) {
                        TreeNode temp = new TreeNode(i);
                        temp.left = l;
                        cur.add(temp);
                    }
                } else {
                    for (TreeNode l : left) {
                        for (TreeNode r : right) {
                            TreeNode temp = new TreeNode(i);
                            temp.left = l;
                            temp.right = r;
                            cur.add(temp);
                        }
                    }
                }
            }
        }
        map.put(key, cur);
        return cur;
    }

    public static void main(String[] args) {
        List<TreeNode> result = findUniqueTrees(2);
        System.out.println("Total trees: " + result.size());
        System.out.println("Trees: " + result);
        result = findUniqueTrees(3);
        System.out.println("Total trees: " + result.size());
        System.out.println("Trees: " + result);
        result = findUniqueTrees(15);
        System.out.println("Total trees: " + result.size());
        System.out.println("Trees: " + result);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.format("%s <- left:%s: right -> %s", left, val, right);
        }
    }
}