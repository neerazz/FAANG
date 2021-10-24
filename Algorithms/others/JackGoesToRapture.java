import java.util.*;

/*
https://www.hackerrank.com/challenges/jack-goes-to-rapture/forum
 */
class Path implements Comparable<Path> {

    int edgeWeight;
    int endNode;

    Path(int endNode, int edgeWeight) {
        this.edgeWeight = edgeWeight;
        this.endNode = endNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Path path = (Path) o;
        return edgeWeight == path.edgeWeight &&
                endNode == path.endNode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(edgeWeight, endNode);
    }

    @Override
    public int compareTo(Path other) {
        return this.edgeWeight - other.edgeWeight;
    }
}

public class JackGoesToRapture {
    public static void main(String[] args) {
        getCost(5, Arrays.asList(1, 3, 1, 4, 2), Arrays.asList(2, 5, 4, 5, 3), Arrays.asList(60, 70, 120, 150, 80));
        System.out.println("should be [80]");
        getCost(5, Arrays.asList(1, 2, 3, 4, 1, 3), Arrays.asList(2, 3, 4, 5, 3, 5), Arrays.asList(30, 50, 70, 90, 70, 85));
        System.out.println("should be [85]");
    }

    public static void getCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        // Print your answer within the function and return nothing
        Map<Integer, List<Path>> connections = new HashMap<>();
        for (int i = 0; i < gNodes; i++) {
            int startNode = gFrom.get(i), endNode = gTo.get(i), weight = gWeight.get(i);
            List<Path> forwardConnectedNodes = connections.getOrDefault(startNode, new ArrayList<>());
            forwardConnectedNodes.add(new Path(endNode, weight));
            connections.put(startNode, forwardConnectedNodes);

            List<Path> backwardConnectedNodes = connections.getOrDefault(endNode, new ArrayList<>());
            backwardConnectedNodes.add(new Path(startNode, weight));
            connections.put(endNode, backwardConnectedNodes);
        }
        getCost(connections, gNodes);
    }

    public static void getCost(Map<Integer, List<Path>> connections, int numberOfNodes) {
        PriorityQueue<Path> pending = new PriorityQueue<>();
        Set<Path> visited = new HashSet<>();
        // No Need to consider paths with higher value, ignore all such paths.
        Map<Integer, Integer> minSoFarForEdge = new HashMap<>();
        pending.add(new Path(1, 0));
        visited.add(new Path(1, 0));
        int minWeight = Integer.MAX_VALUE;
        while (!pending.isEmpty()) {
            Path current = pending.poll();
            if (current.endNode == numberOfNodes) {
                minWeight = Math.min(minWeight, current.edgeWeight);
                break;
            }
            for (Path connection : connections.getOrDefault(current.endNode, new ArrayList<>())) {
                Path connectionWithMaxWeight = new Path(connection.endNode,
                        Math.max(current.edgeWeight, connection.edgeWeight));
                if (!visited.contains(connectionWithMaxWeight)
                        && connectionWithMaxWeight.edgeWeight < minSoFarForEdge
                        .getOrDefault(connection.endNode, Integer.MAX_VALUE)) {
                    minSoFarForEdge
                            .put(connection.endNode, Math.min(connectionWithMaxWeight.edgeWeight, minSoFarForEdge
                                    .getOrDefault(connection.endNode, Integer.MAX_VALUE)));
                    visited.add(connectionWithMaxWeight);
                    pending.add(connectionWithMaxWeight);
                }
            }
        }
        System.out.println(minWeight == Integer.MAX_VALUE ? "NO PATH EXISTS" : minWeight);
    }
}
