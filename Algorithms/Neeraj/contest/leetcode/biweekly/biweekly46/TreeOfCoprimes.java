package biweekly.biweekly46;

import java.util.*;

/**
 * Created on:  Feb 20, 2021
 * Questions:
 */

public class TreeOfCoprimes {

    public static void main(String[] args) {

    }

    public static int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length, level[] = new int[n], result[] = new int[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], val -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], val -> new HashSet<>()).add(edge[0]);
        }
        boolean[][] coprimes = new boolean[51][51];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = -1;
//        Calculate all the combinations of coprimes.
        checkCoprimes(coprimes);
        boolean[] visited = new boolean[n];
        Map<Integer, int[]> soFar = new HashMap<>();
//        Perform a dfs, keep adding every entry into map.
//          Ex: at level 1 you add a value v1, and there is a coprime of v1 at level 5, when you do dfs at level 5. Your map will collect soFAr values.
        dfs(0, 0, coprimes, graph, soFar, result, nums, visited);
        return result;
    }

    private static void dfs(int cur, int level, boolean[][] coprimes, Map<Integer, Set<Integer>> graph, Map<Integer, int[]> soFar, int[] result, int[] nums, boolean[] visited) {
        if (visited[cur]) return;
        visited[cur] = true;
//        Coprime, soFar map will have key as value,
//        Graph map will have index as key.
        int node = nums[cur], ancestor = -1, dist = Integer.MAX_VALUE;
        for (int node2 = 1; node2 < 51; node2++) {
            if (coprimes[node][node2] && soFar.containsKey(node2)) {
                int[] landD = soFar.get(node2);
//                If the other pair is found and the depth of existing ancestor is greater then the new pair then take the new pair.
                if (level - landD[0] <= dist) {
                    dist = level - landD[0];
                    ancestor = landD[1];
                }
            }
        }
        result[cur] = ancestor;
        int[] exists = soFar.get(node);
        soFar.put(node, new int[]{level, cur});
//        Loop though all the connected nodes
        for (int dep : graph.getOrDefault(cur, new HashSet<>())) {
            if (visited[dep]) continue;
            dfs(dep, level + 1, coprimes, graph, soFar, result, nums, visited);
        }
        if (exists != null) soFar.put(node, exists);
        else soFar.remove(node);
    }

    private static void checkCoprimes(boolean[][] coprimes) {
        for (int i = 1; i < 51; i++) {
            for (int j = 1; j < 51; j++) {
                if (i == j) continue;
                int gcd = gcd(i, j);
                if (gcd == 1) {
                    coprimes[i][j] = coprimes[j][i] = true;
                }
            }
        }
    }

    private static int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int[] getCoprimes_naive(int[] nums, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], val -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], val -> new HashSet<>()).add(edge[0]);
        }
        int n = nums.length, level[] = new int[n], result[] = new int[n];
        Arrays.fill(level, Integer.MAX_VALUE);
        Arrays.fill(result, Integer.MAX_VALUE);
//        Perform dfs to find level of each node.
        dfs(0, level, graph, 0);
        for (int i = 0; i < n; i++) {
            result[i] = getClosestAncestor(i, i, graph, level, nums);
        }
        return result;
    }

    private static int getClosestAncestor(int start, int cur, Map<Integer, Set<Integer>> graph, int[] levels, int[] nums) {
        if (cur == 0) return -1;
        int curAns = -1;
        for (int dep : graph.getOrDefault(cur, new HashSet<>())) {
            if (levels[dep] < levels[cur]) {
                int gcd = gcd(nums[start], nums[dep]);
                if (gcd == 1) {
                    return dep;
                }
//                Make a recursive call to get the closest ancestor of the dep.
                int newAns = getClosestAncestor(start, dep, graph, levels, nums);
                if (newAns == -1) continue;
                else if (curAns == -1 || levels[cur] - levels[curAns] > levels[cur] - levels[newAns]) curAns = newAns;
            }
        }
        return curAns;
    }

    private static void dfs(int cur, int[] level, Map<Integer, Set<Integer>> graph, int l) {
        if (level[cur] != Integer.MAX_VALUE) return;
        level[cur] = l;
        for (int dep : graph.getOrDefault(cur, new HashSet<>())) {
            dfs(dep, level, graph, l + 1);
        }
    }
}
