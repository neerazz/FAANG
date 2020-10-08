import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created on:  Oct 07, 2020
 * Questions: https://leetcode.com/problems/analyze-user-website-visit-pattern/
 */

public class AnalyzeUserWebsiteVisitPattern {

    public static void main(String[] args) {
        System.out.println(mostVisitedPattern(
                new String[]{"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"},
                new int[]{436363475, 710406388, 386655081, 797150921},
                new String[]{"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"}
        ));
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Analyze> patterns = new ArrayList<>();
        int len = username.length, max = 0;
        for (int i = 0; i < len; i++) {
            patterns.add(new Analyze(username[i], website[i], timestamp[i]));
        }
        Comparator<Analyze> order = (p1, p2) -> p1.time == p2.time ? p1.site.compareTo(p2.site) : Integer.compare(p1.time, p2.time);
        Collections.sort(patterns, order);
        Map<String, Queue<Analyze>> sites = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
        for (Analyze pat : patterns) {
            sites.computeIfAbsent(pat.user, val -> new LinkedList<>()).add(pat);
            Queue<Analyze> sequences = sites.get(pat.user);
            if (sequences.size() == 3) {
                String curSeq = sequences.stream().map(obj -> obj.site).collect(Collectors.joining(","));
                System.out.println(curSeq);
                counts.put(curSeq, counts.getOrDefault(curSeq, 0) + 1);
                sequences.poll();
                max = Math.max(max, counts.get(curSeq));
            }
        }
        final int finalMax = max;
        String mostVisited = counts.entrySet().stream().filter(entry -> entry.getValue() == finalMax).map(entry -> entry.getKey()).sorted().findFirst().get();
        String[] splits = mostVisited.split(",");
        List<String> result = new ArrayList<>();
        for (String site : splits) {
            result.add(site);
        }
        return result;
    }

    static class Analyze {
        String user;
        String site;
        int time;

        public Analyze(final String user, final String site, final int time) {
            this.user = user;
            this.site = site;
            this.time = time;
        }
    }
}
