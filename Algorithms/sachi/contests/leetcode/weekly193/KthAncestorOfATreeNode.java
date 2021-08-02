package contests.leetcode.weekly193;

import java.util.HashMap;
import java.util.Map;

//TODO:SACHIN::WRONG Answer
public class KthAncestorOfATreeNode {

    int size;
    int[] arr;
    Map<String, Integer> cache;
    int height;

    public KthAncestorOfATreeNode(int n, int[] parent) {
        size = n;
        arr = parent;
        cache = new HashMap<>();
        height = (n - 1) / 2;
    }

    public static void main(String[] args) {
        int n= 10;
        int[] arr = new int[]{-1,0,1,2,0,1,0,4,7,1};
        KthAncestorOfATreeNode kthAncestorOfATreeNode = new KthAncestorOfATreeNode(n, arr);
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(3, 3));
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(2, 9));
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(2, 7));
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(3, 2));
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(2, 10));
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(4, 9));
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(0, 2));
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(6, 4));
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(4, 2));
        System.out.println(kthAncestorOfATreeNode.getKthAncestor(4, 7));
    }

    public int getKthAncestor(int node, int k) {
        int counter = 1;
        if (k > height) return -1;
        String key = "" + node + "+" + k;
        if (cache.containsKey(key)) return cache.get(key);
        int sol = node;
        while (k > 0 && sol >= 0) {
            sol = arr[sol];
            k--;
            cache.put("" + node + "+" + counter, sol);
            counter++;
        }
        if (k > 0) {
            cache.put(key, -1);
            return -1;
        } else {
            cache.put(key, sol);
            return sol;
        }
    }
}
