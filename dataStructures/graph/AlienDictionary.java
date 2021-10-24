import java.util.*;

/*
https://leetcode.com/problems/alien-dictionary/#
 */
public class AlienDictionary {
    public static void main(String[] args) {
        System.out.println("******************************* Solution 1 ****************************");
//        System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
//        System.out.println(alienOrder(new String[]{"z", "x"}));
//        System.out.println(alienOrder(new String[]{"z", "x", "z"}));
//        System.out.println(alienOrder(new String[]{"za", "zb", "ca", "cb"}));
        System.out.println(alienOrder(new String[]{"abc", "ab"}));

        System.out.println("******************************* Solution 2 ****************************");
//        System.out.println(alienOrder_rev1(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
//        System.out.println(alienOrder_rev1(new String[]{"z", "x"}));
//        System.out.println(alienOrder_rev1(new String[]{"z", "x", "z"}));
//        System.out.println(alienOrder_rev1(new String[]{"za", "zb", "ca", "cb"}));
        System.out.println(alienOrder_rev1(new String[]{"abc", "ab"}));
    }

    public static String alienOrder_rev1(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        int[] counts = new int[26];
//        Build char dependency with in a word.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }
//        Build char dependency between other words.
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1], word2 = words[i];
            int len1 = word1.length(), len2 = word2.length();
//            Check that word2 is not a prefix of word1.
            if (len1 > len2 && word1.startsWith(word2)) return "";
            int len = Math.min(len1, len2);
            for (int j = 0; j < len; j++) {
                char first = word1.charAt(j), second = word2.charAt(j);
                if (first == second) continue;
                graph.get(first).add(second);
                counts[second - 'a']++;
                break;
            }
        }

        System.out.println("graph = " + graph);

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char cur : graph.keySet()) {
            if (counts[cur - 'a'] == 0) {
                queue.add(cur);
            }
        }
        while (!queue.isEmpty()) {
            char poll = queue.poll();
            sb.append(poll);
            for (char dep : graph.get(poll)) {
                counts[dep - 'a']--;
                if (counts[dep - 'a'] == 0) {
                    queue.add(dep);
                }
            }
        }
        if (sb.length() == graph.size()) return sb.toString();
        return "";
    }

    public static String alienOrder(String[] words) {
        // Step 0: Create data structures and find all unique letters.
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            // Find the first non match and insert the corresponding relation.
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        System.out.println("adjList = " + adjList);

        // Step 2: Breadth-first search.
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : counts.keySet()) {
            if (counts.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.remove();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }

        if (sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }
}
