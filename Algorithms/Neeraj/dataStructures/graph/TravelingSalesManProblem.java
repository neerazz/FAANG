import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created on:  Nov 16, 2020
 * Questions: https://www.youtube.com/watch?v=-JjA4BLQyqE&list=PLrmLmBdmIlpu2f2g8ltqaaCZiq6GJvl1j&index=6
 */

public class TravelingSalesManProblem {

    static int INFINITY = 100000000;
    static int min;

    public static void main(String[] args) {
        int[][] distance = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};
        System.out.println("************************* Solution 1 *************************");
        System.out.println(minCost(distance) + " = 80");
        System.out.println("************************* Solution 2 *************************");
        System.out.println(minCost_backTracking(distance) + " = 80");
        int[][] distance1 = {{0, 12, 3, 9, 6, 1, 2},
                {12, 0, 6, 1, 8, 2, 10},
                {3, 6, 0, 6, 7, 11, 7},
                {9, 1, 6, 0, 9, 10, 3},
                {6, 8, 7, 9, 0, 1, 11},
                {1, 2, 11, 10, 1, 0, 12},
                {2, 10, 7, 3, 11, 12, 0}};
        System.out.println("************************* Solution 1 *************************");
        System.out.println(minCost(distance1) + " = 19");
        System.out.println("************************* Solution 2 *************************");
        System.out.println(minCost_backTracking(distance1) + " = 19");

        int[][] distance2 = {
                {0, 1, 15, 6},
                {2, 0, 7, 3},
                {9, 6, 0, 12},
                {10, 4, 8, 0}};
        System.out.println("************************* Solution 1 *************************");
        System.out.println(minCost(distance2) + " = 21");
        System.out.println("************************* Solution 2 *************************");
        System.out.println(minCost_backTracking(distance2) + " = 21");
    }

    public static int minCost(int[][] distance) {
//        DP to store the cost and the parents of each node.
        Map<Index, Integer> dp = new HashMap<>(), parent = new HashMap<>();
//        Considering 0 as starting, create the combination of all the sets.
        List<LinkedHashSet<Integer>> allSets = generateCombination(1, distance.length - 1);
        Collections.sort(allSets, Comparator.comparing(Set::size));
//        Loop through all the sets and get the distance traveling through the sets.
        for (Set<Integer> set : allSets) {
            for (int cur = 1; cur < distance.length; cur++) {
                if (set.contains(cur)) continue;
                Index index = new Index(cur, set);
//                Get the min cost to travel from 0 to cur, via the set (of nodes)
                int minCost = INFINITY, minPre = 0;
                for (int pre : set) {
                    int cost = distance[pre][cur] + getCost(set, pre, dp);
                    if (cost < minCost) {
                        minCost = cost;
                        minPre = pre;
                    }
                }
//                In case of empty set, just take the distance from current vertex
                if (set.isEmpty()) {
                    minCost = distance[0][cur];
                }
                dp.put(index, minCost);
                parent.put(index, minPre);
            }
        }
//        Now get the distance from 0 to min of all other nodes.
        int minCost = INFINITY, minPre = 0;
        Set<Integer> allNodes = IntStream.rangeClosed(1, distance.length - 1).boxed().collect(Collectors.toSet());
        for (int i = 1; i < distance.length; i++) {
            int cost = distance[i][0] + getCost(allNodes, i, dp);
            if (cost < minCost) {
                minCost = cost;
                minPre = i;
            }
        }
        dp.put(new Index(0, allNodes), minCost);
        parent.put(new Index(0, allNodes), minPre);
        List<Integer> path = getTravelPath(parent, distance.length);
        System.out.println("path = " + path);
        return minCost;
    }

    private static List<Integer> getTravelPath(Map<Index, Integer> parent, int totalVertices) {
        Set<Integer> nodes = IntStream.rangeClosed(0, totalVertices - 1).boxed().collect(Collectors.toSet());
        List<Integer> path = new ArrayList<>();
//        Starting from 0, get the pre node that have least value.
        Integer cur = 0;
        while (true) {
            path.add(cur);
            nodes.remove(cur);
            Index index = new Index(cur, nodes);
            cur = parent.get(index);
            if (cur == null) break;
        }
        return path;
    }

    private static int getCost(Set<Integer> set, int cur, Map<Index, Integer> dp) {
//        Get the cost from 0 to cur node, though the set.
        Set<Integer> temp = new HashSet<>(set);
        temp.remove(cur);
        int cost = dp.get(new Index(cur, temp));
        return cost;
    }

    private static List<LinkedHashSet<Integer>> generateCombination(int s, int e) {
        List<LinkedHashSet<Integer>> cur = new ArrayList<>();
        if (s == e) {
            cur.add(new LinkedHashSet<>());
            LinkedHashSet<Integer> single = new LinkedHashSet<>();
            single.add(s);
            cur.add(single);
        } else {
            List<LinkedHashSet<Integer>> next = generateCombination(s + 1, e);
            cur.addAll(next);
            for (Set<Integer> set : next) {
                LinkedHashSet<Integer> copySet = new LinkedHashSet<>();
                copySet.add(s);
                copySet.addAll(set);
                cur.add(copySet);
            }
        }
        return cur;
    }

    public static int minCost_backTracking(int[][] distance) {
        min = Integer.MAX_VALUE;
        int nodes = distance.length;
        boolean[] visited = new boolean[nodes];
        visited[0] = true;
        helper(distance, 0, visited, 1, 0);
        return min;
    }

    private static void helper(int[][] costs, int cur, boolean[] visited, int count, int cost) {
//        If reached the end and there is a link to the start then set the min value.
        if (count == costs.length && costs[cur][0] > 0) {
            min = Math.min(min, cost + costs[cur][0]);
        } else {
//            Loop through all the unvisited connected nodes.
            for (int i = 0; i < costs.length; i++) {
                if (!visited[i] && costs[cur][i] > 0) {
                    visited[i] = true;
                    helper(costs, i, visited, count + 1, cost + costs[cur][i]);
                    visited[i] = false;
                }
            }
        }
    }

    static class Index {
        int node;
        Set<Integer> set;

        public Index(final int node, final Set<Integer> set) {
            this.node = node;
            this.set = set;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            final Index index = (Index) o;
            return this.node == index.node &&
                    this.set.equals(index.set);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.node, this.set);
        }

        @Override
        public String toString() {
            return "Index{" +
                    "node=" + node +
                    ", set=" + set +
                    '}';
        }
    }
}
