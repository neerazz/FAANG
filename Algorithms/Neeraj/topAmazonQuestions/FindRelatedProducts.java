import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 16, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-find-related-books
 */

public class FindRelatedProducts {

    public static void main(String[] args) {
        System.out.println(findLargestGroup(Arrays.asList(
                Arrays.asList("p1", "p2"),
                Arrays.asList("p3", "p2"),
                Arrays.asList("p5", "p6")
        )));
    }

    public static List<String> findLargestGroup(List<List<String>> items) {
        Map<String, Integer> itemMap = new HashMap<>();
        Map<Integer, LinkedHashSet<Integer>> orderMap = new HashMap<>();
//        Build the graph.
        for (int i = 0; i < items.size(); i++) {
            List<String> order = items.get(i);
            orderMap.putIfAbsent(i, new LinkedHashSet<>());
            for (String item : order) {
                if (itemMap.containsKey(item)) {
                    Integer otherIdx = itemMap.get(item);
                    orderMap.get(i).add(otherIdx);
                    orderMap.get(otherIdx).add(i);
                }
                itemMap.put(item, i);
            }
        }
        LinkedHashSet<String> result = new LinkedHashSet<>();
        boolean[] visited = new boolean[items.size()];
        for (int i = 0; i < items.size(); i++) {
            if (!visited[i]) {
                LinkedHashSet<String> cur = dfs(i, items, itemMap, orderMap, visited);
                if (cur.size() > result.size()) {
                    result = cur;
                }
            }
        }
        return new ArrayList<>(result);
    }

    private static LinkedHashSet<String> dfs(int cur, List<List<String>> items, Map<String, Integer> itemMap, Map<Integer, LinkedHashSet<Integer>> orderMap, boolean[] visited) {
        visited[cur] = true;
        LinkedHashSet<String> curRelation = new LinkedHashSet<>(items.get(cur));
        for (int dep : orderMap.getOrDefault(cur, new LinkedHashSet<>())) {
            if (visited[dep]) continue;
            curRelation.addAll(dfs(dep, items, itemMap, orderMap, visited));
        }
        return curRelation;
    }
}
