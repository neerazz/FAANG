package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TimedExecutor;

import java.util.ArrayList;
import java.util.List;

public class DeadlockDetection {

    public static boolean isDeadlocked(List<GraphVertex> graph) {
        for (GraphVertex vertex : graph) {
            if (vertex.visitedFlag == 0 & haveCycle(vertex)) {
                return true;
            }
        }
        return false;
    }

    private static boolean haveCycle(GraphVertex vertex) {
//        Visiting a vertex with flag -1, means it was visited and there is a cycle.
        if (vertex.visitedFlag == -1) return true;
        vertex.visitedFlag = -1;
        for (GraphVertex dep : vertex.edges) {
//            Do a dfs if it is visited once.
            if (dep.visitedFlag != 1 && haveCycle(dep)) {
                return true;
            }
        }
        vertex.visitedFlag = 1;
        return false;
    }

    @EpiTest(testDataFile = "deadlock_detection.tsv")
    public static boolean isDeadlockedWrapper(TimedExecutor executor,
                                              int numNodes, List<Edge> edges)
            throws Exception {
        if (numNodes <= 0) {
            throw new RuntimeException("Invalid numNodes value");
        }
        List<GraphVertex> graph = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            graph.add(new GraphVertex());
        }
        for (Edge e : edges) {
            if (e.from < 0 || e.from >= numNodes || e.to < 0 || e.to >= numNodes) {
                throw new RuntimeException("Invalid vertex index");
            }
            graph.get(e.from).edges.add(graph.get(e.to));
        }

        return executor.run(() -> isDeadlocked(graph));
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "DeadlockDetection.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }

    public static class GraphVertex {
        public List<GraphVertex> edges;
        int visitedFlag;

        public GraphVertex() {
            visitedFlag = 0;
            edges = new ArrayList<>();
        }
    }

    @EpiUserType(ctorParams = {int.class, int.class})
    public static class Edge {
        public int from;
        public int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
