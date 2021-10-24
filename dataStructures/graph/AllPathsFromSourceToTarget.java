import java.util.*;

/**
 * Created on:  Jul 25, 2020
 * Questions: https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourceToTarget {
    public static void main(String[] args) {

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<List<Integer>>> memo = new HashMap<>();
        return dfs(graph, 0, memo);
    }

    private List<List<Integer>> dfs(int[][] graph, int start, Map<Integer, List<List<Integer>>> memo) {
//        When reached to the end, then you have only one value in the list.
        if (start == graph.length - 1) {
            return Collections.singletonList(Collections.singletonList(start));
        } else {
            List<List<Integer>> cur = new ArrayList<>();
            for (int dep : graph[start]) {
                List<List<Integer>> next = dfs(graph, dep, memo);
                for (List<Integer> path : next) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    temp.addAll(path);
                    cur.add(temp);
                }
            }
            return memo.put(start, cur);
        }
    }
}
