import java.util.*;

/**
 * Created on:  Aug 05, 2021
 * Ref : https://leetcode.com/problems/the-most-similar-path-in-a-graph/
 */
public class TheMostSimilarPathInAGraph {
    static Path min;
    static String tp[];
    static Path dp[][];
    static LinkedList graph[];
    static String names[];

    public static void main(String[] args) {

//        System.out.println(mostSimilar(5,
//                new int[][]{{0,2},{0,3},{1,2},{1,3},{1,4},{2,4}},
//                new String[]{"ATL","PEK","LAX","DXB","HND"},
//                new String[]{"ATL","DXB","HND","LAX"}));

        System.out.println(mostSimilar(4,
                new int[][]{{1, 0}, {2, 0}, {3, 0}, {2, 1}, {3, 1}, {3, 2}},
                new String[]{"ATL", "PEK", "LAX", "DXB"},
                new String[]{"ABC", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX"}));

        System.out.println(mostSimilar(4,
                new int[][]{{1, 3}, {3, 0}, {1, 0}, {0, 2}, {2, 1}},
                new String[]{"HSV", "HSV", "HSV", "FAI"},
                new String[]{"HSV", "HSV", "HSV", "HSV", "HSV", "FAI", "HSV", "HSV", "HSV", "HSV", "FAI", "FAI", "HSV", "FAI", "HSV", "HSV", "HSV", "HSV", "HSV", "HSV", "FAI", "HSV", "HSV", "HSV", "HSV", "HSV", "HSV", "HSV", "HSV", "HSV", "HSV"}));
    }

    public static List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        int len = targetPath.length;
        min = null;
        Map<String, Integer> namesIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            namesIdx.put(names[i], i);
        }
        int[] target = new int[len];
        for (int i = 0; i < len; i++) {
            target[i] = namesIdx.getOrDefault(targetPath[i], -1);
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            int from = road[0], to = road[1];
            if (from == to) continue;
            graph.computeIfAbsent(from, val -> new HashSet<>()).add(to);
            graph.computeIfAbsent(to, val -> new HashSet<>()).add(from);
        }
        Path[][] dp = new Path[n][len + 1];
        for (int i = 0; i < n; i++) {
            Path cur = dfs(0, i, target, graph, dp);
            if (min == null || min.cost > cur.cost) {
                min = cur;
            }
        }
        System.out.println("min = " + min);
        return min.path;
    }

    private static Path dfs(int targetIdx, int curCity, int[] target, Map<Integer, Set<Integer>> graph, Path[][] dp) {
        if (targetIdx == target.length) return new Path(0, new ArrayList<>());
        if (dp[curCity][targetIdx] != null) return dp[curCity][targetIdx];
        Path cur = new Path(Integer.MAX_VALUE, new ArrayList<>());
        cur.path.add(curCity);
        cur.cost = curCity == target[targetIdx] ? 0 : 1;
        Path minPath = null;
//        Loop through all the edges of the current targetIdx, perform a dfs and get the min edit distance.
        for (int dep : graph.getOrDefault(curCity, new HashSet<>())) {
            Path next = dfs(targetIdx + 1, dep, target, graph, dp);
            if (minPath == null || next.cost < minPath.cost) minPath = next;
        }
//        Add the minPath to the current path.
        cur.cost += minPath.cost;
        cur.path.addAll(minPath.path);
//        System.out.println("Result at index " + targetIdx + " is : " + cur);
        return dp[curCity][targetIdx] = cur;
    }

    public static List<Integer> mostSimilar_correct(int n, int[][] roads, String[] names, String[] targetPath) {

        tp = targetPath;
        dp = new Path[n][tp.length];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], new Path(Integer.MAX_VALUE, null));
        }
        graph = new LinkedList[n];

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];

            if (graph[u] == null) graph[u] = new LinkedList();
            if (graph[v] == null) graph[v] = new LinkedList();

            graph[u].add(v);
            graph[v].add(u);
        }

        Path minPath = null;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {

            Path path = getMinEditDistancePath(i, 0);
            if (path.cost < min) {
                min = path.cost;
                minPath = path;
            }
        }
        return minPath.path;
    }

    public static Path getMinEditDistancePath(int u, int index) {

        if (index == tp.length) return new Path(0, new LinkedList());
        if (dp[u][index].path != null) return dp[u][index];

        String tcity = tp[index];
        String pcity = names[u];

        Path p = new Path(Integer.MAX_VALUE, new LinkedList());
        p.path.add(u);
        p.cost = (pcity.equals(tcity)) ? 0 : 1;


        // loop for all edges of u to find min edit distance to node at index
        ListIterator<Integer> ite = graph[u].listIterator();
        Path minPath = null;
        while (ite.hasNext()) {
            int v = ite.next();
            Path p1 = getMinEditDistancePath(v, index + 1);
            if (minPath == null) minPath = p1;
            else if (p1.cost < minPath.cost) {
                minPath = p1;
            }
        }

        p.path.addAll(minPath.path);
        p.cost += minPath.cost;
        dp[u][index] = p;
        return dp[u][index];
    }

    static class Path {
        int cost;
        List<Integer> path;

        public Path(int cost, List<Integer> path) {
            this.cost = cost;
            this.path = path;
        }

        @Override
        public String toString() {
            return "Path{" +
                    "distance=" + cost +
                    ", path=" + path +
                    "}";
        }
    }
}
