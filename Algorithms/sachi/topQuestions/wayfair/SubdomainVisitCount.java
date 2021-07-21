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

    //Input:
    // 9001 discuss.leetcode.com
    //Output:
    //["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] s1 = cpdomain.split(" ");
            int count = Integer.parseInt(s1[0]);
            String domain = s1[1];
            String[] s2 = domain.split("\\.");
            String prev = "";
            for (int i = s2.length - 1; i >= 0; i--) {
                String subdomain;
                if (prev.equals("")) {
                    subdomain = s2[i];
                } else {
                    subdomain = s2[i] + "." + prev;
                }
                map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
                prev = subdomain;
            }
        }
        List<String> sol = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(value).append(" ").append(key);
            sol.add(sb.toString());
        }
        return sol;
    }
}
