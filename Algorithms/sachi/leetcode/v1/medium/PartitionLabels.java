package leetcode.v1.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> sol = new ArrayList<>();
        if (S == null || S.length() == 0) return sol;
        Map<Character, Pair> counter = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            counter.putIfAbsent(c, new Pair(-1, -1));
            Pair p = counter.get(c);
            if (p.start == -1) {
                p.start = i; //New Entry
            } else {
                p.end = i; //Old Entry - Update end pos
            }
        }

        List<Pair> pairs = new ArrayList<>(counter.values());
        pairs.sort((p1, p2) -> p1.start - p2.start);

        int start = 0, end = 0;
        Pair p;
        for (int i = 0; i < pairs.size(); i++) {
            p = pairs.get(i);
            if (p.start == -1) continue;
            if (p.end == -1) {
                sol.add(1);
                continue;
            }
            start = p.start;
            end = p.end;
            while (i < pairs.size()) {
                p = pairs.get(i);
                if (p.start < end) {
                    end = Math.max(end, p.end);
                    i++;
                } else {
                    i--;
                    break;
                }
            }
            sol.add(end - start + 1);
        }
        return sol;
    }

    static class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        //System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij").toString());
        //System.out.println(partitionLabels.partitionLabels("eccbbbbdec").toString());
        System.out.println(partitionLabels.partitionLabels("caedbdedda").toString());
    }

}
