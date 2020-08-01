import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Jul 23, 2020
 * Questions: https://leetcode.com/problems/accounts-merge/
 */
public class AccountsMerge {
    public static void main(String[] args) {
        System.out.println("Actual   : " +
                accountsMerge(Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")))
                + "\nExpected : [[\"John\", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  [\"John\", \"johnnybravo@mail.com\"], [\"Mary\", \"mary@mail.com\"]]");
        System.out.println("Actual   : " +
                accountsMerge(Arrays.asList(
                Arrays.asList("David", "David0@m.co", "David1@m.co"),
                Arrays.asList("David", "David3@m.co", "David4@m.co"),
                Arrays.asList("David", "David4@m.co", "David5@m.co"),
                Arrays.asList("David", "David2@m.co", "David3@m.co"),
                Arrays.asList("David", "David1@m.co", "David2@m.co")))
                + "\nExpected : [[\"David\",\"David0@m.co\",\"David1@m.co\",\"David2@m.co\",\"David3@m.co\",\"David4@m.co\",\"David5@m.co\"]]");
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

    public static List<List<String>> accountsMerge_wrong(List<List<String>> accounts) {
        Map<String, Integer> emailMap = new HashMap<>();
        Map<Integer, String> nameMap = new HashMap<>();
        List<List<String>> emails = new ArrayList<>();
        Map<Integer, Set<Integer>> accountsMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            nameMap.put(i, account.get(0));
            List<String> curEmails = new ArrayList<>();
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailMap.containsKey(email)) {
                    Integer linked = emailMap.get(email);
                    accountsMap.computeIfAbsent(i, val -> new HashSet<>()).add(linked);
                    accountsMap.computeIfAbsent(linked, val -> new HashSet<>()).add(i);
                } else {
                    emailMap.put(email, i);
                }
                curEmails.add(email);
            }
            emails.add(curEmails);
        }
        System.out.println(accountsMap);
//        Relink the accounts.
        Map<Integer, Integer> reMappingAccounts = new HashMap<>();
        for (int i = accounts.size() - 1; i >= 0; i--) {
            if (accountsMap.containsKey(i)) {
                reLinkAccounts(accountsMap, reMappingAccounts, i);
            }
        }
        Map<Integer, Set<String>> finalMap = new HashMap<>();
        for (int i = accounts.size() - 1; i >= 0; i--) {
            finalMap.computeIfAbsent(reMappingAccounts.getOrDefault(i, i), val -> new HashSet<>()).addAll(emails.get(i));
        }
        System.out.println(reMappingAccounts);
        List<List<String>> op = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : finalMap.entrySet()) {
            List<String> current = new ArrayList<>();
            current.add(nameMap.get(entry.getKey()));
            current.addAll(entry.getValue().stream().sorted().collect(Collectors.toList()));
            op.add(current);
        }
        return op;
    }

    private static int reLinkAccounts(Map<Integer, Set<Integer>> accountsMap, Map<Integer, Integer> finalMap, int key) {
        if (finalMap.containsKey(key)) return finalMap.get(key);
        int min = key;
        finalMap.put(key, min);
        for (Integer dep : accountsMap.getOrDefault(key, Collections.emptySet())) {
            min = Math.min(reLinkAccounts(accountsMap, finalMap, dep), min);
        }
        finalMap.put(key, min);
        return min;
    }
}
