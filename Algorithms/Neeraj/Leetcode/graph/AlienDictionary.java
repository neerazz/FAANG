package graph;

import java.util.*;

/*
https://leetcode.com/problems/alien-dictionary/#
 */
public class AlienDictionary {
    public static void main(String[] args) {
        System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println("=========================================================");
        System.out.println(alienOrder(new String[]{"z", "x"}));
        System.out.println("=========================================================");
        System.out.println(alienOrder(new String[]{"z", "x", "z"}));
    }

    public static String alienOrder(String[] words) {
        if (words.length == 0) return "";
        HashMap<Character, Graph> graphHashMap = new HashMap<>();
        List<Graph> graphs = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            graphs.add(createGraph(words[i].toCharArray(), graphHashMap));
        }
        HashSet<Character> visited = new HashSet<>();
        Stack<Character> characterStack = new Stack<>();
        for (Graph g : graphs) {
            if (!visited.contains(g.aChar))
                performTopologicalSort(g, visited, characterStack);
        }
        StringBuilder sb = new StringBuilder();
        while (!characterStack.isEmpty()) {
            sb.append(characterStack.pop());
        }
        return sb.toString();
    }

    private static void performTopologicalSort(Graph graph, HashSet<Character> visited, Stack<Character> characterStack) {
        if (graph == null) return;
        for (Graph g : graph.neighbours) {
            if (g != null) {
                if (!visited.contains(g.aChar)) {
                    visited.add(g.aChar);
                    performTopologicalSort(g, visited, characterStack);
                    characterStack.add(g.aChar);
                }
            }
        }
        if (!visited.contains(graph.aChar)) {
            characterStack.add(graph.aChar);
            visited.add(graph.aChar);
        }
    }

    private static Graph createGraph(char[] word, HashMap<Character, Graph> graphHashMap) {
        if (word.length == 0) return null;
        int index = 0;
        Graph graph;
        char first = word[index++];
        if (graphHashMap.containsKey(first)) {
            graph = graphHashMap.get(first);
        } else {
            graph = new Graph(first, new HashSet<>());
            graphHashMap.put(first, graph);
        }
        graph.neighbours.add(createGraph(Arrays.copyOfRange(word, index, word.length), graphHashMap));
        return graph;
    }
}

class Graph {
    char aChar;
    HashSet<Graph> neighbours;

    public Graph(char aChar, HashSet<Graph> neighbours) {
        this.aChar = aChar;
        this.neighbours = neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return aChar == graph.aChar;
    }
}