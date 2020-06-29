import java.util.*;

/**
 * Created on:  Jun 28, 2020
 * Questions:
 */
public class ReconstructItinerary {
    public static void main(String[] args) {
        System.out.println("******************************** Solution 1 *********************************");
        System.out.println(findItinerary(Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO"))));
        System.out.println(findItinerary(Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO"))));
        System.out.println(findItinerary(Arrays.asList(
                Arrays.asList("EZE", "AXA"),
                Arrays.asList("TIA", "ANU"),
                Arrays.asList("ANU", "JFK"),
                Arrays.asList("JFK", "ANU"),
                Arrays.asList("ANU", "EZE"),
                Arrays.asList("TIA", "ANU"),
                Arrays.asList("AXA", "TIA"),
                Arrays.asList("TIA", "JFK"),
                Arrays.asList("ANU", "TIA"),
                Arrays.asList("JFK", "TIA"))));
        System.out.println("******************************** Solution 2 *********************************");
        System.out.println(findItinerary_optimal(Arrays.asList(
                Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"),
                Arrays.asList("SFO", "SJC"),
                Arrays.asList("LHR", "SFO"))));
        System.out.println(findItinerary_optimal(Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO"))));
        System.out.println(findItinerary_optimal(Arrays.asList(
                Arrays.asList("EZE", "AXA"),
                Arrays.asList("TIA", "ANU"),
                Arrays.asList("ANU", "JFK"),
                Arrays.asList("JFK", "ANU"),
                Arrays.asList("ANU", "EZE"),
                Arrays.asList("TIA", "ANU"),
                Arrays.asList("AXA", "TIA"),
                Arrays.asList("TIA", "JFK"),
                Arrays.asList("ANU", "TIA"),
                Arrays.asList("JFK", "TIA"))));
        System.out.println(findItinerary_optimal(
                Arrays.asList(Arrays.asList("AXA", "EZE"), Arrays.asList("EZE", "AUA"), Arrays.asList("ADL", "JFK"), Arrays.asList("ADL", "TIA"), Arrays.asList("AUA", "AXA"), Arrays.asList("EZE", "TIA"), Arrays.asList("EZE", "TIA"), Arrays.asList("AXA", "EZE"), Arrays.asList("EZE", "ADL"), Arrays.asList("ANU", "EZE"), Arrays.asList("TIA", "EZE"), Arrays.asList("JFK", "ADL"), Arrays.asList("AUA", "JFK"), Arrays.asList("JFK", "EZE"), Arrays.asList("EZE", "ANU"), Arrays.asList("ADL", "AUA"), Arrays.asList("ANU", "AXA"), Arrays.asList("AXA", "ADL"), Arrays.asList("AUA", "JFK"), Arrays.asList("EZE", "ADL"), Arrays.asList("ANU", "TIA"), Arrays.asList("AUA", "JFK"), Arrays.asList("TIA", "JFK"), Arrays.asList("EZE", "AUA"), Arrays.asList("AXA", "EZE"), Arrays.asList("AUA", "ANU"), Arrays.asList("ADL", "AXA"), Arrays.asList("EZE", "ADL"), Arrays.asList("AUA", "ANU"), Arrays.asList("AXA", "EZE"), Arrays.asList("TIA", "AUA"), Arrays.asList("AXA", "EZE"), Arrays.asList("AUA", "SYD"), Arrays.asList("ADL", "JFK"), Arrays.asList("EZE", "AUA"), Arrays.asList("ADL", "ANU"), Arrays.asList("AUA", "TIA"), Arrays.asList("ADL", "EZE"), Arrays.asList("TIA", "JFK"), Arrays.asList("AXA", "ANU"), Arrays.asList("JFK", "AXA"), Arrays.asList("JFK", "ADL"), Arrays.asList("ADL", "EZE"), Arrays.asList("AXA", "TIA"), Arrays.asList("JFK", "AUA"), Arrays.asList("ADL", "EZE"), Arrays.asList("JFK", "ADL"), Arrays.asList("ADL", "AXA"), Arrays.asList("TIA", "AUA"), Arrays.asList("AXA", "JFK"), Arrays.asList("ADL", "AUA"), Arrays.asList("TIA", "JFK"), Arrays.asList("JFK", "ADL"), Arrays.asList("JFK", "ADL"), Arrays.asList("ANU", "AXA"), Arrays.asList("TIA", "AXA"), Arrays.asList("EZE", "JFK"), Arrays.asList("EZE", "AXA"), Arrays.asList("ADL", "TIA"), Arrays.asList("JFK", "AUA"), Arrays.asList("TIA", "EZE"), Arrays.asList("EZE", "ADL"), Arrays.asList("JFK", "ANU"), Arrays.asList("TIA", "AUA"), Arrays.asList("EZE", "ADL"), Arrays.asList("ADL", "JFK"), Arrays.asList("ANU", "AXA"), Arrays.asList("AUA", "AXA"), Arrays.asList("ANU", "EZE"), Arrays.asList("ADL", "AXA"), Arrays.asList("ANU", "AXA"), Arrays.asList("TIA", "ADL"), Arrays.asList("JFK", "ADL"), Arrays.asList("JFK", "TIA"), Arrays.asList("AUA", "ADL"), Arrays.asList("AUA", "TIA"), Arrays.asList("TIA", "JFK"), Arrays.asList("EZE", "JFK"), Arrays.asList("AUA", "ADL"), Arrays.asList("ADL", "AUA"), Arrays.asList("EZE", "ANU"), Arrays.asList("ADL", "ANU"), Arrays.asList("AUA", "AXA"), Arrays.asList("AXA", "TIA"), Arrays.asList("AXA", "TIA"), Arrays.asList("ADL", "AXA"), Arrays.asList("EZE", "AXA"), Arrays.asList("AXA", "JFK"), Arrays.asList("JFK", "AUA"), Arrays.asList("ANU", "ADL"), Arrays.asList("AXA", "TIA"), Arrays.asList("ANU", "AUA"), Arrays.asList("JFK", "EZE"), Arrays.asList("AXA", "ADL"), Arrays.asList("TIA", "EZE"), Arrays.asList("JFK", "AXA"), Arrays.asList("AXA", "ADL"), Arrays.asList("EZE", "AUA"), Arrays.asList("AXA", "ANU"), Arrays.asList("ADL", "EZE"), Arrays.asList("AUA", "EZE"))
        ));
    }

    static LinkedList<String> result;
    static Map<String, PriorityQueue<String>> graph;

    public static List<String> findItinerary_optimal(List<List<String>> tickets) {
        result = new LinkedList<>();
        graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), val -> new PriorityQueue<>()).add(ticket.get(1));
        }
        dfs("JFK");
        return result;
    }

    private static void dfs(String cur) {
        PriorityQueue<String> queue = graph.getOrDefault(cur, new PriorityQueue<>());
        while (!queue.isEmpty()) {
            dfs(queue.poll());
        }
        result.addFirst(cur);
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        result = new LinkedList<>();
        Map<String, Integer> visited = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> ticketCount = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), val -> new ArrayList<>()).add(ticket.get(1));
            String key = ticket.get(0) + "-" + ticket.get(1);
            ticketCount.put(key, ticketCount.getOrDefault(key, 0) + 1);
        }
        dfs(map, visited, new LinkedList<>(), "JFK", ticketCount);
        return result;
    }

    private static void dfs(Map<String, List<String>> map, Map<String, Integer> visited, LinkedList<String> soFar, String from, Map<String, Integer> ticketCount) {
        if (visited.size() == ticketCount.size() && visited.equals(ticketCount)) {
            LinkedList<String> list = new LinkedList<>(soFar);
            list.add(from);
            result = getSmallest(list, result);
        }
        soFar.add(from);
        for (String to : map.getOrDefault(from, new ArrayList<>())) {
            String key = from + "-" + to;
            if (visited.getOrDefault(key, 0) < ticketCount.get(key)) {
                int count = visited.getOrDefault(key, 0);
                visited.put(key, count + 1);
                dfs(map, visited, soFar, to, ticketCount);
                visited.put(key, count);
            }
        }
        soFar.removeLast();
    }

    private static LinkedList<String> getSmallest(LinkedList<String> l1, LinkedList<String> l2) {
//        System.out.println("Comparing : l1 = " + l1 + ", l2 = " + l2);
        if (l2.isEmpty()) return l1;
        if (l1.isEmpty()) return l2;
        if (l1.size() != l2.size()) return null;
        for (int i = 0; i < l1.size(); i++) {
            int compareTo = l1.get(i).compareTo(l2.get(i));
            if (compareTo == 0) continue;
            if (compareTo < 0) return l1;
            else return l2;
        }
        return l1;
    }
}
