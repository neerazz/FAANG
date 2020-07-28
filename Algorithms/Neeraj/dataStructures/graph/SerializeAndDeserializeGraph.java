import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created on:  Jul 27, 2020
 * Questions:
 */
public class SerializeAndDeserializeGraph {
    public static void main(String[] args) {
        System.out.println(serializeGraph(new int[][]{{1}, {2}, {6, 9}, {4, 5}, {}, {}, {7, 8}, {}, {}, {}}));
        System.out.println(serializeGraph(new int[][]{{4}, {}, {4}, {4}, {0, 2, 3}}));
        System.out.println(serializeGraph(new int[][]{{1, 5, 2}, {}, {3}, {}, {}, {4, 6}, {}}));
    }

    private static String serializeGraph(int[][] cons) {
        Map<Integer, TrieNode> graph = new HashMap<>();
        int len = cons.length;
        for (int i = 0; i < len; i++) {
            graph.putIfAbsent(i, new TrieNode(i));
            for (int dep : cons[i]) {
                TrieNode child = graph.getOrDefault(dep, new TrieNode(dep));
                graph.putIfAbsent(dep, child);
                child.child.add(graph.get(i));
                graph.get(i).child.add(child);
            }
        }
//        IntStream.range(0, cons.length).forEach(i -> graph.computeIfAbsent(i, val -> new HashSet<>()).addAll(Arrays.stream(cons[i]).boxed().collect(Collectors.toSet())));
        List<Integer> center = getCenter(graph, len);
        System.out.println("center = " + center);
//        Pick the first center and root the graph.
        TrieNode node = getRooted(graph, center.get(0), new boolean[len]);
        System.out.println("node = " + node);
        return encodeRotedGraph(node);
    }

    //    This works only for a directed graph.
    private static boolean isCyclicGraph(Map<Integer, TrieNode> graph, int n) {
        int[] indegree = new int[n];
        for (int cur : graph.keySet()) {
            for (TrieNode dep : graph.get(cur).child) {
                indegree[dep.val]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>(IntStream.range(0, n).filter(i -> indegree[i] == 0).boxed().collect(Collectors.toList()));
        int processed = queue.size();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (TrieNode dep : graph.get(queue.poll()).child) {
                if (--indegree[dep.val] == 0) {
                    level.add(dep.val);
                    processed++;
                }
            }
            queue.addAll(level);
        }
        return processed != n;
    }

    private static String encodeRotedGraph(TrieNode node) {
        if (node == null) return "";
        List<String> labels = new ArrayList<>();
        for (TrieNode dep : node.child) {
            labels.add(encodeRotedGraph(dep));
        }
        Collections.sort(labels);
        StringBuilder sb = new StringBuilder();
        for (String label : labels) {
            sb.append(label);
        }
        return "(" + node.val + sb.toString() + ")";
    }

    private static TrieNode getRooted(Map<Integer, TrieNode> graph, Integer center, boolean[] visited) {
        TrieNode node = new TrieNode(center);
        visited[center] = true;
        for (TrieNode dep : graph.get(center).child) {
            if (!visited[dep.val]) {
                node.child.add(getRooted(graph, dep.val, visited));
            }
        }
        return node;
    }

    private static List<Integer> getCenter(Map<Integer, TrieNode> graph, int n) {
        int[] outDegree = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int cur : graph.keySet()) {
            outDegree[cur] = graph.get(cur).child.size();
            if (outDegree[cur] <= 1) {
                list.add(cur);
                outDegree[cur] = 0;
            }
        }
        int processed = list.size();
        while (processed < n && !list.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int cur : list) {
                for (TrieNode dep : graph.get(cur).child) {
                    if (--outDegree[dep.val] == 1) {
                        level.add(dep.val);
                        processed++;
                    }
                }
            }
            list = level;
        }
        return list;
    }

    static class TrieNode {
        int val;
        Set<TrieNode> child;

        public TrieNode(int val) {
            this.val = val;
            this.child = new HashSet<>();
        }

        @Override
        public String toString() {
            return "val=" + val + "\t" + child;
        }
    }
}
