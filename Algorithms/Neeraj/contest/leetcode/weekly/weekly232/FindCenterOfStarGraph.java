package weekly.weekly232;

import java.util.*;

/**
 * Created on:  Mar 13, 2021
 * Questions:
 */

public class FindCenterOfStarGraph {

    public static void main(String[] args) {

    }
    public int findCenter(int[][] edges) {
        int nodes = edges.length;
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int[] edge: edges){
            int from = edge[0], to = edge[1];
            graph.computeIfAbsent(from, val -> new HashSet<>()).add(to);
            graph.computeIfAbsent(to, val -> new HashSet<>()).add(from);
        }
        for(int key: graph.keySet()){
            if(graph.get(key).size() == nodes) return key;
        }
        return -1;
    }
}
