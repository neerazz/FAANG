import java.util.*;

/**
 * Created on:  Jul 23, 2020
 * Questions: https://leetcode.com/problems/accounts-merge/
 */
public class AccountsMerge {
    public static void main(String[] args) {
        System.out.println("********************************* Solution 1 ***********************************");
        System.out.println("Actual   : " +
                accountsMerge(Arrays.asList(
                        Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                        Arrays.asList("John", "johnnybravo@mail.com"),
                        Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                        Arrays.asList("Mary", "mary@mail.com")))
                + "\nExpected : [[John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com], [John, johnnybravo@mail.com], [Mary, mary@mail.com]]");
        System.out.println("Actual   : " +
                accountsMerge(Arrays.asList(
                        Arrays.asList("David", "David0@m.co", "David1@m.co"),
                        Arrays.asList("David", "David3@m.co", "David4@m.co"),
                        Arrays.asList("David", "David4@m.co", "David5@m.co"),
                        Arrays.asList("David", "David2@m.co", "David3@m.co"),
                        Arrays.asList("David", "David1@m.co", "David2@m.co")))
                + "\nExpected : [[David, David0@m.co, David1@m.co, David2@m.co, David3@m.co, David4@m.co, David5@m.co]]");

        System.out.println("********************************* Solution 2 ***********************************");
        System.out.println("Actual   : " +
                accountsMerge_rev2(Arrays.asList(
                        Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                        Arrays.asList("John", "johnnybravo@mail.com"),
                        Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                        Arrays.asList("Mary", "mary@mail.com")))
                + "\nExpected : [[John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com], [John, johnnybravo@mail.com], [Mary, mary@mail.com]]");
        System.out.println("Actual   : " +
                accountsMerge_rev2(Arrays.asList(
                        Arrays.asList("David", "David0@m.co", "David1@m.co"),
                        Arrays.asList("David", "David3@m.co", "David4@m.co"),
                        Arrays.asList("David", "David4@m.co", "David5@m.co"),
                        Arrays.asList("David", "David2@m.co", "David3@m.co"),
                        Arrays.asList("David", "David1@m.co", "David2@m.co")))
                + "\nExpected : [[David, David0@m.co, David1@m.co, David2@m.co, David3@m.co, David4@m.co, David5@m.co]]");
    }

    public static List<List<String>> accountsMerge_rev2(List<List<String>> accounts) {
        Map<String, Integer> emailMap = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, String> nameMap = new HashMap<>();
        int size = accounts.size();
        for (int i = 0; i < size; i++) {
            List<String> emails = accounts.get(i);
            nameMap.put(i, emails.get(0));
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                if (emailMap.containsKey(email)) {
                    int pre = emailMap.get(email);
                    graph.computeIfAbsent(i, val -> new HashSet<>()).add(pre);
                    graph.computeIfAbsent(pre, val -> new HashSet<>()).add(i);
                }
                emailMap.put(email, i);
            }
        }
//        Perform a DFS and get all the linked emails.
        List<List<String>> op = new ArrayList<>();
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                LinkedList<String> values = new LinkedList<>(DFS(accounts, visited, i, graph));
                Collections.sort(values);
                values.addFirst(nameMap.get(i));
                op.add(values);
            }
        }
        return op;
    }

    private static Set<String> DFS(List<List<String>> accounts, boolean[] visited, int start, Map<Integer, Set<Integer>> graph) {
        Set<String> cur = new HashSet<>(accounts.get(start).subList(1, accounts.get(start).size()));
        visited[start] = true;
        for (int dep : graph.getOrDefault(start, new HashSet<>())) {
            if (!visited[dep]) {
                cur.addAll(DFS(accounts, visited, dep, graph));
            }
        }
        return cur;
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, String> nameMap = new HashMap<>();
        Map<String, Integer> emailMap = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int len = accounts.size();
        for (int i = 0; i < len; i++) {
            List<String> account = accounts.get(i);
            nameMap.put(i, account.get(0));
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailMap.containsKey(email)) {
                    int to = emailMap.get(email);
                    graph.computeIfAbsent(i, val -> new HashSet<>()).add(to);
                    graph.computeIfAbsent(to, val -> new HashSet<>()).add(i);
                }
                emailMap.put(email, i);
            }
        }
        boolean[] visited = new boolean[len];
        List<List<String>> op = new ArrayList<>();
//        Perform a dfs for each account.
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                Set<String> emails = new HashSet<>();
                dfs(i, accounts, graph, visited, emails);
                LinkedList<String> cur = new LinkedList<>(emails);
                Collections.sort(cur);
                cur.addFirst(nameMap.get(i));
                op.add(cur);
            }
        }
        return op;
    }

    private static void dfs(int start, List<List<String>> accounts, Map<Integer, Set<Integer>> graph, boolean[] visited, Set<String> emails) {
//        Add all the emails to the set and make recursive calls.
        emails.addAll(accounts.get(start).subList(1, accounts.get(start).size()));
        visited[start] = true;
        for (int dep : graph.getOrDefault(start, new HashSet<>())) {
            if (!visited[dep]) {
                dfs(dep, accounts, graph, visited, emails);
            }
        }
    }
}
