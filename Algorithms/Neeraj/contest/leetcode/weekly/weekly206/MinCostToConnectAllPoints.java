package weekly.weekly206;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created on:  Sep 12, 2020
 * Questions: https://leetcode.com/problems/min-cost-to-connect-all-points
 */
public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}) + " = 18");
        System.out.println(minCostConnectPoints(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}) + " = 4");
        System.out.println(minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}) + " = 20");
        System.out.println(minCostConnectPoints(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}) + " = 4000000");
        System.out.println(minCostConnectPoints(new int[][]{{0, 0}}) + " = 0");
        System.out.println(minCostConnectPoints(new int[][]{{-20, 14}, {-14, -11}, {16, -7}, {16, -5}, {2, 3}, {14, 20}, {-10, 9}, {9, 16}, {5, -16}, {16, -4}, {17, -6}, {11, -4}, {6, -16}, {-14, 14}, {-14, 8}, {-15, 10}, {-9, -4}}) + " = 136");

        System.out.println("*************************** Solution 2 *********************************");
        System.out.println(minCostConnectPoints_2(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}) + " = 18");
        System.out.println(minCostConnectPoints_2(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}}) + " = 4");
        System.out.println(minCostConnectPoints_2(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}) + " = 20");
        System.out.println(minCostConnectPoints_2(new int[][]{{-1000000, -1000000}, {1000000, 1000000}}) + " = 4000000");
        System.out.println(minCostConnectPoints_2(new int[][]{{0, 0}}) + " = 0");
        System.out.println(minCostConnectPoints_2(new int[][]{{-20, 14}, {-14, -11}, {16, -7}, {16, -5}, {2, 3}, {14, 20}, {-10, 9}, {9, 16}, {5, -16}, {16, -4}, {17, -6}, {11, -4}, {6, -16}, {-14, 14}, {-14, 8}, {-15, 10}, {-9, -4}}) + " = 136");
    }

    private static int distance(int[] from, int[] to) {
        return Math.abs(Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]));
    }

    public static int minCostConnectPoints_2(int[][] points) {
        int len = points.length, dist = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            visited[i] = true;
            int cur = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (visited[j]) continue;
                int curDist = distance(points[i], points[j]);
                cur = Math.min(cur, curDist);
            }
            dist += cur == Integer.MAX_VALUE ? 0 : cur;
        }
        return dist;
    }

    public static int minCostConnectPoints(int[][] points) {
        if (points.length < 2) return 0;
        Set<Node> nodes = new HashSet<>();
        for (int[] point : points) {
            nodes.add(new Node(point[0], point[1]));
        }
//        LinkedList<Node> pq = new LinkedList<>();
//        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        TreeSet<Node> pq = new TreeSet<>();
        pq.add(new Node(points[0][0], points[0][1], 0));
        Set<Node> visited = new HashSet<>();
        int dist = 0;
        while (visited.size() < nodes.size()) {
//            Collections.sort(pq);
//            Node poll = pq.poll();
            Node poll = pq.pollFirst();
            if (!visited.contains(poll)) {
                System.out.println("poll = " + poll + " dist =" + dist);
                dist += poll.dist;
                calculateDistance(poll, nodes, visited, pq);
            }
        }
        return dist;
    }

    private static void calculateDistance(Node cur, Set<Node> nodes, Set<Node> visited, Collection<Node> pq) {
        visited.add(cur);
        for (Node node : nodes) {
            if (!visited.contains(node)) {
                node.setDist(cur);
                pq.add(node);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = Integer.MAX_VALUE;
        }

        public void setDist(Node node) {
            dist = Math.min(dist, Math.abs(Math.abs(node.x - this.x) + Math.abs(node.y - this.y)));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            return y == node.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dist=" + dist +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
