import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created on:  Jul 27, 2020
 * Questions:
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        System.out.println("****************************************** Method 2 ****************************************");
        Graph_Method1 graphMethod1 = new Graph_Method1();
        graphMethod1.setGraph(new int[][]{{1, 2}, {3, 4}, {5, 6, 7}, {8, 9}, {}, {10, 11}, {}, {12, 13}, {}, {}, {}, {14, 15, 16}, {}, {}, {}, {}, {}});
        System.out.println(graphMethod1.getLowestCommonAncestor(1, 8) + "\t = 1");
        System.out.println(graphMethod1.getLowestCommonAncestor(13, 14) + "\t = 2");
        System.out.println(graphMethod1.getLowestCommonAncestor(9, 11) + "\t = 0");
        System.out.println(graphMethod1.getLowestCommonAncestor(2, 8) + "\t = 0");
        System.out.println(graphMethod1.getLowestCommonAncestor(5, 13) + "\t = 2");
        System.out.println(graphMethod1.getLowestCommonAncestor(5, 11) + "\t = 5");
        System.out.println(graphMethod1.getLowestCommonAncestor(9, 4) + "\t = 1");
        System.out.println(graphMethod1.getLowestCommonAncestor(7, 13) + "\t = 7");
        System.out.println(graphMethod1.getLowestCommonAncestor(7, 11) + "\t = 2");
        System.out.println(graphMethod1.getLowestCommonAncestor(7, 6) + "\t = 2");
        System.out.println(graphMethod1.getLowestCommonAncestor(7, 5) + "\t = 2");
        System.out.println(graphMethod1.getLowestCommonAncestor(15, 16) + "\t = 11");
        System.out.println(graphMethod1.getLowestCommonAncestor(15, 9) + "\t = 0");
        System.out.println(graphMethod1.getLowestCommonAncestor(15, 10) + "\t = 5");
        System.out.println("****************************************** Method 2 ****************************************");
        Graph_Method2 graph_method2 = new Graph_Method2();
        graph_method2.setGraph(new int[][]{{1, 2}, {3, 4}, {5, 6, 7}, {8, 9}, {}, {10, 11}, {}, {12, 13}, {}, {}, {}, {14, 15, 16}, {}, {}, {}, {}, {}});
        System.out.println(graph_method2.getLowestCommonAncestor(1, 8) + "\t = 1");
        System.out.println(graph_method2.getLowestCommonAncestor(13, 14) + "\t = 2");
        System.out.println(graph_method2.getLowestCommonAncestor(9, 11) + "\t = 0");
        System.out.println(graph_method2.getLowestCommonAncestor(2, 8) + "\t = 0");
        System.out.println(graph_method2.getLowestCommonAncestor(5, 13) + "\t = 2");
        System.out.println(graph_method2.getLowestCommonAncestor(5, 11) + "\t = 5");
        System.out.println(graph_method2.getLowestCommonAncestor(9, 4) + "\t = 1");
        System.out.println(graph_method2.getLowestCommonAncestor(7, 13) + "\t = 7");
        System.out.println(graph_method2.getLowestCommonAncestor(7, 11) + "\t = 2");
        System.out.println(graph_method2.getLowestCommonAncestor(7, 6) + "\t = 2");
        System.out.println(graph_method2.getLowestCommonAncestor(7, 5) + "\t = 2");
        System.out.println(graph_method2.getLowestCommonAncestor(15, 16) + "\t = 11");
        System.out.println(graph_method2.getLowestCommonAncestor(15, 9) + "\t = 0");
        System.out.println(graph_method2.getLowestCommonAncestor(15, 10) + "\t = 5");

        graph_method2.setGraph(new int[][]{{1, 5, 2}, {}, {3}, {}, {}, {4, 6}, {}});

    }

    //    https://www.hackerrank.com/topics/lowest-common-ancestor
    static class Graph_Method2 {
        Map<Integer, Integer> graph;
        int len;

        public void setGraph(int[][] con) {
            graph = new HashMap<>();
//            Traverse through the input and set the parent of each node.
            len = con.length;
            for (int i = 0; i < len; i++) {
                for (int dep : con[i]) {
                    graph.put(dep, i);
                }
            }
        }

        public int getLowestCommonAncestor(int a, int b) {
            boolean[] visited = new boolean[len];
//            Traverse the graph up wards from node a and keep marking as visited.
            while (graph.containsKey(a)) {
                visited[a] = true;
                a = graph.get(a);
            }
//            Traverse the second node and when you encounter the first visited that will be the ansister.
            while (graph.containsKey(b) && !visited[b]) {
                b = graph.get(b);
            }
            return b;
        }
    }

    static class Graph_Method1 {

        Map<Integer, Set<Integer>> graph;
        List<Integer> degrees;
        List<Integer> levels;
        Map<Integer, Integer> valIndex;
        int tourIndex;

        public void setGraph(int[][] con) {
            initialize();
            IntStream.range(0, con.length).forEach(i -> graph.put(i, new HashSet<>()));
            for (int i = 0; i < con.length; i++) {
                graph.get(i).addAll(Arrays.stream(con[i]).boxed().collect(Collectors.toSet()));
            }
            preCalculate(graph, 0, 0);
            System.out.println(Arrays.deepToString(con));
            System.out.println("degrees   = " + degrees);
            System.out.println("levels    = " + levels);
            System.out.println("valIndex  = " + valIndex);
        }

        private void preCalculate(Map<Integer, Set<Integer>> graph, int cur, int level) {
            visit(cur, level);
            for (int dep : graph.get(cur)) {
                preCalculate(graph, dep, level + 1);
                visit(cur, level);
            }
        }

        private void visit(int node, int level) {
            levels.add(level);
            degrees.add(node);
            valIndex.put(node, tourIndex++);
        }

        private void initialize() {
            tourIndex = 0;
            graph = new HashMap<>();
            valIndex = new HashMap<>();
            degrees = new ArrayList<>();
            levels = new ArrayList<>();
        }

        public int getLowestCommonAncestor(int a, int b) {
            int aI = valIndex.get(a), bI = valIndex.get(b);
            int start = Math.min(aI, bI), end = Math.max(aI, bI);
            int aL = levels.get(aI), bL = levels.get(bI), targetLevel = Math.min(aL, bL);
//            TODO this is giving wrong value, correct it.
            for (int i = start; i <= end; i++) {
                if (levels.get(i) == targetLevel) {
                    return degrees.get(i);
                }
            }
            return -1;
        }
    }
}
