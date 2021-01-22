import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 15, 2021
 * Questions: https://leetcode.com/discuss/interview-question/844979/amazon-online-assessment-question
 */

public class LargestItemAssociation {

    public static void main(String[] args) {
        System.out.println(largestItemAssociation(Arrays.asList(
                new PairString("Item1", "Item2"),
                new PairString("Item3", "Item4"),
                new PairString("Item4", "Item5")
        )));

        System.out.println(largestItemAssociation(Arrays.asList(
                new PairString("Item1", "Item2"),
                new PairString("Item3", "Item4"),
                new PairString("Item4", "Item5")
        )));

        System.out.println(largestItemAssociation(Arrays.asList(
                new PairString("Item1", "Item2"),
                new PairString("Item2", "Item8"),
                new PairString("Item2", "Item10"),
                new PairString("Item10", "Item12"),
                new PairString("Item10", "Item4"),
                new PairString("Item10", "Item3"),
                new PairString("Item3", "Item4"),
                new PairString("Item4", "Item5")
        )));
    }

    static List<String> largestItemAssociation(List<PairString> itemAssociation) {
        LinkedHashMap<String, LinkedHashSet<String>> map = new LinkedHashMap<>();
        for (PairString pairs : itemAssociation) {
            if (pairs.first.equals(pairs.second)) continue;
            map.computeIfAbsent(pairs.first, val -> new LinkedHashSet<>()).add(pairs.second);
            map.computeIfAbsent(pairs.second, val -> new LinkedHashSet<>()).add(pairs.first);
        }
        List<String> result = new ArrayList<>();
        for (String name : map.keySet()) {
            Set<String> visited = new HashSet<>();
            List<String> cur = dfs(name, map, visited);
            if (cur.size() > result.size()) {
                result = cur;
            }
        }
        return result;
    }

    private static LinkedList<String> dfs(String name, Map<String, LinkedHashSet<String>> map, Set<String> visited) {
        if (!visited.add(name)) return new LinkedList<>();
        LinkedList<String> cur = new LinkedList<>();
        for (String dep : map.get(name)) {
            LinkedList<String> next = dfs(dep, map, visited);
            if (next.size() > cur.size()) {
                cur = next;
            }
        }
        visited.remove(name);
        cur.addFirst(name);
        return cur;
    }
}

class PairString {
    String first;
    String second;

    PairString(String first, String second) {
        this.first = first;
        this.second = second;
    }
}