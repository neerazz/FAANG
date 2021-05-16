package weekly.weekly187;
/*
    Created on:  May 02, 2020
 */

import java.util.*;

/**
 * Questions:
 */
public class DestinationCity {
    public static void main(String[] args) {
        System.out.println(destCity(Arrays.asList(
                Arrays.asList("London", "New York"),
                Arrays.asList("New York", "Lima"),
                Arrays.asList("Lima", "Sao Paulo")
        )));
    }

    public static String destCity(List<List<String>> paths) {
        Map<String, Graph> map = new HashMap<>();
        for (List<String> path : paths) {
            String source = path.get(0), destination = path.get(1);
            Graph srcG = map.getOrDefault(source, new Graph(source, 0));
            Graph destG = map.getOrDefault(destination, new Graph(destination, 0));
            srcG.out++;
            srcG.dep.add(destG);
            map.put(source, srcG);
            map.put(destination, destG);
        }
        for (Graph grp : map.values()) {
            if (grp.out == 0) return grp.val;
        }
        return "";
    }

    static class Graph {
        String val;
        int out;
        List<Graph> dep;

        public Graph(String val, int out) {
            this.val = val;
            this.out = out;
            dep = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "val='" + val + '\'' +
                    ", out=" + out +
                    '}';
        }
    }
}
