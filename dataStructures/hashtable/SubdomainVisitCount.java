import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on:  Sep 16, 2021
 * Ref: https://leetcode.com/problems/subdomain-visit-count/
 */
public class SubdomainVisitCount {
    public static void main(String[] args) {

    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : cpdomains) {
            String[] split = str.split("\\s+");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            increment(domain, count, map);
        }
        return map.entrySet().stream().map(entry -> String.format("%d %s", entry.getValue(), entry.getKey())).collect(Collectors.toList());
    }

    void increment(String str, int count, Map<String, Integer> map) {
        List<Integer> idxs = getIdx(str);
        int len = str.length();
        for (int idx : idxs) {
            String domain = str.substring(idx + 1, len);
            map.put(domain, map.getOrDefault(domain, 0) + count);
        }
    }

    List<Integer> getIdx(String str) {
        List<Integer> idx = new ArrayList<>();
        idx.add(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') idx.add(i);
        }
        return idx;
    }
}
