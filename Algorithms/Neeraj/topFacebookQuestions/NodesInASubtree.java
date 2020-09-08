import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on:  Sep 07, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=3068294883205371
 */
public class NodesInASubtree {
    public static void main(String[] args) {

    }

    static int[] preCalculate(Node root, String str, Map<Integer, int[]> memo) {
        int[] cur = new int[26];
        if (root == null) return cur;
        for (Node dep : root.children) {
            int[] next = preCalculate(dep, str, memo);
            for (int i = 0; i < 26; i++) cur[i] += next[i];
        }
        cur[str.charAt(root.val - 1) - 'a']++;
        memo.put(root.val, cur);
        return cur;
    }

    static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        Map<Integer, int[]> memo = new HashMap<>();
        preCalculate(root, s, memo);
        int[] result = new int[queries.size()];
        for (int i = 0; i < result.length; i++) {
            Query cur = queries.get(i);
            result[i] = memo.get(cur.u)[cur.c - 'a'];
        }
        return result;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Query {
        int u;
        char c;

        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }
}
