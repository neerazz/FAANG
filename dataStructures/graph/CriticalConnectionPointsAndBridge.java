import java.util.*;

/**
 * Created on:  Sep 06, 2020
 * Questions: https://www.hackerearth.com/practice/algorithms/graphs/articulation-points-and-bridges/tutorial/
 */
public class CriticalConnectionPointsAndBridge {
    static int dis;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int vertices = fr.nextInt(), edge = fr.nextInt();
        boolean[][] edges = new boolean[vertices][vertices];
        for (int i = 0; i < edge; i++) {
            int u = fr.nextInt(), v = fr.nextInt();
            edges[u][v] = edges[v][u] = true;
        }
        List<Integer> ap = getCriticalPoints(vertices, edges);
        List<String> bridges = getCriticalBridge(vertices, edges);
        System.out.println(ap.size());
        StringBuilder sb = new StringBuilder();
        ap.stream().sorted().forEach(val -> sb.append(val).append(" "));
        System.out.println(sb.toString().trim());
        Collections.sort(bridges);
        System.out.println(bridges.size());
        bridges.forEach(System.out::println);
    }

    public static List<String> getCriticalBridge(int n, boolean[][] edges) {
        dis = 0;
        int[] discovery = new int[n], lowest = new int[n];
        boolean[] visited = new boolean[n];
        Set<String> criticalBridge = new HashSet<>();
        getCriticalBridge(n, edges, discovery, lowest, visited, null, 0, criticalBridge);
        System.out.println("lowest = " + Arrays.toString(lowest));
        System.out.println("discovery = " + Arrays.toString(discovery));
        return new ArrayList<>(criticalBridge);
    }

    public static void getCriticalBridge(int n, boolean[][] edges, int[] discovery, int[] lowest, boolean[] visited, Integer parent, int cur, Set<String> criticalBridge) {
        discovery[cur] = lowest[cur] = dis++;
        visited[cur] = true;
//        Loop through all the dep nodes
        for (int dep = 0; dep < n; dep++) {
            if (edges[cur][dep]) {
                if (parent != null && parent == dep) continue;
                if (visited[dep]) lowest[cur] = Math.min(lowest[cur], discovery[dep]);
                else {
                    getCriticalBridge(n, edges, discovery, lowest, visited, cur, dep, criticalBridge);
                    lowest[cur] = Math.min(lowest[cur], lowest[dep]);
//                    If the dependent lowest point is greater than current discovery point, then it is a critical bridge.
                    if (lowest[dep] > discovery[cur]) criticalBridge.add(cur + " " + dep);
                }
            }
        }
    }

    private static List<Integer> getCriticalPoints(int n, boolean[][] edges) {
        dis = 0;
        int[] discovery = new int[n], lowest = new int[n];
        boolean[] visited = new boolean[n];
        Set<Integer> ap = new HashSet<>();
        getCriticalPoints(n, edges, discovery, lowest, visited, null, 0, ap);
        return new ArrayList<>(ap);
    }

    private static void getCriticalPoints(int n, boolean[][] edges, int[] discovery, int[] lowest, boolean[] visited, Integer parent, int cur, Set<Integer> ap) {
//        Set the discovery and lowest point of current node
        discovery[cur] = lowest[cur] = dis++;
        visited[cur] = true;
        int child = 0;
//        Loop through all the deps, excepted the once that are visited and the parent
        for (int dep = 0; dep < n; dep++) {
//            If there is an edge between current and dep node.
            if (edges[cur][dep]) {
                child++;
                if (parent != null && dep == parent) continue;
//                    If dependent is visited, then just check for the lowest value.
                if (visited[dep]) lowest[cur] = Math.min(lowest[cur], discovery[dep]);
                else {
                    getCriticalPoints(n, edges, discovery, lowest, visited, cur, dep, ap);
                    lowest[cur] = Math.min(lowest[cur], lowest[dep]);
//                Current node will be an ArticulationPoint if:
//                  If current is the starting node and there are many children.
//                  If the lowest point of the dep node is equal or greater then the discovery of the current node.
                    if (parent == null && child > 1) ap.add(cur);
                    if (parent != null && lowest[dep] >= discovery[cur]) ap.add(cur);
                }
            }
        }
    }
}
