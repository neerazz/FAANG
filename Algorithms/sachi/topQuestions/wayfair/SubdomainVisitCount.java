package topQuestions.wayfair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

    public static void main(String[] args) {
        List<String> sol = subdomainVisits(new String[]{"9001 discuss.leetcode.com"});
        System.out.println(sol);
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] sub = domain.split(" ");
            int count = Integer.parseInt(sub[0]);
            String[] subsub = sub[1].split("\\.");
            String curr = "";
            for (int i = subsub.length - 1; i >= 0; i--) {
                curr = subsub[i] + curr;
                map.put(curr, map.getOrDefault(curr, 0) + count);
                curr = "." + curr;
            }
        }
        List<String> sol = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            sol.add(value + " " + key);
        }
        return sol;
    }
}
