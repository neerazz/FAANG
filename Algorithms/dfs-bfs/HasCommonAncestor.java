import java.util.*;

/**
 * Created on:  Sep 18, 2021
 * Ref:
 * <p>
 * Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique positive integer identifier.
 * <p>
 * For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.
 * <p>
 * 15
 * |
 * 14  13
 * |   |
 * 1   2    4   12
 * \ /   / | \ /
 * 3   5  8  9
 * \ / \     \
 * 6   7     11
 * <p>
 * parentChildPairs1 = [
 * (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
 * (4, 8), (4, 9), (9, 11), (14, 4), (13, 12),
 * (12, 9),(15, 13)
 * ]
 * <p>
 * <p>
 * Write a function that takes this data and the identifiers of two individuals as inputs and returns true if and only if they share at least one ancestor.
 * <p>
 * Sample input and output:
 * <p>
 * hasCommonAncestor(parentChildPairs1, 3, 8) => false
 * hasCommonAncestor(parentChildPairs1, 5, 8) => true
 * hasCommonAncestor(parentChildPairs1, 6, 8) => true
 * hasCommonAncestor(parentChildPairs1, 6, 9) => true
 * hasCommonAncestor(parentChildPairs1, 1, 3) => false
 * hasCommonAncestor(parentChildPairs1, 3, 1) => false
 * hasCommonAncestor(parentChildPairs1, 7, 11) => true
 * hasCommonAncestor(parentChildPairs1, 6, 5) => true
 * hasCommonAncestor(parentChildPairs1, 5, 6) => true
 * <p>
 * Additional example: In this diagram, 4 and 12 have a common ancestor of 11.
 * <p>
 * 11
 * /  \
 * 10   12
 * /  \
 * 1   2    5
 * \ /    / \
 * 3    6   7
 * \        \
 * 4        8
 * <p>
 * parentChildPairs2 = [
 * (1, 3), (11, 10), (11, 12), (2, 3), (10, 2),
 * (10, 5), (3, 4), (5, 6), (5, 7), (7, 8),
 * ]
 * <p>
 * hasCommonAncestor(parentChildPairs2, 4, 12) => true
 * hasCommonAncestor(parentChildPairs2, 1, 6) => false
 * hasCommonAncestor(parentChildPairs2, 1, 12) => false
 * <p>
 * n: number of pairs in the input
 */

public class HasCommonAncestor {
    public static void main(String[] args) {

        int[][] parentChildPairs = new int[][]{
                {5, 6}, {1, 3}, {2, 3}, {3, 6}, {15, 12}, {5, 7},
                {4, 5}, {4, 9}, {9, 12}, {30, 16}
        };
        System.out.println("********************** Problem 1 - Input: 1 ******************************");
        System.out.println(findNodesWithZeroAndOneParents(parentChildPairs));

        int[][] parentChildPairs1 = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12}, {12, 9},
                {15, 13}
        };
        System.out.println("********************** Problem 2 - Input: 1 ******************************");
        System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8) + " = false");
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8) + " = true");
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8) + " = true");
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9) + " = true");
        System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3) + " = false");
        System.out.println(hasCommonAncestor(parentChildPairs1, 3, 1) + " = false");
        System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11) + " = true");
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5) + " = true");
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6) + " = true");

        int[][] parentChildPairs2 = new int[][]{
                {1, 3}, {11, 10}, {11, 12}, {2, 3}, {10, 2},
                {10, 5}, {3, 4}, {5, 6}, {5, 7}, {7, 8}
        };
        System.out.println("********************** Problem 2 - Input: 2 ******************************");
        System.out.println(hasCommonAncestor(parentChildPairs2, 4, 12) + " = true");
        System.out.println(hasCommonAncestor(parentChildPairs2, 1, 6) + " = false");
        System.out.println(hasCommonAncestor(parentChildPairs2, 1, 12) + " = false");
    }

    // Q2

    static boolean hasCommonAncestor(int[][] pairs, int a, int b) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            int par = pair[0], child = pair[1];
            map.putIfAbsent(par, new HashSet<>());
            map.putIfAbsent(child, new HashSet<>());
            map.get(child).add(par);
        }
        Set<Integer> patha = new HashSet<>();
        getpath(map, patha, a);
        Set<Integer> pathb = new HashSet<>();
//        getpath(map, patha, b);
        getpath(map, pathb, b);
        for (int node : patha) {
            if (pathb.contains(node)) return true;
        }
        return false;
    }

    static void getpath(Map<Integer, Set<Integer>> map, Set<Integer> path, int cur) {
        if (path.contains(cur)) return;
        for (int par : map.get(cur)) {
            getpath(map, path, par);
            path.add(cur);
        }
    }


    //Q1
    static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : pairs) {
            int parent = pair[0], child = pair[1];
            map.put(child, map.getOrDefault(child, 0) + 1);
            map.putIfAbsent(parent, 0);
        }
        List<Integer> zeros = getNodes(map, 0);
        List<Integer> ones = getNodes(map, 1);
        return Arrays.asList(zeros, ones);
    }

    static List<Integer> getNodes(Map<Integer, Integer> map, int count) {
        List<Integer> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == count) {
                result.add(key);
            }
        }
        return result;
//     return map.entrySet()
//       .stream()
//       .filter(entry -> entry.getValue() == count)
//       .map(entry -> entry.getKey())
//       .collect(Collector.toList());
    }

}