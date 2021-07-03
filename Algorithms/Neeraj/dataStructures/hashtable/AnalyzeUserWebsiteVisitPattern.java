import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Oct 07, 2020
 * Questions: https://leetcode.com/problems/analyze-user-website-visit-pattern/
 */

public class AnalyzeUserWebsiteVisitPattern {

    public static void main(String[] args) {
//        System.out.println(mostVisitedPattern(
//                new String[]{"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"},
//                new int[]{436363475, 710406388, 386655081, 797150921},
//                new String[]{"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"}
//        ));
//        System.out.println(mostVisitedPattern_rev1(
//                new String[]{"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"},
//                new int[]{436363475, 710406388, 386655081, 797150921},
//                new String[]{"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"}
//        ));

        System.out.println(mostVisitedPattern(
                new String[]{"dowg", "dowg", "dowg"},
                new int[]{158931262, 562600350, 148438945},
                new String[]{"y", "loedo", "y"}
        ));
        System.out.println(mostVisitedPattern_rev1(
                new String[]{"dowg", "dowg", "dowg"},
                new int[]{158931262, 562600350, 148438945},
                new String[]{"y", "loedo", "y"}
        ));
    }

    public static List<String> mostVisitedPattern_rev1(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Analyze>> visitsByUser = new HashMap<>();
        int len = username.length;
        Map<String, Integer> seqCounts = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Analyze analyze = new Analyze(username[i], website[i], timestamp[i]);
            visitsByUser.computeIfAbsent(analyze.user, val -> new ArrayList<>()).add(analyze);
        }
        Comparator<Analyze> order = (p1, p2) -> p1.time == p2.time ? p1.site.compareTo(p2.site) : Integer.compare(p1.time, p2.time);
        for (List<Analyze> visits : visitsByUser.values()) {
            visits.sort(order);
            Set<String> seqs = getSeqs(visits);
            for (String seq : seqs) {
                seqCounts.put(seq, seqCounts.getOrDefault(seq, 0) + 1);
            }
        }
        System.out.println("seqCounts = " + seqCounts);
        String result = "";
        int max = 0;
        for (String key : seqCounts.keySet()) {
            int occ = seqCounts.get(key);
            if (max == 0 || occ > max || (occ == max && result.compareTo(key) > 0)) {
                result = key;
                max = occ;
            }
        }
        return Arrays.asList(result.split(","));
    }

    private static Set<String> getSeqs(List<Analyze> visits) {
        Set<String> seqs = new HashSet<>();
        int len = visits.size();
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    seqs.add(visits.get(i).site + "," + visits.get(j).site + "," + visits.get(k).site);
                }
            }
        }
        return seqs;
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Analyze> patterns = new ArrayList<>();
        int len = username.length, max = 0;
        for (int i = 0; i < len; i++) {
            patterns.add(new Analyze(username[i], website[i], timestamp[i]));
        }
        Comparator<Analyze> order = (p1, p2) -> p1.time == p2.time ? p1.site.compareTo(p2.site) : Integer.compare(p1.time, p2.time);
        patterns.sort(order);
        Map<String, Queue<Analyze>> sites = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
        for (Analyze pat : patterns) {
            sites.computeIfAbsent(pat.user, val -> new LinkedList<>()).add(pat);
            Queue<Analyze> sequences = sites.get(pat.user);
            if (sequences.size() == 3) {
                String curSeq = sequences.stream().map(obj -> obj.site).collect(Collectors.joining(","));
                counts.put(curSeq, counts.getOrDefault(curSeq, 0) + 1);
                sequences.poll();
                max = Math.max(max, counts.get(curSeq));
            }
        }
        System.out.println("counts = " + counts);
        int finalMax = max;
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

        public Analyze(String user, String site, int time) {
            this.user = user;
            this.site = site;
            this.time = time;
        }
    }
}
