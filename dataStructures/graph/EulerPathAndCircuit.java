import java.util.*;

/**
 * Created on:  Oct 09, 2020
 * Questions:
 */

public class EulerPathAndCircuit {

    public static void main(String[] args) {

    }

    private static List<Integer> getEulerPath(int[][] paths) {
        int nodes = paths.length, edgeCount = 0;
        int[] in = new int[nodes], out = new int[nodes];
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int[] path : paths) {
//            0: from, 1 : to
            out[path[0]]++;
            in[path[1]]++;
            edgeCount++;
            map.computeIfAbsent(path[0], val -> new LinkedList<>()).add(path[1]);
        }
        LinkedList<Integer> result = new LinkedList<>();
        if (hasEulerPath(in, out)) {
//        Validate of the path exists. Only two vertex can have odd degree, it is more then two then it is not possible.
//        The node with odd indegree can only be the starting point.
            int start = getStartNode(in, out);
            dfs(start, result, map);
            // Make sure all edges of the graph were traversed. It could be the
            // case that the graph is disconnected in which case return null.
            if (result.size() != edgeCount + 1) return new LinkedList<>();
        }
        return result;
    }

    private static void dfs(int start, LinkedList<Integer> result, Map<Integer, Queue<Integer>> map) {
        Queue<Integer> deps = map.getOrDefault(start, new LinkedList<>());
        while (!deps.isEmpty()) {
            dfs(deps.poll(), result, map);
        }
        result.addFirst(start);
    }

    private static int getStartNode(int[] in, int[] out) {
        int start = 0;
        for (int i = 0; i < in.length; i++) {
//            Will be the node that have one extra out bound in case of out[i] - in[i] = 1
            if (out[i] - in[i] == 1) return i;
//            	Else the node that has atleast one out node will be the possible candidate.
            if (out[i] > 0) start = i;
        }
        return start;
    }

    private static boolean hasEulerPath(int[] in, int[] out) {
        int start = 0, end = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] - out[i] > 1 || out[i] - in[i] > 1) return false;
            else if (out[i] - in[i] == 1) start++;
            else if (in[i] - out[i] == 1) end++;
        }
        return (start == 1 && end == 1) || (start == 0 && end == 0);
    }
}
